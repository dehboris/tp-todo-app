package com.example.agendaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText modif = (EditText) findViewById(R.id.TextTodo);
        String message = modif.getText().toString();
        Button btn = findViewById(R.id.btnSend);
        lister = (ListView) findViewById(R.id.List);
        items = new ArrayList<String>();
        itemsAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //lister.setAdapter(itemsAdapter);
               // items.add(message);
                Intent intente = new Intent(MainActivity2.this, MainActivity.class);
                intente.putExtra(String.valueOf(lister),message);
                startActivity(intente);
            }
        });

    }
}