package com.example.lah3.losaltoshacks3;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CreateTask extends AppCompatActivity {

    private ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);




        listView = (ListView) findViewById(R.id.listView);

        final String[] subtitleList = {"none", "none", "none", "none"};


        final String[] listViewItems = {"Task Name", "Time to complete", "Due Date", "Priority"};

        final ListAdapter adapter = new ListAdapter(this, listViewItems, subtitleList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);
                    final EditText taskName = (EditText) mView.findViewById(R.id.taskName);

                    Button button =  mView.findViewById(R.id.taskButton);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final String myTaskName = taskName.getText().toString();
                            Log.e("hello", "onClick: " + myTaskName,null );
                            subtitleList[0] = myTaskName;
                            listView.setAdapter(adapter);

                        }
                    });

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 1){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.time_to_complete, null);
                    final EditText completionTime = mView.findViewById(R.id.timeToComplete);
                    String timeToComplete = completionTime.getText().toString();
                    Log.e("test", timeToComplete+ "", null);
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 2){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.due_date, null);
                    final DatePicker datePicker = mView.findViewById(R.id.datePicker);
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int day = datePicker.getDayOfMonth();
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 3){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.priority, null);
                    RatingBar rating = mView.findViewById(R.id.ratingBar);
                    final double priority = rating.getNumStars();
                    final TextView testView = mView.findViewById(R.id.testView);

                    final Button priorityButton = mView.findViewById(R.id.button4);

                    priorityButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            testView.setText("" + priority);

                        }



                    });

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }
            }
        });


    }
}
