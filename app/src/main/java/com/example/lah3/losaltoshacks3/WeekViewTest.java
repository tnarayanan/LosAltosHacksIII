package com.example.lah3.losaltoshacks3;

import android.content.Intent;
import android.graphics.RectF;
import android.media.MediaDrm;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.alamkanak.weekview.WeekViewLoader;
import com.example.lah3.losaltoshacks3.Backend.UserSchedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeekViewTest extends AppCompatActivity {

    public static UserSchedule userSchedule = new UserSchedule();

    FloatingActionButton fab_add, fab_task, fab_event;
    Animation fab_open, fab_close, rotate_clockwise, rotate_counterclockwise;
    boolean isOpen = false;
    TextView taskName;
    TextView eventName;
    WeekView eventList;
    List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

    final String TAG = "";


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


        MonthLoader.MonthChangeListener monthChangeListener = new MonthLoader.MonthChangeListener() {

            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                if(newMonth == 4){
                    WeekViewEvent event = new WeekViewEvent(1, "event1", 2018, 3, 25, 0, 0, 2018, 3, 26, 0, 0);
                    WeekViewEvent event2 = new WeekViewEvent(1, "event2", 2018, 3, 26, 0, 0, 2018, 3, 27, 0, 0);

                    event.setColor(getResources().getColor(R.color.darkOrange));

                    events.add(event);
                    events.add(event2);
                } else {
                    events.clear();
                }

                if(newMonth != 4) {
                    List<WeekViewEvent> blank = new ArrayList<WeekViewEvent>();
                    return blank;
                }
                return events;


            }

        };



        WeekView.EventClickListener eventClickListener = new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                selectedEvent = event;
                Intent intent = new Intent(getApplicationContext(), EventDetails.class);
                startActivity(intent);
            }
        };

        eventList = (WeekView)findViewById(R.id.eventList);
        eventList.setMonthChangeListener(monthChangeListener);





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
