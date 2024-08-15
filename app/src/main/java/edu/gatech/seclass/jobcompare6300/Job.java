package edu.gatech.seclass.jobcompare6300;

public class Job {
    private int id;
    private String title;
    private String company;
    private String location;

    private int costOfLiving;
    private int personalChoiceHolidays;
    private int ranking;

    private double yearlySalary;
    private double yearlyBonus;
    private double restrictedStockUnitAward;
    private double relocationStipend;
    private double score;
    private boolean isCurrent;
    public Job() {
        this.id = -1;
    }

    public Job(String title,
               String company,
               String location,
               int costOfLiving,
               double yearlySalary,
               double yearlyBonus,
               double restrictedStockUnitAward,
               double relocationStipend,
               int personalChoiceHolidays,
               boolean isCurrent) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.restrictedStockUnitAward = restrictedStockUnitAward;
        this.relocationStipend = relocationStipend;
        this.personalChoiceHolidays = personalChoiceHolidays;

        this.id = -1;
        this.ranking = 0;
        this.score = 0;
        this.isCurrent = isCurrent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(int costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    public int getPersonalChoiceHolidays() {
        return personalChoiceHolidays;
    }

    public void setPersonalChoiceHolidays(int personalChoiceHolidays) {
        this.personalChoiceHolidays = personalChoiceHolidays;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public double getRestrictedStockUnitAward() {
        return restrictedStockUnitAward;
    }

    public void setRestrictedStockUnitAward(double restrictedStockUnitAward) {
        this.restrictedStockUnitAward = restrictedStockUnitAward;
    }

    public double getRelocationStipend() {
        return relocationStipend;
    }

    public void setRelocationStipend(double relocationStipend) {
        this.relocationStipend = relocationStipend;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }
}