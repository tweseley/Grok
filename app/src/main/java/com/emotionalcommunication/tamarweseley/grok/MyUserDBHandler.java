package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;

public class MyUserDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "users.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";

    public MyUserDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT" +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //Add a new row to the database
    public boolean addUser(Users user){
        boolean added = false;
        if (!usernameInDatabase(String.valueOf(user.get_username()))){
            ContentValues values = new ContentValues();
            values.put(COLUMN_USERNAME, String.valueOf(user.get_username()));
            values.put(COLUMN_EMAIL, String.valueOf(user.get_email()));
            values.put(COLUMN_NAME, String.valueOf(user.get_name()));
            values.put(COLUMN_PASSWORD, String.valueOf(user.get_password()));
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_USERS, null, values);
            db.close();
            added = true;
        }
        return added;
    }

    //Delete a user from the database
    public void deleteUser(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\"");
    }

    public String getNameFromUsername(String username){
        String name = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results


        if (c.moveToFirst()){
            name += c.getString(c.getColumnIndex("name"));
        }else{
            name+="didn't find anything";
        }
        db.close();
        return name;
    }

    public List<Users> searchByName(String name){
        List<Users> users = new ArrayList<Users>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_NAME + " =  \"" + name + "\"";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results

        Users user = new Users();

        if (c.moveToFirst()) {
            c.moveToFirst();
            user.set_id(Integer.parseInt(c.getString(0)));
            user.set_username(c.getString(1));
            user.set_email(c.getString(2));
            user.set_name(c.getString(3));
            user.set_password(c.getString(4));
            users.add(user);
        }
        db.close();
        return users;
    }

    public boolean usernameInDatabase(String username){
        boolean inDb = false;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first row in your results

        if (c.moveToFirst()) {

                inDb = true;

        }
        db.close();
        return inDb;
    }

    public boolean isCorrectPassword(String username, String password){
        boolean correctPassword = false;
        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " =  \"" + username + "\"";
//
//        //cursor points to a location in your results
//        Cursor c = db.rawQuery(query,null);
//        //move to the first row in your results
//
//        if (c.moveToFirst() && c.getString(4).equals(password)) {
//            correctUsername = true;
//        }
//        db.close();
//        return correctUsername;

        String query = "SELECT * FROM " + TABLE_USERS;
        Cursor c = db.rawQuery(query,null);
        while (c.moveToNext()){
            if (c.getString(c.getColumnIndex("username")).equals(username) && c.getString(c.getColumnIndex("password")).equals(password)) {
                correctPassword = true;
            }
        }
        return correctPassword;
    }

    public List<String> getAllUsers(){
        List<String> users = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS;

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results

        Users user = new Users();

        while (c.moveToNext()){
            //c.moveToNext();
            if (!c.getString(c.getColumnIndex("name")).isEmpty()) {

                //            user.set_id(Integer.parseInt(c.getString(c.getColumnIndex("_id"))));
                //            user.set_username(c.getString(c.getColumnIndex("username")));
                //            user.set_email(c.getString(c.getColumnIndex("email")));
                //            user.set_name(c.getString(c.getColumnIndex("name")));
                //            users.add(user.get_username().toString());
                Log.v("TAG", c.getString(3));
                users.add(c.getString(3) + ": " + c.getString(1) + ", " + c.getString(2));
            }else{
                users.add("nothing");
            }
        }
        db.close();
        return users;
    }


    //Prints out the database as a string
    public String usernamesToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("username"))!=null){
                dbString += c.getString(c.getColumnIndex("username"));
                dbString += ", ";
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}
