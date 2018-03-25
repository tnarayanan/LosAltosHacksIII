package com.example.lah3.losaltoshacks3;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 1){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 2){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }else if(i == 3){
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(CreateTask.this);
                    View mView = getLayoutInflater().inflate(R.layout.item_name, null);

                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();

                }
            }
        });


    }
}
