package com.example.contactsbyvicodart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      Context context;
      private  bdclass mydb;
      private ListView cl;
      private com.google.android.material.floatingactionbutton.FloatingActionButton ajouter;
      private List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        mydb= new bdclass(context);



        cl = findViewById(R.id.clv);
        ajouter = findViewById(R.id.ajoute);

        contacts = new ArrayList<>();
        contacts = mydb.getAllContacts();

        String[] tabarr = new String[contacts.size()];

        for(int x=0; x<contacts.size();x++){
            String a =  contacts.get(x).getNum() +"\n";
            tabarr[x] = a;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,tabarr);
        cl.setAdapter(adapter);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AjouterContact.class);
                startActivity(intent);
            }
        });

    }
}