
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

public class Create_Activity extends AppCompatActivity implements View.OnClickListener {
    String message = " ";
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_);

         edittext = findViewById(R.id.editTextTodo);
        Button buttonSave = findViewById(R.id.btnSave);
        buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String message = null;
        message = edittext.getText().toString();
        Intent intent = new Intent(Create_Activity.this, MainActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);

    }
}