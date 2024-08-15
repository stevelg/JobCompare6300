package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseController extends SQLiteOpenHelper {
    private static DatabaseController dbController;
    private static int jobID1 = -1, jobID2 = -1, editOfferId = -1;

    private DatabaseController(Context context) {
        super(context, "joffer", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS currentJob ( jobId INTEGER PRIMARY KEY AUTOINCREMENT" +
                "                           , title VARCHAR(30)" +
                "                           , company VARCHAR(30)" +
                "                           , location VARCHAR(30)" +
                "                           , costOfLiving INTEGER" +
                "                           , yearlySalary DOUBLE" +
                "                           , yearlyBonus DOUBLE" +
                "                           , restrictedStockUnitAward DOUBLE" +
                "                           , relocationStipend DOUBLE" +
                "                           , personalChoiceHolidays INTEGER" +
                "                           , score DOUBLE" +
                "                           , isCurrent INTEGER DEFAULT 0" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS adjustComparisonSetting ( weightId INTEGER PRIMARY KEY" +
                "                           , yearlySalaryWeight DOUBLE" +
                "                           , yearlyBonusWeight DOUBLE" +
                "                           , restrictedStockUnitAwardWeight DOUBLE" +
                "                           , relocationStipendWeight DOUBLE" +
                "                           , personalChoiceHolidaysWeight DOUBLE" +
                ");");

        db.execSQL("INSERT INTO adjustComparisonSetting (weightId," +
                " yearlySalaryWeight," +
                " yearlyBonusWeight," +
                "restrictedStockUnitAwardWeight, " +
                "relocationStipendWeight, " +
                "personalChoiceHolidaysWeight) " +
                "VALUES (1, 1, 1, 1, 1, 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldDB, int newDB) {
        database.execSQL("DROP TABLE IF EXISTS currentJob");
        onCreate(database);
    }
    private static void initializeDBController(Context context) {
        if (DatabaseController.dbController == null)
            DatabaseController.dbController = new DatabaseController(context);
    }

    public static void deleteJobsDatabase(Context context) {
        initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS currentJob");
        db.execSQL("CREATE TABLE IF NOT EXISTS currentJob ( jobId INTEGER PRIMARY KEY AUTOINCREMENT" +
                "                           , title VARCHAR(30)" +
                "                           , company VARCHAR(30)" +
                "                           , location VARCHAR(30)" +
                "                           , costOfLiving INTEGER" +
                "                           , yearlySalary DOUBLE" +
                "                           , yearlyBonus DOUBLE" +
                "                           , restrictedStockUnitAward DOUBLE" +
                "                           , relocationStipend DOUBLE" +
                "                           , personalChoiceHolidays INTEGER" +
                "                           , score DOUBLE" +
                "                           , isCurrent INTEGER DEFAULT 0" +
                ");");
    }
    public static boolean saveJob(Context context, Job job){
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title", job.getTitle());
        values.put("company", job.getCompany());
        values.put("location", job.getLocation());
        values.put("costOfLiving", job.getCostOfLiving());
        values.put("yearlySalary", job.getYearlySalary());
        values.put("yearlyBonus", job.getYearlyBonus());
        values.put("restrictedStockUnitAward", job.getRestrictedStockUnitAward());
        values.put("relocationStipend", job.getRelocationStipend());
        values.put("personalChoiceHolidays", job.getPersonalChoiceHolidays());
        values.put("score", job.getScore());
        values.put("isCurrent", job.getIsCurrent());
        int jobId = job.getIsCurrent()? 0 : job.getId();
        if (jobId != -1) {
            db.delete("currentJob", "jobId = " + jobId, null);
            values.put("jobId", jobId);
        }
        long newRowId = db.insert("currentJob", null, values);
        job.setId((int)newRowId); // Assume newRowId is not larger than int value
        return newRowId != -1;
    }

    public static Job getJob(Context context, int jobID) {
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getReadableDatabase();

        String queryString = "SELECT * FROM currentJob WHERE jobId = " + jobID;
        Cursor cursor = db.rawQuery(queryString, null);
        Job job = null;

        if(cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String company = cursor.getString(cursor.getColumnIndexOrThrow("company"));
            String location = cursor.getString(cursor.getColumnIndexOrThrow("location"));
            int costOfLiving = cursor.getInt(cursor.getColumnIndexOrThrow("costOfLiving"));
            double yearlySalary = cursor.getDouble(cursor.getColumnIndexOrThrow("yearlySalary"));
            double yearlyBonus = cursor.getDouble(cursor.getColumnIndexOrThrow("yearlyBonus"));
            double restrictedStockUnitAward = cursor.getDouble(cursor.getColumnIndexOrThrow("restrictedStockUnitAward"));
            double relocationStipend = cursor.getDouble(cursor.getColumnIndexOrThrow("relocationStipend"));
            int personalChoiceHolidays = cursor.getInt(cursor.getColumnIndexOrThrow("personalChoiceHolidays"));
            boolean isCurrent = (cursor.getInt(cursor.getColumnIndexOrThrow("isCurrent")) == 1);

            // Assuming all derived attributes not mentioned here are correctly calculated when constructor is called.
            job = new Job(title, company, location, costOfLiving, yearlySalary, yearlyBonus, restrictedStockUnitAward, relocationStipend, personalChoiceHolidays, isCurrent);
            job.setId(jobID);
        }
        cursor.close();
        return job;
    }

    public static boolean deleteJob(Context context, int jobID) {
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getWritableDatabase();
        String queryString = "SELECT * FROM currentJob WHERE jobId = " + jobID;
        Cursor cursor = db.rawQuery(queryString, null);
        boolean result = false;
        if(cursor.moveToFirst()) {
            db.delete("currentJob", "jobId = " + jobID, null);
            result = true;
        }
        return result;
    }

    public static int numberOfRecords(Context context){
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getReadableDatabase();

        String queryString = "SELECT COUNT(*) FROM currentJob";
        Cursor cursor = db.rawQuery(queryString, null);

        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }

    public static ArrayList<Job> getRankedJobList(Context context){
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getReadableDatabase();

        ArrayList<Job> rankedList = new ArrayList<>();
        String[] projection = {"jobId"};
        String sortOrder = "score DESC";
        updateAllScore(context);

        Cursor cursor = db.query("currentJob", projection, null, null, null, null, sortOrder);

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("jobId"));
            rankedList.add(getJob(context, id));
        }
        cursor.close();
        return rankedList;
    }

    public static Weights getWeights(Context context){
        Weights weights;
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getReadableDatabase();
        String queryString = "SELECT * FROM adjustComparisonSetting WHERE weightId = 1";
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()) {
            int yearlySalaryWeight = cursor.getInt(cursor.getColumnIndexOrThrow("yearlySalaryWeight"));
            int yearlyBonusWeight = cursor.getInt(cursor.getColumnIndexOrThrow("yearlyBonusWeight"));
            int restrictedStockUnitAwardWeight = cursor.getInt(cursor.getColumnIndexOrThrow("restrictedStockUnitAwardWeight"));
            int relocationStipendWeight = cursor.getInt(cursor.getColumnIndexOrThrow("relocationStipendWeight"));
            int personalChoiceHolidaysWeight = cursor.getInt(cursor.getColumnIndexOrThrow("personalChoiceHolidaysWeight"));
            weights = new Weights(yearlySalaryWeight, yearlyBonusWeight, restrictedStockUnitAwardWeight, relocationStipendWeight, personalChoiceHolidaysWeight);
        }
        else {
            weights = new Weights();
        }
        cursor.close();
        return weights;
    }

    public static void setWeights(Context context, Weights newWeights){
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("yearlySalaryWeight", newWeights.getYearlySalaryWeight());
        System.out.println(" it is "+ newWeights.getPersonalChoiceHolidaysWeight()
                        + " " + newWeights.getYearlyBonusWeight()
                        + " " + newWeights.getYearlySalaryWeight()
                        + " " + newWeights.getRestrictedStockUnitAwardWeight()
                        + " " + newWeights.getRelocationStipendWeight());
        values.put("yearlyBonusWeight", newWeights.getYearlyBonusWeight());
        values.put("restrictedStockUnitAwardWeight", newWeights.getRestrictedStockUnitAwardWeight());
        values.put("relocationStipendWeight", newWeights.getRelocationStipendWeight());
        values.put("personalChoiceHolidaysWeight", newWeights.getPersonalChoiceHolidaysWeight());

        db.update("adjustComparisonSetting", values,"weightId = 1", null);
    }

    // This method update the score of the instance only and not in database.
    // Intended to be called by updateAllScore to update scores in db
    private static double calculateScore(Context context, Job job){
        Weights weights = getWeights(context);
        double AYS = 100 * job.getYearlySalary() / job.getCostOfLiving();
        double AYB = 100 * job.getYearlyBonus() / job.getCostOfLiving();
        double RSU = job.getRestrictedStockUnitAward();
        double RELO = job.getRelocationStipend();
        double PCH = job.getPersonalChoiceHolidays();
        int totalWeight = totalWeight(weights);
        double score = (AYS * weights.getYearlySalaryWeight() +
                AYB * weights.getYearlyBonusWeight() +
                RSU / 4 + RELO + PCH * AYS / 260) / totalWeight;
        job.setScore(score);
        return score;
    }

    private static void updateAllScore(Context context) {
        DatabaseController.initializeDBController(context);
        SQLiteDatabase db = DatabaseController.dbController.getWritableDatabase();
        String queryString = "SELECT * FROM currentJob";
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("jobId"));
//              double score = cursor.getDouble(cursor.getColumnIndexOrThrow("score"));
                Job job = getJob(context,id);
                ContentValues values = new ContentValues();
                values.put("score", calculateScore(context, job));
                db.update("currentJob", values, "jobId = " + id, null);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    public static void setJobsToCompare(Context context, int jobID1, int jobID2) {
        DatabaseController.initializeDBController(context);
        DatabaseController.jobID1 = jobID1;
        DatabaseController.jobID2 = jobID2;
    }

    public static Job getJob1ToCompare(Context context) {
        return getJob(context, jobID1);
    }

    public static Job getJob2ToCompare(Context context) {
        return getJob(context, jobID2);
    }

    public static void setEditOfferId(Context context, int jobID) {
        DatabaseController.initializeDBController(context);
        DatabaseController.editOfferId = jobID;
    }

    public static Job getEditJobOffer(Context context) {
        Job jobOffer = null;
        if (editOfferId != -1) {
            jobOffer = getJob(context, editOfferId);
            editOfferId = -1;
        }
        return jobOffer;
    }

    private static int totalWeight(Weights weights){
        return weights.getRelocationStipendWeight() +
                weights.getYearlyBonusWeight() +
                weights.getYearlySalaryWeight() +
                weights.getRestrictedStockUnitAwardWeight() +
                weights.getPersonalChoiceHolidaysWeight();
    }
}
