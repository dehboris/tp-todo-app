package dalmeida.ariane.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editZone;
    Todo todo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        editZone=(EditText)findViewById(R.id.editTextTodo);
        Button btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        todo=new Todo(editZone.getText().toString());
        Intent changeActivity=new Intent(CreateActivity.this,MainActivity.class);
        changeActivity.putExtra("donnee",todo);
        startActivity(changeActivity);
        finish();
    }

}