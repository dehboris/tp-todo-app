package bj.esgis.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        EditText NomDeTache = findViewById(R.id.nom);
        EditText Tache = findViewById(R.id.tache);
    }
    public void onClick(View v) {

    }
}
