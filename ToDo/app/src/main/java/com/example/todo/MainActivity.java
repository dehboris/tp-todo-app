package com.example.todo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Task> mTasks;
    private Button fab;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("ToDo list");
        prefs = getPreferences(MODE_PRIVATE);
        createExampleList();
        if (getArrayList("TASK") != null)
            mTasks=getArrayList("TASK");


        buildRecyclerView();

        fab = (Button) findViewById(R.id.fab);
        Recuperer();
        saveArrayList(mTasks, "TASK");

//        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openActivity = new Intent(view.getContext() , CreateActivity.class);
                view.getContext().startActivity(openActivity);
            }
        });
    }

    public void saveArrayList(ArrayList<Task> list, String key){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        prefs.edit().putString(key,json).apply();
    }

    public ArrayList<Task> getArrayList(String key){
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Task>>() {}.getType();
        return gson.fromJson(json, type);
    }


    public void Recuperer()
    {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("nom")){ // vérifie qu'une valeur est associée à la clé “edittext”
                String no = intent.getStringExtra("nom"); // on récupère la valeur associée à la clé
                mTasks.add(new Task(no));
                mAdapter.notifyItemInserted(mTasks.size());
            }
        }

    }

    public void createExampleList()
    {
        mTasks= new ArrayList<>();
        mTasks.add(new Task("Aller faire les courses"));
        mTasks.add(new Task("Dormir à 14h"));
    }

    public void buildRecyclerView()
    {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TaskAdapter(mTasks);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onMenuItemSelected(id, item);

        //return super.onOptionsItemSelected(item);
    }