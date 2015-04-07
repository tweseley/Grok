package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SendMessage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Button sendButton2 = (Button)findViewById(R.id.sendButton2);
        Button lookUpButton2 = (Button)findViewById(R.id.lookUpButton2);
        Button logoutButton2 = (Button)findViewById(R.id.logoutButton2);
        final EditText recipient = (EditText)findViewById(R.id.recipient);
        final EditText emotion = (EditText)findViewById(R.id.emotion);
        sendButton2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String userRecipient = recipient.getText().toString();
                        String userEmotion = emotion.getText().toString();
                        if (!userRecipient.isEmpty()&&!userEmotion.isEmpty()){
                            setContentView(R.layout.activity_inbox);
                            startActivity(new Intent(SendMessage.this, Inbox.class));
                        }
                    }
                }
        );

        lookUpButton2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_search_user);
                        startActivity(new Intent(SendMessage.this, SearchUser.class));
                    }
                }
        );

        logoutButton2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_home_page);
                        startActivity(new Intent(SendMessage.this, HomePage.class));
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

