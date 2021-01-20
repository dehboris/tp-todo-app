package bj.Landry.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {

    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText editzone = findViewById(R.id.editTextTodo);
        message = editzone.getText().toString();

        TextView nom =findViewById(R.id.nomdetache) ;

        Button boutonsave = findViewById(R.id.btnSave);
        boutonsave.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

    }
}