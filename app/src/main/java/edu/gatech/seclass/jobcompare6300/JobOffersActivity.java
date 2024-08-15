package edu.gatech.seclass.jobcompare6300;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class JobOffersActivity extends AppCompatActivity {
    private Job currentOffer;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_offer_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        inputTitle = findViewById(R.id.editOfferTitle);
        inputCompany = findViewById(R.id.editOfferCompany);
        inputLocation = findViewById(R.id.editOfferLocation);
        inputLivingCost = findViewById(R.id.editOfferLivingCost);
        inputYearlySalary = findViewById(R.id.editOfferYearlySalary);
        inputYearlyBonus  = findViewById(R.id.editOfferYearlyBonus);
        inputRSUAward = findViewById(R.id.editOfferRSU);
        inputRelocation = findViewById(R.id.editOfferRelocation);
        inputHolidays = findViewById(R.id.editOfferHolidays);
        currentOffer = DatabaseController.getEditJobOffer(this);
        if (currentOffer == null)
            emptyGUI();
        else
            populateGUI();
    }
    public void handleCancelClick(View view) {
        // Return to MainMenu without saving
        Intent intent = new Intent(JobOffersActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void handleSaveClick(View view) {
        // Save current offer and stay in same window
        saveCurrentJobOffer();
    }
    public void handleNewOfferClick(View view) {
        if (isCurrentJobOfferSaved()) {
            emptyGUI();
            currentOffer = null;
        } else {
            confirmAndClearGUI();
        }
    }
    public void handleCompareClick(View view) {
        if (DatabaseController.getJob(this, 0) != null) {
            if (isCurrentJobOfferSaved()) {
                DatabaseController.setJobsToCompare(this, 0, currentOffer.getId());
                Intent intent = new Intent(JobOffersActivity.this, ComparisonResultsActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Current job offer is not saved!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Current job is not available!", Toast.LENGTH_LONG).show();
        }
    }
    private void emptyGUI() {
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
    }
    private void populateGUI() {
        inputTitle.setText(currentOffer.getTitle());
        inputCompany.setText(currentOffer.getCompany());
        inputLocation.setText(currentOffer.getLocation());
        inputLivingCost.setText(String.valueOf(currentOffer.getCostOfLiving()));
        inputYearlySalary.setText(String.format(Locale.US, "%.2f", currentOffer.getYearlySalary()));
        inputYearlyBonus.setText(String.format(Locale.US, "%.2f", currentOffer.getYearlyBonus()));
        inputRSUAward.setText(String.format(Locale.US, "%.2f", currentOffer.getRestrictedStockUnitAward()));
        inputRelocation.setText(String.format(Locale.US, "%.2f", currentOffer.getRelocationStipend()));
        inputHolidays.setText(String.valueOf(currentOffer.getPersonalChoiceHolidays()));
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

        if (currentOffer == null) {
            currentOffer = new Job();
            currentOffer.setIsCurrent(false);
        }

        // Title
        input = inputTitle.getText().toString();
        if (validString(input)) {
            currentOffer.setTitle(input);
        } else {
            success = false;
            inputTitle.setError("Required Entry");
        }

        // Company
        input = inputCompany.getText().toString();
        if (validString(input)) {
            currentOffer.setCompany(input);
        } else {
            success = false;
            inputCompany.setError("Required Entry");
        }

        // Location
        input = inputLocation.getText().toString();
        if (validLocation(input)) {
            currentOffer.setLocation(input);
        } else {
            success = false;
            inputLocation.setError("[City, State] entry is required");
        }

        // Cost of Living
        intValue = convertToInteger(inputLivingCost.getText().toString());
        if (intValue > 0) {
            currentOffer.setCostOfLiving(intValue);
        } else {
            inputLivingCost.setError("Entry must be a positive integer");
            success = false;
        }

        // Yearly Salary
        doubleValue = convertToDouble(inputYearlySalary.getText().toString());
        if (doubleValue > 0) {
            currentOffer.setYearlySalary(doubleValue);
        } else {
            inputYearlySalary.setError("Entry must be a positive value");
            success = false;
        }

        // Yearly Bonus
        doubleValue = convertToDouble(inputYearlyBonus.getText().toString());
        if (doubleValue > 0) {
            currentOffer.setYearlyBonus(doubleValue);
        } else {
            inputYearlyBonus.setError("Entry must be a positive value");
            success = false;
        }

        // RSU Award
        doubleValue = convertToDouble(inputRSUAward.getText().toString());
        if (doubleValue > 0) {
            currentOffer.setRestrictedStockUnitAward(doubleValue);
        } else {
            inputRSUAward.setError("Entry must be a positive value");
            success = false;
        }

        // Relocation
        doubleValue = convertToDouble(inputRelocation.getText().toString());
        if (doubleValue >= 0 && doubleValue <= 25000) {
            currentOffer.setRelocationStipend(doubleValue);
        } else {
            inputRelocation.setError("Entry must be a value in [0, 25000]");
            success = false;
        }

        // Personal Holidays
        intValue = convertToInteger(inputHolidays.getText().toString());
        if (intValue >= 0 && intValue <= 20)  {
            currentOffer.setPersonalChoiceHolidays(intValue);
        } else {
            inputHolidays.setError("Entry must be an integer in [0, 20]");
            success = false;
        }
        return success;
    }

    private boolean saveCurrentJobOffer() {
        boolean success = false;
        if (updateJobFromGUI()) {
            if (!DatabaseController.saveJob(this, currentOffer)) {
                Toast.makeText(getApplicationContext(), "Error while saving job offer!", Toast.LENGTH_LONG).show();
            } else {
                success = true;
            }
        }
        return success;
    }

    private boolean isCurrentJobOfferSaved() {
        boolean result = false;
        if (updateJobFromGUI()) {
            Job savedOffer = DatabaseController.getJob(this, currentOffer.getId());
            result = savedOffer != null &&
                    currentOffer.getTitle().equals(savedOffer.getTitle()) &&
                    currentOffer.getCompany().equals(savedOffer.getCompany()) &&
                    currentOffer.getLocation().equals(savedOffer.getLocation()) &&
                    currentOffer.getCostOfLiving() == savedOffer.getCostOfLiving() &&
                    currentOffer.getYearlySalary() == savedOffer.getYearlySalary() &&
                    currentOffer.getYearlyBonus() == savedOffer.getYearlyBonus() &&
                    currentOffer.getRestrictedStockUnitAward() == savedOffer.getRestrictedStockUnitAward() &&
                    currentOffer.getRelocationStipend() == savedOffer.getRelocationStipend() &&
                    currentOffer.getPersonalChoiceHolidays() == savedOffer.getPersonalChoiceHolidays();
        }
        return result;
    }
    private void confirmAndClearGUI() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    emptyGUI();
                    currentOffer = null;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Current offer is not saved, continue?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
