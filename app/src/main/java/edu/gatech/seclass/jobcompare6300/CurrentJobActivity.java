package edu.gatech.seclass.jobcompare6300;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CurrentJobActivity extends AppCompatActivity {
    private Job currentJob;
    private EditText inputTitle;
    private EditText inputCompany;
    private EditText inputLocation;
    private EditText inputLivingCost;
    private EditText inputYearlySalary;
    private EditText inputYearlyBonus;
    private EditText inputRSUAward;
    private EditText inputRelocation;
    private EditText inputHolidays;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Log.d(TAG, "CurrentJob onCreate: Starting...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_job_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        populateGUI();
    }
    public void handleCancelClick(View view) {
        // Return to MainMenu without saving
        Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void handleSaveClick(View view) {
        // Return to MainMenu after saving
        if (updateJobFromGUI()) {
            DatabaseController.saveJob(this, currentJob);
            Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    private void populateGUI() {
        inputTitle = findViewById(R.id.editTextTitle);
        inputCompany = findViewById(R.id.editTextCompany);
        inputLocation = findViewById(R.id.editTextLocation);
        inputLivingCost = findViewById(R.id.editTextLivingCost);
        inputYearlySalary = findViewById(R.id.editTextYearlySalary);
        inputYearlyBonus  = findViewById(R.id.editTextYearlyBonus);
        inputRSUAward = findViewById(R.id.editTextRSU);
        inputRelocation = findViewById(R.id.editTextRelocation);
        inputHolidays = findViewById(R.id.editTextHolidays);
        currentJob = DatabaseController.getJob(this, 0); // Current Job has ID = '0'
        if (currentJob == null) {
            // Keep boxes all empty
            inputTitle.setText("");
            inputCompany.setText("");
            inputLocation.setText("");
            inputLivingCost.setText("");
            inputYearlySalary.setText("");
            inputYearlyBonus.setText("");
            inputRSUAward.setText("");
            inputRelocation.setText("");
            inputHolidays.setText("");
        } else {
            // Populate data is current job is valid
            inputTitle.setText(currentJob.getTitle());
            inputCompany.setText(currentJob.getCompany());
            inputLocation.setText(currentJob.getLocation());
            inputLivingCost.setText(String.valueOf(currentJob.getCostOfLiving()));
            inputYearlySalary.setText(String.format(Locale.US, "%.2f", currentJob.getYearlySalary()));
            inputYearlyBonus.setText(String.format(Locale.US, "%.2f", currentJob.getYearlyBonus()));
            inputRSUAward.setText(String.format(Locale.US, "%.2f", currentJob.getRestrictedStockUnitAward()));
            inputRelocation.setText(String.format(Locale.US, "%.2f", currentJob.getRelocationStipend()));
            inputHolidays.setText(String.valueOf(currentJob.getPersonalChoiceHolidays()));
        }
    }
    private boolean validString(String str) {
        return (str != null && str.length() > 0);
    }
    private boolean validLocation(String str) {
        return validString(str) && (str.split(",")).length == 2;
    }
    private int convertToInteger(String strValue) {
        int result;
        try {
            result = Integer.parseInt(strValue);
        } catch (Exception e) {
            result = -1;
        }
        return result;
    }
    private double convertToDouble(String strValue) {
        double result;
        try {
            result = Double.parseDouble(strValue);
        } catch (Exception e) {
            result = -1.0;
        }
        return result;
    }
    private boolean updateJobFromGUI() {
        boolean success = true;
        String input;
        int intValue;
        double doubleValue;

        if (currentJob == null) {
            currentJob = new Job();
            currentJob.setIsCurrent(true);
        }

        // Title
        input = inputTitle.getText().toString();
        if (validString(input)) {
            currentJob.setTitle(input);
        } else {
            success = false;
            inputTitle.setError("Required Entry");
        }

        // Company
        input = inputCompany.getText().toString();
        if (validString(input)) {
            currentJob.setCompany(input);
        } else {
            success = false;
            inputCompany.setError("Required Entry");
        }

        // Location
        input = inputLocation.getText().toString();
        if (validLocation(input)) {
            currentJob.setLocation(input);
        } else {
            success = false;
            inputLocation.setError("[City, State] entry is required");
        }

        // Cost of Living
        intValue = convertToInteger(inputLivingCost.getText().toString());
        if (intValue > 0) {
            currentJob.setCostOfLiving(intValue);
        } else {
            inputLivingCost.setError("Entry must be a positive integer");
            success = false;
        }

        // Yearly Salary
        doubleValue = convertToDouble(inputYearlySalary.getText().toString());
        if (doubleValue > 0) {
            currentJob.setYearlySalary(doubleValue);
        } else {
            inputYearlySalary.setError("Entry must be a positive value");
            success = false;
        }

        // Yearly Bonus
        doubleValue = convertToDouble(inputYearlyBonus.getText().toString());
        if (doubleValue > 0) {
            currentJob.setYearlyBonus(doubleValue);
        } else {
            inputYearlyBonus.setError("Entry must be a positive value");
            success = false;
        }

        // RSU Award
        doubleValue = convertToDouble(inputRSUAward.getText().toString());
        if (doubleValue > 0) {
            currentJob.setRestrictedStockUnitAward(doubleValue);
        } else {
            inputRSUAward.setError("Entry must be a positive value");
            success = false;
        }

        // Relocation
        doubleValue = convertToDouble(inputRelocation.getText().toString());
        if (doubleValue >= 0 && doubleValue <= 25000) {
            currentJob.setRelocationStipend(doubleValue);
        } else {
            inputRelocation.setError("Entry must be a value in [0, 25000]");
            success = false;
        }

        // Personal Holidays
        intValue = convertToInteger(inputHolidays.getText().toString());
        if (intValue >= 0 && intValue <= 20)  {
            currentJob.setPersonalChoiceHolidays(intValue);
        } else {
            inputHolidays.setError("Entry must be an integer in [0, 20]");
            success = false;
        }
        return success;
    }
}
