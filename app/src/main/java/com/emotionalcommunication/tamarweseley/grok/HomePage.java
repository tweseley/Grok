package com.emotionalcommunication.tamarweseley.grok;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import static com.emotionalcommunication.tamarweseley.grok.R.*;


public class HomePage extends ActionBarActivity {

    MyUserDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);
        dbHandler = new MyUserDBHandler(this,null,null,1);

        Button myButton = (Button)findViewById(id.button);
        Button signUpButton = (Button)findViewById(id.signUpButton);
        final EditText username = (EditText)findViewById(id.username);
        final EditText password = (EditText)findViewById(id.password);

        myButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String Username = username.getText().toString();
                        String userPassword = password.getText().toString();
                        if (!Username.isEmpty()&&!userPassword.isEmpty()&&dbHandler.usernameInDatabase(Username)&&dbHandler.isCorrectPassword(Username, userPassword)){
                            setContentView(layout.activity_inbox);
                            Intent homeIntent = new Intent(HomePage.this, Inbox.class);
                            homeIntent.putExtra("Username", Username);
                            startActivity(homeIntent);
                        }
                    }
                }
        );

        signUpButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        setContentView(layout.activity_sign_up_here);
                        startActivity(new Intent(HomePage.this, SignUpHere.class));
                    }
                }
        );

        myButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        String Username = username.getText().toString();
                        String userPassword = password.getText().toString();
                        if (!Username.isEmpty()&&!userPassword.isEmpty()&&dbHandler.usernameInDatabase(Username)&&dbHandler.isCorrectPassword(Username, userPassword)){
                            setContentView(layout.activity_inbox);
                            Intent homeIntent = new Intent(HomePage.this, Inbox.class);
                            homeIntent.putExtra("Username", Username);
                            startActivity(homeIntent);
                        }
                        return true;
                    }
                }
        );


    }



    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


}
