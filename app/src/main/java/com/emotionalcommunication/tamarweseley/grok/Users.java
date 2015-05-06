package com.emotionalcommunication.tamarweseley.grok;


import android.provider.ContactsContract;

public class Users {

    private int _id;
    private String _username;
    private String _email;
    private String _name;
    private String _password;

    public Users(){

    }
    public Users(String username, String email, String name, String password){
        this._username = username;
        this._email = email;
        this._password = password;
        this._name = name;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public void set_name(String _name) {this._name = _name;}

    public void set_username(String _username){
        this._username = _username;
    }

    public void set_email(String _email){
        this._email = _email;
    }

    public void set_password(String _password){
        this._password = _password;
    }

    public int get_id(){
        return _id;
    }

    public String get_name(){
        return _name;
    }

    public String get_username(){
        return _username;
    }

    public String get_email() {
        return _email;
    }

    public String get_password(){
        return _password;
    }
}
