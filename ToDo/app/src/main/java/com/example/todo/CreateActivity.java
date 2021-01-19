package com.example.todo;

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

public class CreateActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mEntete;
    private EditText mNom;
    private Button mAnswerButton1;
    private Button mAnswerButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mEntete = (TextView) findViewById(R.id.texte);
        mNom = (EditText) findViewById(R.id.nom);
        mAnswerButton2 = (Button) findViewById(R.id.btnEnregistrer);
        mAnswerButton1 = (Button) findViewById(R.id.btnAnnuler);
        mAnswerButton2.setEnabled(false);

        mNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAnswerButton2.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();
        if (responseIndex==0)
            finish();
        else if (responseIndex==1)
        {
            String nom = mNom.getText().toString();

            if (nom.isEmpty())
            {
                Toast.makeText(this, "Veuillez remplir le chamo", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Enregistrement réussie", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(CreateActivity.this, MainActivity.class);
                intent1.putExtra("nom", nom);
                // démarrer une autre activité et recevoir un résultat
                //startActivityForResult(enregistrementIntent,ENREGISTREMENT_REQUEST_CODE);
                startActivity(intent1);
            }
        }

    }
}