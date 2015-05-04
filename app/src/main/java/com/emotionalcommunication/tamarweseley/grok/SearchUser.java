package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import static com.emotionalcommunication.tamarweseley.grok.R.*;
import android.util.Log;

public class SearchUser extends ActionBarActivity {

    EditText name;
    EditText emailAddress;
    TextView userTextView;
    MyUserDBHandler dbHandler;
    private static final String TAG = "DB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        final Button sendButton = (Button)findViewById(R.id.sendButton);
        final Button logoutButton = (Button)findViewById(R.id.logoutButton);
        final Button searchButton = (Button)findViewById(R.id.searchButton);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText emailAddress = (EditText)findViewById(id.email);
        final EditText username = (EditText)findViewById(id.username);
        final ListView listOfUsers = (ListView)findViewById(id.listOfUsers);
        dbHandler = new MyUserDBHandler(this,null,null,1);
        //Log.v(TAG,dbHandler.usernamesToString());
        searchButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v){
                        String username = name.getText().toString();
                        String email = emailAddress.getText().toString();
                        if (!email.isEmpty()||!username.isEmpty()){
                            setContentView(layout.activity_search_user);
                            startActivity(new Intent(SearchUser.this, SearchUser.class));
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

    public void printDatabase(){
        String dbString = dbHandler.usernamesToString();
        userTextView.setText(dbString);
        name.setText("");
        emailAddress.setText("");
    }

//    public void searchButtonClicked(){
//        if (emailAddress.getText().length()!=0){
//            //Users user = new Users(0,name.getText().toString(), emailAddress.getText().toString());
//        }
//        printDatabase();
//    }


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


