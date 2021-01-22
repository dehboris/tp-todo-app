package com.example.listodo;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{
    String message;
    EditText editZone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        editZone = findViewById(R.id.editTextTodo);
        message = editZone.getText().toString();

        Button boutonSave = findViewById(R.id.btnSave);
        boutonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = editZone.getText().toString();
        if(message.isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Veuillez saisir une tâche!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            Intent intentionResultat = new Intent();
            intentionResultat.putExtra("tache",message);

            setResult(Activity.RESULT_OK,intentionResultat);
            finish();
        }

    }
}