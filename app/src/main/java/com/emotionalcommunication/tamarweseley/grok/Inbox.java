package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.emotionalcommunication.tamarweseley.grok.R.*;
import static com.emotionalcommunication.tamarweseley.grok.R.layout.*;


public class Inbox extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_inbox);

        Button sendButton1 = (Button)findViewById(id.sendButton1);
        Button lookUpButton1 = (Button)findViewById(id.lookUpButton1);
        Button logoutButton1 = (Button)findViewById(id.logoutButton1);
        sendButton1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        setContentView(layout.activity_send_message);
                        startActivity(new Intent(Inbox.this, SendMessage.class));
                    }
                }
        );

        lookUpButton1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(layout.activity_search_user);
                        startActivity(new Intent(Inbox.this, SearchUser.class));
                    }
                }

        );

        logoutButton1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(layout.activity_home_page);
                        startActivity(new Intent(Inbox.this, HomePage.class));
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

