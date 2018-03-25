package com.example.lah3.losaltoshacks3;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.lah3.losaltoshacks3.Backend.Event;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateEvent extends AppCompatActivity {

    public static ArrayList<String[]> events;

    static String[] event = {"", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);



        Button createTheEvent = (Button) findViewById(R.id.createEvent);
        final EditText name = (EditText) findViewById(R.id.name);
        ConstraintLayout startDate = (ConstraintLayout) findViewById(R.id.startDateLayout);
        ConstraintLayout endDate = (ConstraintLayout) findViewById(R.id.endDateLayout);
        ConstraintLayout startTime = (ConstraintLayout) findViewById(R.id.startTimeLayout);
        ConstraintLayout endTime = (ConstraintLayout) findViewById(R.id.endTimeLayout);

        final TextView startDateField = (TextView) findViewById(R.id.startDateField);
        final TextView startTimeField = (TextView) findViewById(R.id.startTimeField);
        final TextView endDateField = (TextView) findViewById(R.id.endDateField);
        final TextView endTimeField = (TextView) findViewById(R.id.endTimeField);



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
                        final String endDateString = endDate.getMonth() + "/" + endDate.getDayOfMonth() + "/" + endDate.getYear();
                        event[3] = endDateString;
                        endDateField.setText(endDateString);
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
                        final String startDateString = (startDate.getMonth() + 1) + "/" + startDate.getDayOfMonth() + "/" + startDate.getYear();
                        event[1] = startDateString;
                        startDateField.setText(startDateString);
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
                        final String startTimeString = startTime.getHour() + ":" + startTime.getMinute();
                        event[2] = startTimeString;
                        startTimeField.setText(startTimeString);
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
                        final String endTimeString = endTime.getHour() + ":" + endTime.getMinute();
                        event[4] = endTimeString;
                        endTimeField.setText(endTimeString);
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
            event[0] = name.getText().toString();
            events.add(event);

            Calendar eventStartTimeCal = Calendar.getInstance();
            String[] eventStartTime = event[2].split(":");
            eventStartTimeCal.set(Calendar.HOUR, Integer.parseInt(eventStartTime[0]));
            eventStartTimeCal.set(Calendar.MINUTE, Integer.parseInt(eventStartTime[1]));

            String[] eventStartDate = event[1].split("/");
            eventStartTimeCal.set(Calendar.MONTH, Integer.parseInt(eventStartDate[0]));
            eventStartTimeCal.set(Calendar.DATE, Integer.parseInt(eventStartDate[1]));
            eventStartTimeCal.set(Calendar.YEAR, Integer.parseInt(eventStartDate[2]));

            eventStartTimeCal.set(Calendar.MILLISECOND, 0);



            Calendar eventEndTimeCal = Calendar.getInstance();
            String[] eventEndTime = event[4].split(":");
            eventEndTimeCal.set(Calendar.HOUR, Integer.parseInt(eventEndTime[0]));
            eventEndTimeCal.set(Calendar.MINUTE, Integer.parseInt(eventEndTime[1]));

            String[] eventEndDate = event[3].split("/");
            eventEndTimeCal.set(Calendar.MONTH, Integer.parseInt(eventEndDate[0]));
            eventEndTimeCal.set(Calendar.DATE, Integer.parseInt(eventEndDate[1]));
            eventEndTimeCal.set(Calendar.YEAR, Integer.parseInt(eventEndDate[2]));

            eventEndTimeCal.set(Calendar.MILLISECOND, 0);

            Event eventObj = new Event(event[0], eventStartTimeCal, eventEndTimeCal);

            WeekViewTest.userSchedule.addEvent(eventObj);
            }
        });

    }


}

