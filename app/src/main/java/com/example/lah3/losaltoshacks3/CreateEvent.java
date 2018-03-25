package com.example.lah3.losaltoshacks3;

import android.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class CreateEvent extends AppCompatActivity {

    private ListView listView;
    private  DatePicker datePicker;
    FragmentManager fragmentManager = getFragmentManager();

    public static ArrayList<String[]> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        listView = (ListView) findViewById(R.id.listView);

        final String[] listViewItems = {"Event Name", "Start", "End"};
        final String[] task = {"", "", "", "", ""};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialogue_name, null);

                    Button submitName = (Button) mView.findViewById(R.id.submitEventName);
                    final EditText eventName = (EditText) mView.findViewById(R.id.eventName);

                    submitName.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String name = eventName.getText().toString();
                            task[0] = name;
                        }
                    });

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 1){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialogue_date_start, null);

                    final DatePicker datePicker = (DatePicker) mView.findViewById(R.id.datePicker);
                    final TimePicker timePicker = (TimePicker) mView.findViewById(R.id.timePicker);
                    Button submitStartTime = (Button) mView.findViewById(R.id.submitStart);
                    submitStartTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String date = datePicker.getMonth() + " " + datePicker.getDayOfMonth() + " " + datePicker.getYear();
                            task[1] = date;

                            String time = timePicker.getHour() + " " + timePicker.getMinute();
                            task[2] = time;

                        }
                    });

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 2){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateEvent.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    final DatePicker datePicker1 = (DatePicker) mView.findViewById(R.id.datePicker);
                    final TimePicker timePicker1 = (TimePicker) mView.findViewById(R.id.timePicker);
                    Button submitStartTime = (Button) mView.findViewById(R.id.submitStart);
                    submitStartTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String date = datePicker1.getMonth() + " " + datePicker1.getDayOfMonth() + " " + datePicker1.getYear();
                            task[3] = date;

                            String time = timePicker1.getHour() + " " + timePicker1.getMinute();
                            task[4] = time;

                        }
                    });

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }
            }
        });

        Button createTask = (Button) findViewById(R.id.createTask);
        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                events.add(task);
            }
        });


    }


}

