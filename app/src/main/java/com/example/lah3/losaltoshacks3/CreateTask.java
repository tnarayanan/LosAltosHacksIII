package com.example.lah3.losaltoshacks3;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lah3.losaltoshacks3.Backend.Homework;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTask extends AppCompatActivity {

    //private ListView listView;

    public ArrayList<String[]> tasksArray;

    EditText taskNameField;
    EditText timeToComplete;
    TextView dueDate;
    RatingBar priorityBar;

    ConstraintLayout dueDateLayout;
    Button createTaskButton;

    //{name, time to finish, priority, due date}
    String[] task = {"", "", "", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);




        taskNameField = (EditText) findViewById(R.id.name);
        timeToComplete = (EditText) findViewById(R.id.timeToComplete);
        dueDate = (TextView) findViewById(R.id.dueDate);
        priorityBar = (RatingBar) findViewById(R.id.priorityBar);
        createTaskButton = (Button) findViewById(R.id.createTask);

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName  = taskNameField.getText().toString();
                task[0] = taskName;
                String timeToFinish = timeToComplete.getText().toString();
                task[1] = timeToFinish;
                int priority = priorityBar.getNumStars();
                task[2] = "" + priority;

                tasksArray.add(task);


                Calendar dueDate = Calendar.getInstance();
                String[] taskDate = task[3].split("/");
                dueDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(taskDate[1]));
                dueDate.set(Calendar.MONTH, Integer.parseInt(taskDate[0]));
                dueDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(taskDate[3]));

                dueDate.set(Calendar.MILLISECOND, 0);

                Homework homework = new Homework(task[0], dueDate, Double.parseDouble(task[1]), Integer.parseInt(task[2]));

                homework.createScheduleAroundHW();






            }
        });



        dueDateLayout = (ConstraintLayout) findViewById(R.id.startTimeLayout);



        dueDateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.due_date, null);
                    final DatePicker datePicker = mView.findViewById(R.id.datePicker);

                    Button datePickerButton = mView.findViewById(R.id.datePickerButton);

                    datePickerButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int year = datePicker.getYear();
                            int month = datePicker.getMonth() + 1;
                            int day = datePicker.getDayOfMonth();

                            String date = month + "/" + day + "/" + year;
                            task[3] = date;
                            dueDate.setText(date);



                        }
                    });


                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();
            }
        });









        //listView = (ListView) findViewById(R.id.listView);

        //final String[] subtitleList = {"none", "none", "none", "none"};


//        final String[] listViewItems = {"Task Name", "Time to complete", "Due Date", "Priority"};
//
//        final ListAdapter adapter = new ListAdapter(this, listViewItems, subtitleList);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i == 0){
//
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
//                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);
//                    final EditText taskName = (EditText) mView.findViewById(R.id.taskName);
//
//                    Button button =  mView.findViewById(R.id.taskButton);
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            final String myTaskName = taskName.getText().toString();
//                            Log.e("hello", "onClick: " + myTaskName,null );
//                            subtitleList[0] = myTaskName;
//                            listView.setAdapter(adapter);
//
//                        }
//                    });
//
//                    mBuilder.setView(mView);
//                    AlertDialog dialog = mBuilder.create();
//                    dialog.show();
//
//                }else if(i == 1){
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
//                    View mView = getLayoutInflater().inflate(R.layout.time_to_complete, null);
//                    final EditText completionTime = mView.findViewById(R.id.timeToComplete);
//                    final Button submitHours = (Button) mView.findViewById(R.id.button2);
//                    submitHours.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            final String numHours = completionTime.getText().toString();
//                            subtitleList[2] = numHours;
//                            listView.setAdapter(adapter);
//                        }
//                    });
//                    String timeToComplete = completionTime.getText().toString();
//                    Log.e("test", timeToComplete+ "", null);
//                    mBuilder.setView(mView);
//                    AlertDialog dialog = mBuilder.create();
//                    dialog.show();
//
//                }else if(i == 2){
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
//                    View mView = getLayoutInflater().inflate(R.layout.due_date, null);
//                    final DatePicker datePicker = mView.findViewById(R.id.datePicker);
//                    int year = datePicker.getYear();
//                    int month = datePicker.getMonth();
//                    int day = datePicker.getDayOfMonth();
//                    mBuilder.setView(mView);
//                    AlertDialog dialog = mBuilder.create();
//                    dialog.show();
//
//                }else if(i == 3){
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
//                    View mView = getLayoutInflater().inflate(R.layout.priority, null);
//                    RatingBar rating = mView.findViewById(R.id.ratingBar);
//                    final double priority = rating.getNumStars();
//                    final TextView testView = mView.findViewById(R.id.testView);
//
//                    final Button priorityButton = mView.findViewById(R.id.button4);
//
//                    priorityButton.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                            testView.setText("" + priority);
//
//                        }
//
//
//
//                    });
//
//                    mBuilder.setView(mView);
//                    AlertDialog dialog = mBuilder.create();
//                    dialog.show();
//
//                }
//            }
//        });
//
//        Button createTask = (Button) findViewById(R.id.createTask);
//        createTask.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tasksArray.add(subtitleList);
//            }
//        });
//
    }
}
