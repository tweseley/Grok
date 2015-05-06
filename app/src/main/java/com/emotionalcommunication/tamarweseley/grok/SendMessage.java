package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class SendMessage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Button sendButton2 = (Button)findViewById(R.id.sendButton2);
        Button lookUpButton2 = (Button)findViewById(R.id.lookUpButton2);
        Button logoutButton2 = (Button)findViewById(R.id.logoutButton2);
        final EditText recipient = (EditText)findViewById(R.id.recipient);

        //drop-down menu - import options from strings_emotions.xml resource file
        final Spinner emotionspinner = (Spinner)findViewById(R.id.emotionspinner);

        ArrayAdapter<CharSequence> emotionadapter = ArrayAdapter.createFromResource(this,
                R.array.emotions_array, android.R.layout.simple_spinner_item);
        emotionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emotionspinner.setAdapter(emotionadapter);

        sendButton2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String userRecipient = recipient.getText().toString();
                        String userEmotion = emotionspinner.getSelectedItem().toString();

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

