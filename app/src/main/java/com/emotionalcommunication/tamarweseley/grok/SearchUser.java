package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static com.emotionalcommunication.tamarweseley.grok.R.*;

public class SearchUser extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        Button sendButton = (Button)findViewById(R.id.sendButton);
        Button logoutButton = (Button)findViewById(R.id.logoutButton);
        Button searchButton = (Button)findViewById(R.id.searchButton);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText emailAddress = (EditText)findViewById(id.email);
        searchButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String username = name.getText().toString();
                        String email = emailAddress.getText().toString();
                        if (!email.isEmpty()||!username.isEmpty()){
                            setContentView(R.layout.activity_inbox);
                            startActivity(new Intent(SearchUser.this, Inbox.class));
                        }
                    }
                }
        );

        sendButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_send_message);
                        startActivity(new Intent(SearchUser.this, SendMessage.class));
                    }
                }
        );

        logoutButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_home_page);
                        startActivity(new Intent(SearchUser.this, HomePage.class));
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


