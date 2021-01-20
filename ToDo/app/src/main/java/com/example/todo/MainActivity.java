package com.example.todo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> dataList = new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        TextView textView = (TextView) findViewById(R.id.textview_first);
        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {

            textView.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }

       dataList.add("manger");
        dataList.add("coder");
        dataList.add("langage");
        dataList.add("atelier");
        listView = findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                dataList);
        listView.setAdapter(arrayAdapter);
        /*listView.setOnClickListener(new AdapterView.OnItemClickListener() {

            /*@Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Object clickItem=adapterView.getAdapter().getItem(i);
                Toast.makeText{
                    MainActivity.this;*

            }
        }
        }
        );*/





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent openCreateActivity = new Intent(MainActivity.this, Create_Activity.class);
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
    public void onClick(View v) {

    }

    public void ChangeActivity(View view) {
        //EditText = findViewById(R.id.editTextTodo);
        String message = null;
        //message = EditText.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);

        //Intent intent = getIntent();
        /*if (intent != null) {
            // Le code pour récupérer les extras ira ici

            String str = "";
            if (intent.hasExtra("edittext")) { // vérifie qu'une valeur est associée à la clé “edittext”
                str = intent.getStringExtra("edittext"); // on récupère la valeur associée à la clé

            }


        }*/
        if (intent != null) {
            if (intent.hasExtra("message")) {
                message=intent.getStringExtra("message");
            }
        }
    }
}

