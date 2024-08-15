package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ComparisonResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparison_results);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        populateGUI();
    }
    public void handleCancelClick(View view) {
        // Return to MainMenu
        Intent intent = new Intent(ComparisonResultsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void handleNewComparisonClick(View view) {
        Intent intent = new Intent(ComparisonResultsActivity.this, CompareJobsActivity.class);
        startActivity(intent);
    }
    private void populateGUI() {
        EditText title1 = findViewById(R.id.compareResultsTitle1);
        EditText title2 = findViewById(R.id.compareResultsTitle2);
        EditText company1 = findViewById(R.id.compareResultsCompany1);
        EditText company2 = findViewById(R.id.compareResultsCompany2);
        EditText location1 = findViewById(R.id.compareResultsLocation1);
        EditText location2 = findViewById(R.id.compareResultsLocation2);
        EditText livingCost1 = findViewById(R.id.compareResultsLivingCost1);
        EditText livingCost2 = findViewById(R.id.compareResultsLivingCost2);
        EditText ySalary1 = findViewById(R.id.compareResultsYSalary1);
        EditText ySalary2 = findViewById(R.id.compareResultsYSalary2);
        EditText yBonus1 = findViewById(R.id.compareResultsYBonus1);
        EditText yBonus2 = findViewById(R.id.compareResultsYBonus2);
        EditText rsu1 = findViewById(R.id.compareResultsRSU1);
        EditText rsu2 = findViewById(R.id.compareResultsRSU2);
        EditText relocation1 = findViewById(R.id.compareResultsRelocation1);
        EditText relocation2 = findViewById(R.id.compareResultsRelocation2);
        EditText holidays1 = findViewById(R.id.compareResultsHolidays1);
        EditText holidays2 = findViewById(R.id.compareResultsHolidays2);

        Job job1 = DatabaseController.getJob1ToCompare(this);
        title1.setText(job1.getTitle());
        company1.setText(job1.getCompany());
        location1.setText(job1.getLocation());
        livingCost1.setText(String.valueOf(job1.getCostOfLiving()));
        ySalary1.setText(String.format(Locale.US, "%.2f", job1.getYearlySalary()));
        yBonus1.setText(String.format(Locale.US, "%.2f", job1.getYearlyBonus()));
        rsu1.setText(String.format(Locale.US, "%.2f", job1.getRestrictedStockUnitAward()));
        relocation1.setText(String.format(Locale.US, "%.2f", job1.getRelocationStipend()));
        holidays1.setText(String.valueOf(job1.getPersonalChoiceHolidays()));

        Job job2 = DatabaseController.getJob2ToCompare(this);
        title2.setText(job2.getTitle());
        company2.setText(job2.getCompany());
        location2.setText(job2.getLocation());
        livingCost2.setText(String.valueOf(job2.getCostOfLiving()));
        ySalary2.setText(String.format(Locale.US, "%.2f", job2.getYearlySalary()));
        yBonus2.setText(String.format(Locale.US, "%.2f", job2.getYearlyBonus()));
        rsu2.setText(String.format(Locale.US, "%.2f", job2.getRestrictedStockUnitAward()));
        relocation2.setText(String.format(Locale.US, "%.2f", job2.getRelocationStipend()));
        holidays2.setText(String.valueOf(job2.getPersonalChoiceHolidays()));

    }
}
