package bj.Landry.todo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;



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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// le R. permet de se positionner dans la structure ou l'interface ressources

      //  Toolbar toolbar = findViewById(R.id.toolbar); // findviewbyid recherche une vue en fonction de son id.on a creer une variable de la  classe toolbar
       // setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);// floatingAction button (un bouton flotant)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             // implementer une nouvelle interface sur lequel se pointera apres le click sur le bouton + de notre app

                Intent showCreateActivity = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(showCreateActivity);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("ToDo list");
        prefs = getPreferences(MODE_PRIVATE);
        createExampleList();
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
            if (intent.hasExtra("nomdetache")){ // vérifie qu'une valeur est associée à la clé “edittext”
                String no = intent.getStringExtra("nomdetache"); // on récupère la valeur associée à la clé
                mTasks.add(new Task(no));
                mAdapter.notifyItemInserted(mTasks.size());
            }
        }

    }



}