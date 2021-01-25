package com.example.agendaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    EditText modif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         modif = (EditText) findViewById(R.id.TextTodo);

        Button btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(this);

    }



            @Override
            public void onClick(View v) {
                //lister.setAdapter(itemsAdapter);
               // items.add(message);
                String message = modif.getText().toString();
               if(message.isEmpty()){
                   Context context = getApplicationContext();
                   CharSequence text ="veuillez entrer un message";
                   int durer = Toast.LENGTH_LONG;
                   Toast toast =Toast.makeText(context,text,durer);
                   toast.show();
               }
               else{
                   Intent intentionResultat =new Intent();
                   intentionResultat.putExtra("tache",message);
                   setResult(Activity.RESULT_OK,intentionResultat);
                   finish();
               }
            }


}
