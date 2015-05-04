package com.emotionalcommunication.tamarweseley.grok;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyMessageDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "messages.db";
    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMOTION = "messageEmotion";
    public static final String COLUMN_SENDER = "sendingUser";
    public static final String COLUMN_RECEIVER = "receivingUser";
    public static final String COLUMN_DATETIME = "dateTime";

    public MyMessageDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_MESSAGES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMOTION + " TEXT, " +
                COLUMN_SENDER + " TEXT, " +
                COLUMN_RECEIVER + " TEXT, " +
                COLUMN_DATETIME + System.currentTimeMillis() +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        onCreate(db);
    }

    //Add a new row to the database
    public void addUser(Messages message){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMOTION, message.get_messageEmotion());
        values.put(COLUMN_SENDER, String.valueOf(message.get_sendingUser()));
        values.put(COLUMN_RECEIVER, String.valueOf(message.get_receivingUser()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MESSAGES, null, values);
        db.close();
    }

    //Delete a user from the database
    public void deleteUser(String message){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MESSAGES + " WHERE " + COLUMN_EMOTION + "=\"" + message + "\"");
    }

    //Prints out the database as a string
    public String messagesToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MESSAGES + " WHERE 1";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("messageEmotion"))!=null){
                dbString += c.getString(c.getColumnIndex("messageEmotion"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}
