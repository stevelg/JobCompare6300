package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CompareJobsActivity extends AppCompatActivity {
    private Set<Integer> selectedJobs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_jobs_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        selectedJobs = new HashSet<>();
        updateGUI();
    }
    public void handleCancelClick(View view) {
        // Return to MainMenu
        Intent intent = new Intent(CompareJobsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void handleCompareClick(View view) {
        if (selectedJobs.size() == 2) {
            Integer[] jobIDs = selectedJobs.toArray(new Integer[0]);
            DatabaseController.setJobsToCompare(this, jobIDs[0], jobIDs[1]);
            Intent intent = new Intent(CompareJobsActivity.this, ComparisonResultsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Select exactly two jobs to compare!", Toast.LENGTH_LONG).show();
        }
    }
    public void handleDeleteClick(View view) {
        Context context = this;
        if (selectedJobs.size() == DatabaseController.numberOfRecords(context)) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        DatabaseController.deleteJobsDatabase(context);
                        handleCancelClick(view);
                    }
                }
            };
            String msg = "CONFIRM TO REMOVE ENTIRE JOBS DATABASE";
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("WARNING!!!");
            builder.setMessage(msg).setPositiveButton("YES", dialogClickListener)
                    .setNegativeButton("NO", dialogClickListener).show();
        }
        else if (selectedJobs.size() == 1) {
            Job job = DatabaseController.getJob(context, selectedJobs.toArray(new Integer[0])[0]);
            if (job != null) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            DatabaseController.deleteJob(context, job.getId());
                            if (DatabaseController.numberOfRecords(context) > 1) {
                                Intent intent = new Intent(CompareJobsActivity.this, CompareJobsActivity.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(CompareJobsActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                };
                String msg = "Confirm to delete Job 'Title: " + job.getTitle() + ", Company: " + job.getCompany();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Warning!");
                builder.setMessage(msg).setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
            selectedJobs.clear();
        } else {
            Toast.makeText(getApplicationContext(), "Select ALL or ONE job to delete!", Toast.LENGTH_LONG).show();
        }
    }
    public void handleEditClick(View view) {
        Context context = this;
        if (selectedJobs.size() == 1) {
            int jobId = selectedJobs.toArray(new Integer[0])[0];
            if (jobId == 0) {
                Intent intent = new Intent(CompareJobsActivity.this, CurrentJobActivity.class);
                startActivity(intent);
            } else {
                DatabaseController.setEditOfferId(context, jobId);
                Intent intent = new Intent(CompareJobsActivity.this, JobOffersActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Select ONE job to edit!", Toast.LENGTH_LONG).show();
        }
    }
    private void updateGUI() {
        TableLayout table = (TableLayout) findViewById(R.id.compareJobsTableID);
        ArrayList<Job> jobList = DatabaseController.getRankedJobList(this);
        if (jobList != null) {
            int rank = 1;
            for (Job job : jobList) {
                TableRow row = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT);
                row.setLayoutParams(lp);

                int bkgColor = job.getIsCurrent() ? Color.YELLOW : Color.WHITE;
                TextView num = new TextView(this);
                num.setText(String.valueOf(rank));
                num.setTextColor(Color.BLACK);
                num.setBackgroundColor(bkgColor);
                num.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                num.setTextSize(2, 20);
                num.setPadding(0, 5, 0, 5);

                TextView title = new TextView(this);
                title.setText(job.getTitle());
                title.setTextColor(Color.BLACK);
                title.setBackgroundColor(bkgColor);
                title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                title.setTextSize(2, 20);
                title.setPadding(0, 5, 0, 5);

                TextView company = new TextView(this);
                company.setText(job.getCompany());
                company.setTextColor(Color.BLACK);
                company.setBackgroundColor(bkgColor);
                company.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                company.setTextSize(2, 20);
                company.setPadding(0, 5, 0, 5);

                CheckBox check = new CheckBox(this);
                check.setBackgroundColor(Color.WHITE);
                check.setOnClickListener(v -> {
                    if (((CheckBox) v).isChecked()){
                        selectedJobs.add(job.getId());
                    } else {
                        selectedJobs.remove(job.getId());
                    }
                });

                row.addView(check);
                row.addView(num);
                row.addView(title);
                row.addView(company);
                table.addView(row, rank);
                rank++;
            }
        }
    }
}
