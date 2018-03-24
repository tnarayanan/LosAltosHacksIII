package com.example.lah3.losaltoshacks3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class WeekViewTest extends AppCompatActivity {

    FloatingActionButton fab_add, fab_task, fab_event;
    Animation fab_open, fab_close, rotate_clockwise, rotate_counterclockwise;
    boolean isOpen = false;
    TextView taskName;
    TextView eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view_test);

        fab_add = (FloatingActionButton) findViewById(R.id.fabAdd);
        fab_task = (FloatingActionButton) findViewById(R.id.fabTask);
        fab_event = (FloatingActionButton) findViewById(R.id.fabEvent);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        rotate_counterclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        taskName = (TextView) findViewById(R.id.taskTextView);
        eventName = (TextView) findViewById(R.id.eventTextView);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen){
                    fab_event.startAnimation(fab_close);
                    eventName.startAnimation(fab_close);
                    fab_task.startAnimation(fab_close);
                    taskName.startAnimation(fab_close);
                    fab_add.startAnimation(rotate_counterclockwise);
                    fab_event.setClickable(false);
                    fab_task.setClickable(false);
                    isOpen = false;

                }else{
                    fab_event.startAnimation(fab_open);
                    eventName.startAnimation(fab_open);
                    fab_task.startAnimation(fab_open);
                    taskName.startAnimation(fab_open);
                    fab_add.startAnimation(rotate_clockwise);
                    fab_event.setClickable(true);
                    fab_event.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(WeekViewTest.this, CreateEvent.class);
                            startActivity(i);
                        }
                    });
                    fab_task.setClickable(true);
                    fab_task.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(WeekViewTest.this, CreateTask.class);
                            startActivity(i);
                        }
                    });
                    isOpen = true;

                }
            }
        });






    }
}
