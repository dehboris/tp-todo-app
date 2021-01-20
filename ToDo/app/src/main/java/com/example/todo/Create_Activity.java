
package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.*;

public class Create_Activity extends AppCompatActivity implements View.OnClickListener{
    String message=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_);

        EditText edittext = findViewById(R.id.editTextTodo);
        Button buttonSave = findViewById(R.id.btnSave);
        buttonSave.setOnClickListener(this);

    buttonSave.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Create_Activity.this, MainActivity.class);
            startActivity(intent);
        }
    });

    }



    @Override
    public void onClick(View v) {

           /* Intent closeCreateActivity = new Intent(Create_Activity.this, MainActivity.class);
            startActivity(closeCreateActivity);*/
        String message = null;
        message = message.toString();
        Intent intent = new Intent(Create_Activity.this, MainActivity.class);
        intent.putExtra("message",message);
        //startActivity(intent);


    }

   /* public void ChangeActivity(View view){
        //EditText = findViewById(R.id.editTextTodo);

        //message = EditText.getText().toString();

        //Intent intent = getIntent();

            // Le code pour récupérer les extras ira ici

           /* String mes = "";
            if (intent.hasExtra("edittext")){ // vérifie qu'une valeur est associée à la clé “edittext”
                message = intent.getStringExtra("edittext"); // on récupère la valeur associée à la clé

            }

        }









    }*/

    /*public void onClickSwitchActivity(){
        EditText editText = (EditText) findViewById(R.id.editTextTodo);
        String message = editText.getText().toString();
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }*/


}