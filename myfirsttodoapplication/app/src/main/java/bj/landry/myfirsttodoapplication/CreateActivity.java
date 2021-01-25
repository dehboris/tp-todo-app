package bj.landry.myfirsttodoapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {

    String message;
    EditText editzone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createlayout);

        EditText editzone = findViewById(R.id.ediTache);
        Button button = findViewById(R.id.btnCreate);
        button.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

    message =  editzone.getText().toString();

        Log.i("Create Activity", message);

        if(message.isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Veuillez saisir une tâche!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }
        else{
            Intent intentionResultat = new Intent();
            intentionResultat.putExtra("tache", message);

            setResult(Activity.RESULT_OK,intentionResultat);
            finish();
        }
    }

}
