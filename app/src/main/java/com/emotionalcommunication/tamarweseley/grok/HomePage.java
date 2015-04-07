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

    private static final String TAG = "tamarMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);
        Log.i(TAG, "onCreate");


        Button myButton = (Button)findViewById(id.button);
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
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
