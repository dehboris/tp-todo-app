package com.example.contactsbyvicodart;

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
import android.widget.ListView;

public class AjouterContact extends AppCompatActivity {
    Context context ;
    bdclass mydb;

    EditText field;
    Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);
        context = this;
        mydb = new bdclass(context);


        field = (EditText)findViewById(R.id.num);


        ajouter = (Button)findViewById(R.id.ajout);



        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num = field.getText().toString();


                if(!TextUtils.isEmpty(num)){
                          Contact contact = new Contact(num);
                        mydb.addContact(contact);
                        startActivity(new Intent(context,MainActivity.class));
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Verifier le champs vous avez oubliez de le remplir")
                            .setNegativeButton("OK",null)
                            .show();
                }

            }
        });
    }
}