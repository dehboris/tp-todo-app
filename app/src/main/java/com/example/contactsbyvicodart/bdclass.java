package com.example.contactsbyvicodart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class bdclass extends SQLiteOpenHelper {

    private  static final int VERSION=2;

    private  static final String DB_NAME= "amica";

    private  static final String CONTACT_TABLE= "conpl";
    private  static final String ID= "id";
    private  static final String NUM= "num";


    public bdclass( Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           String CREATE_CONTACT_TABLE= "CREATE TABLE  " + CONTACT_TABLE+ " ( "+ ID +  " integer PRIMARY KEY autoincrement,"  +NUM+  " TEXT)";
           sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            String sql = "DROP TABLE " + CONTACT_TABLE;
        sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
    }



    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();


        values.put(NUM,contact.getNum());


        db.insert(CONTACT_TABLE,null,values);
        db.close();
    }

    public Contact getContact(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                CONTACT_TABLE,
                new String[]{ID, NUM},
                ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null
        );
        Contact contact;

        if(cursor != null){
            cursor.moveToFirst();
            contact = new Contact(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1)

            );
            return  contact;
        }else{
                return null;
        }
    }

    public List<Contact> getAllContacts(){
        SQLiteDatabase db = getReadableDatabase();
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM "  +CONTACT_TABLE;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                Contact contact = new Contact();

                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNum(cursor.getString(1));

                contacts.add(contact);
            }while(cursor.moveToNext());
        }
         return contacts;
    }

    public  int getContactCount(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " +CONTACT_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }


}
