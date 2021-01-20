package com.login.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    private  ListView lvs;
    private List<task> task;
    private db dbto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        dbto = new db(context);
        Log.d("count_c","onCreate" +dbto.getTaskCount());

        lvs = findViewById(R.id.list_todo);
        task = new ArrayList<>();
        task = dbto.getAllTask();

        String[] tas = new String[task.size()];

        for (int i=0; i<task.size(); i++ ){
            String y = task.get(i).getTitle();
            tas[i] = y;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,tas);
        lvs.setAdapter(adapter);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCreateActivity = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(openCreateActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}