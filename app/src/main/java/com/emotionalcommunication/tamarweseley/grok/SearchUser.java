package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static com.emotionalcommunication.tamarweseley.grok.R.*;

public class SearchUser extends ActionBarActivity {

    EditText name;
    EditText emailAddress;
    TextView userTextView;
    MyUserDBHandler dbHandler;
    ListView listView;
    private static final String TAG = "DB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        dbHandler = new MyUserDBHandler(this,null,null,1);
        listView = (ListView) findViewById(R.id.listOfUsers);
        List<String> users = new ArrayList<String>(dbHandler.getAllUsers());
//
//        //List<String> users = new ArrayList<String>();
//        users.add("Tamar");
//        users.add("Liz");
//        users.add("Tamar");
//        users.add("Liz");
//        users.add("Tamar");
//        users.add("Liz");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, users);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item value
                String  user    = String.valueOf(parent.getItemAtPosition(position));

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + position + "  User : " + user, Toast.LENGTH_LONG)
                        .show();

            }

        });

        final Button sendButton = (Button)findViewById(R.id.sendButton);
        final Button logoutButton = (Button)findViewById(R.id.logoutButton);
        final Button searchButton = (Button)findViewById(R.id.searchButton);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText emailAddress = (EditText)findViewById(id.username);

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


