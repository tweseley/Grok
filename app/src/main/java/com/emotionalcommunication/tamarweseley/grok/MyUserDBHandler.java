package com.emotionalcommunication.tamarweseley.grok;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;

public class MyUserDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";

    public MyUserDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_NAME + " TEXT" +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addUser(Users user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.get_username());
        values.put(COLUMN_EMAIL, String.valueOf(user.get_email()));
        values.put(COLUMN_NAME, String.valueOf(user.get_name()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    //Delete a user from the database
    public void deleteUser(String username){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\"");
    }

//    public String getUsernameFromName(String name){
//
//    }
//
    public String getNameFromUsername(String username){
        String name = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

        //cursor points to a location in your results
        Cursor c = db.rawQuery(query,null);
        //move to the first fow in your results
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("username"))!=null && c.getString(c.getColumnIndex("username")).equals(username)){
                name += c.getString(c.getColumnIndex("name"));
                name += "\n";
            }
        }
        db.close();
        return name;
    }
//
//    public String getNameFromEmail(String email){
//        return
//    }
//
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
            users.add(user);
        }
        db.close();
        return users;
    }

    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<Users>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_NAME + "\"";

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
            users.add(user);
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
