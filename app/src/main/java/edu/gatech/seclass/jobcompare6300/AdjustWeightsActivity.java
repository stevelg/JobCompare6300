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

public class AdjustWeightsActivity extends AppCompatActivity {
    private Weights currentWeights;
    private EditText inputYearlySalary;
    private EditText inputYearlyBonus;
    private EditText inputRSUAward;
    private EditText inputRelocation;
    private EditText inputHolidays;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weights_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        populateGUI();
    }
    public void handleCancelClick(View view) {
        Intent intent = new Intent(AdjustWeightsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void handleSaveClick(View view) {
        // Return to MainMenu after saving
        if (updateWeightsFromGUI()) {
            DatabaseController.setWeights(this, currentWeights);
            Intent intent = new Intent(AdjustWeightsActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    private void populateGUI() {
        inputYearlySalary = findViewById(R.id.editTextYearlySalaryWeight);
        inputYearlyBonus  = findViewById(R.id.editTextYearlyBonusWeight);
        inputRSUAward = findViewById(R.id.editTextRSUWeight);
        inputRelocation = findViewById(R.id.editTextRelocationWeight);
        inputHolidays = findViewById(R.id.editTextHolidaysWeight);
        currentWeights = DatabaseController.getWeights(this);
        inputYearlySalary.setText(String.valueOf(currentWeights.getYearlySalaryWeight()));
        inputYearlyBonus.setText(String.valueOf(currentWeights.getYearlyBonusWeight()));
        inputRSUAward.setText(String.valueOf(currentWeights.getRestrictedStockUnitAwardWeight()));
        inputRelocation.setText(String.valueOf(currentWeights.getRelocationStipendWeight()));
        inputHolidays.setText(String.valueOf(currentWeights.getPersonalChoiceHolidaysWeight()));
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
    private boolean updateWeightsFromGUI() {
        boolean success = true;
        int input;
        String errorMsg = "Positive integer expected!";

        // Yearly Salary Weight
        input = convertToInteger(inputYearlySalary.getText().toString());
        if (input > 0) {
            currentWeights.setYearlySalaryWeight(input);
        } else {
            inputYearlySalary.setError(errorMsg);
            success = false;
        }
        // Yearly Bonus Weight
        input = convertToInteger(inputYearlyBonus.getText().toString());
        if (input > 0) {
            currentWeights.setYearlyBonusWeight(input);
        } else {
            inputYearlyBonus.setError(errorMsg);
            success = false;
        }
        // RSU award Weight
        input = convertToInteger(inputRSUAward.getText().toString());
        if (input > 0) {
            currentWeights.setRestrictedStockUnitAwardWeight(input);
        } else {
            inputRSUAward.setError(errorMsg);
            success = false;
        }
        // Relocation Weight
        input = convertToInteger(inputRelocation.getText().toString());
        if (input > 0) {
            currentWeights.setRelocationStipendWeight(input);
        } else {
            inputRelocation.setError(errorMsg);
            success = false;
        }
        // Personal Choice Holidays Weight
        input = convertToInteger(inputHolidays.getText().toString());
        if (input > 0) {
            currentWeights.setPersonalChoiceHolidaysWeight(input);
        } else {
            inputHolidays.setError(errorMsg);
            success = false;
        }
        return success;
    }
}
