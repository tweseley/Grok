package com.emotionalcommunication.tamarweseley.grok;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import static com.emotionalcommunication.tamarweseley.grok.R.*;


public class HomePage extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);


        Button myButton = (Button)findViewById(id.button);
        Button signUpButton = (Button)findViewById(id.signUpButton);
        final EditText email = (EditText)findViewById(id.email);
        final EditText password = (EditText)findViewById(id.password);

        myButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String userEmail = email.getText().toString();
                        String userPassword = password.getText().toString();
                        if (!userEmail.isEmpty()&&!userPassword.isEmpty()){
                            setContentView(layout.activity_inbox);
                            startActivity(new Intent(HomePage.this, Inbox.class));
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
                        String userEmail = email.getText().toString();
                        String userPassword = password.getText().toString();
                        if (!userEmail.isEmpty()&&!userPassword.isEmpty()){
                            setContentView(layout.activity_inbox);
                            startActivity(new Intent(HomePage.this, Inbox.class));
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
