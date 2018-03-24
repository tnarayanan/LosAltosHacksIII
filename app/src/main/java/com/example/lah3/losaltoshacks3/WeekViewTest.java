package com.example.lah3.losaltoshacks3;

import android.content.Intent;
import android.graphics.RectF;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeekViewTest extends AppCompatActivity {

    FloatingActionButton fab_add, fab_task, fab_event;
    Animation fab_open, fab_close, rotate_clockwise, rotate_counterclockwise;
    boolean isOpen = false;
    TextView taskName;
    TextView eventName;
    WeekView ashish;
    List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

    int times = 0;



    public static WeekViewEvent selectedEvent = new WeekViewEvent();

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

        Toast.makeText(this, "ashish rao", Toast.LENGTH_LONG).show();
        ashish = (WeekView)findViewById(R.id.ashish);

        MonthLoader.MonthChangeListener mMonthChangeListener = new MonthLoader.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                // Populate the week view with some events.



                if(times > 0) {
                    events.clear();
                }


                WeekViewEvent event = new WeekViewEvent(1, "Kill\nall\nthe\nmoon\nmen" + times, 2018, 3, 25, 0, 0, 2018, 3, 26, 14, 0);

                events.add(event);
                event.setColor(getResources().getColor(R.color.darkOrange));

                WeekViewEvent event2 = new WeekViewEvent(2, "Kill\n all\n the\n moon\n men\n again" + times, 2018, 3, 26, 15, 0, 2018, 3, 26, 20, 0);
                events.add(event2);
                events.add(event);




                times++;


                Log.e("times month change", Integer.toString(times));
                Log.e("Events Size", Integer.toString(events.size()));




                return events;
            }

        };

        ashish.setMonthChangeListener(mMonthChangeListener);




        ashish.setOnEventClickListener(new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                Toast.makeText(getApplicationContext(), event.getName(), Toast.LENGTH_LONG).show();
                selectedEvent = event;
            }
        });




    }


    /*

  \
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_week_view_test);





        ashish.setMonthChangeListener(mMonthChangeListener);




        ashish.setOnEventClickListener(new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                Toast.makeText(getApplicationContext(), event.getName(), Toast.LENGTH_LONG).show();
                selectedEvent = event;
            }
        });



    }


}

     */
}
