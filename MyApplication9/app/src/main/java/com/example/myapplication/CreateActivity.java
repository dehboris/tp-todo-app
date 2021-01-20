package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity implements  View.OnClickListener {
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText editZone = findViewById(R.id.edTodo);
        message = editZone.getText().toString();

        Button boutonSave = findViewById(R.id.btSave);
        boutonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCreateActivity = new Intent(CreateActivity.this, MainActivity.class);
                startActivity(openCreateActivity);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}