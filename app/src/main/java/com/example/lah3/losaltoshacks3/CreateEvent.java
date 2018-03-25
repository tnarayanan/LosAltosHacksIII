package com.example.lah3.losaltoshacks3;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateEvent extends AppCompatActivity {

    private ListView listView;
    private  DatePicker datePicker;
    FragmentManager fragmentManager = getFragmentManager();

    public static String[][] events;

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(fragmentManager, "tag");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        listView = (ListView) findViewById(R.id.listView);

        String[] listViewItems = {"Event Name", "Start", "End"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 1){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialogue_date, null);
                    //showTimePickerDialog(mView);
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 2){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }
            }
        });


    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }



}

