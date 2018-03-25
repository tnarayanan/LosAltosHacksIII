package com.example.lah3.losaltoshacks3;

import android.app.FragmentManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateEvent extends AppCompatActivity {

    public static ArrayList<String[]> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        final String[] task = {"", "", "", "", ""};

        Button createTheEvent = (Button) findViewById(R.id.createEvent);
        final EditText name = (EditText) findViewById(R.id.name);
        ConstraintLayout startDate = (ConstraintLayout) findViewById(R.id.startDateLayout);
        ConstraintLayout endDate = (ConstraintLayout) findViewById(R.id.endDateLayout);
        ConstraintLayout startTime = (ConstraintLayout) findViewById(R.id.startTimeLayout);
        ConstraintLayout endTime = (ConstraintLayout) findViewById(R.id.endTimeLayout);

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                View mView = getLayoutInflater().inflate(R.layout.pick_date, null);
                final DatePicker endDate = (DatePicker) mView.findViewById(R.id.datePicker);

                Button button =  mView.findViewById(R.id.confirmDate);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String endDateString = endDate.getMonth() + " " + endDate.getDayOfMonth() + " " + endDate.getYear();
                        task[3] = endDateString;
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                View mView = getLayoutInflater().inflate(R.layout.pick_date, null);
                final DatePicker startDate = (DatePicker) mView.findViewById(R.id.datePicker);

                Button button =  mView.findViewById(R.id.confirmDate);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String startDateString = (startDate.getMonth() + 1) + " " + startDate.getDayOfMonth() + " " + startDate.getYear();
                        task[1] = startDateString;
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                View mView = getLayoutInflater().inflate(R.layout.pick_time, null);
                final TimePicker startTime = (TimePicker) mView.findViewById(R.id.timePicker);

                Button button =  mView.findViewById(R.id.confirmTime);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String startTimeString = startTime.getHour() + " " + startTime.getMinute();
                        task[2] = startTimeString;
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                View mView = getLayoutInflater().inflate(R.layout.pick_time, null);
                final TimePicker endTime = (TimePicker) mView.findViewById(R.id.timePicker);

                Button button =  mView.findViewById(R.id.confirmTime);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String endTimeString = endTime.getHour() + " " + endTime.getMinute();
                        task[4] = endTimeString;
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        createTheEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task[0] = name.getText().toString();
                events.add(task);

                Calendar event_end_time = Calendar.getInstance();
                event_end_time.set(Calendar.DATE);
            }
        });

    }


}

