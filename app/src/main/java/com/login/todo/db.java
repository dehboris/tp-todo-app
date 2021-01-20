package com.login.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class db extends SQLiteOpenHelper {

    private  static final int VERSION=2;

    private  static final String DB_NAME= "taskdb";

    private  static final String TASK_TABLE= "taskv";
    private  static final String ID= "id";
    private  static final String TITLE= "title";


    public db( Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase dbtask) {
        String CREATE_CONTACT_TABLE= "CREATE TABLE  " + TASK_TABLE+ " ( "+ ID +  " integer PRIMARY KEY autoincrement,"  +TITLE+  " TEXT)";
        dbtask.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbtask, int i, int y) {
        String sql = "DROP TABLE " + TASK_TABLE;
        dbtask.execSQL(sql);
        onCreate(dbtask);
    }



    public void addTask(task tasktt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();


        values.put(TITLE,tasktt.getTitle());


        db.insert(TASK_TABLE,null,values);
        db.close();
    }

    public task getTask(int id) {
        SQLiteDatabase dbt = getReadableDatabase();

        Cursor cursor = dbt.query(
                TASK_TABLE,
                new String[]{ID, TITLE},
                ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null
        );
        task taskv;

        if(cursor != null){
            cursor.moveToFirst();
            taskv = new task(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1)

            );
            return  taskv;
        }else{
            return null;
        }
    }

    public List<task> getAllTask(){
        SQLiteDatabase db = getReadableDatabase();
        List<task> tasklists = new ArrayList<>();
        String query = "SELECT * FROM "  +TASK_TABLE;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                task ltask = new task();

                ltask.setId(Integer.parseInt(cursor.getString(0)));
                ltask.setTitle(cursor.getString(1));

                tasklists.add(ltask);
            }while(cursor.moveToNext());
        }
        return tasklists;
    }

    public  int getTaskCount(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " +TASK_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }


}

