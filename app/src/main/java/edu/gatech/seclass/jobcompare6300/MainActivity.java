package edu.gatech.seclass.jobcompare6300;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.MotionEffect;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.main_bar_layout);
    }
    public void handleCurrentJobClick(View view) {
        Intent intent = new Intent(MainActivity.this, CurrentJobActivity.class);
        startActivity(intent);
    }
    public void handleJobOffersClick(View view) {
        Intent intent = new Intent(MainActivity.this, JobOffersActivity.class);
        startActivity(intent);
    }
    public void handleComparisonSettingsClick(View view) {
        Intent intent = new Intent(MainActivity.this, AdjustWeightsActivity.class);
        startActivity(intent);
    }
    public void handleCompareJobsClick(View view) {
        if (DatabaseController.numberOfRecords(this) > 1) {
            Intent intent = new Intent(MainActivity.this, CompareJobsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "At least two jobs should be entered for this option!", Toast.LENGTH_LONG).show();
        }
    }

}