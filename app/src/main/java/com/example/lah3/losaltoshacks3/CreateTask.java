package com.example.lah3.losaltoshacks3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CreateTask extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        listView = (ListView) findViewById(R.id.listView);

        String[] listViewItems = {"Task Name", "Time to complete", "Due Date", "Priority"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems);
        listView.setAdapter(adapter);


    }
}
