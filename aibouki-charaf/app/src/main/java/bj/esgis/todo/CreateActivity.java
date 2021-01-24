package bj.esgis.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText modif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        modif = (EditText) findViewById(R.id.editTextTodo);

        Button btn = findViewById(R.id.btnSave);
        btn.setOnClickListener((View.OnClickListener) this);

    }



    @Override
    public void onClick (View view) {
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