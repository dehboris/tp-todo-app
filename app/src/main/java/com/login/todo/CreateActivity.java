package com.login.todo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {
    Context context;
    db dbto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        context = this;
        dbto =  new db(context);
        Log.d("count_c","onCreate:" +dbto.getTaskCount());

        EditText message = findViewById(R.id.edTodo);



        Button boutonSave = findViewById(R.id.btSave);
        boutonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Message = message.getText().toString();
                if(TextUtils.isEmpty(Message)){
                    task taskv = new task(Message);
                    dbto.addTask(taskv);
                    startActivity(new Intent(context,MainActivity.class));
                }



            }
        });
    }

}