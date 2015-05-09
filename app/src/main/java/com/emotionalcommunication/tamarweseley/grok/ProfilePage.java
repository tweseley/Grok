package com.emotionalcommunication.tamarweseley.grok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.emotionalcommunication.tamarweseley.grok.R.*;

/**
 * Created by allan on 4/30/15.
 */
public class ProfilePage extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Button profiledoneButton = (Button) findViewById(id.profiledoneButton);
        final EditText profileName = (EditText) findViewById(id.profileName);
        final EditText profileBirth = (EditText) findViewById(id.profileBirth);
        final EditText profileZIP = (EditText) findViewById(id.profileZIP);
        final EditText profileGender = (EditText) findViewById(id.profileGender);
        final EditText profileRace = (EditText) findViewById(id.profileRace);
        final EditText profileOrientation = (EditText) findViewById(id.profileOrientation);

        profiledoneButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String newName = profileName.getText().toString();
                        String newBirth = profileBirth.getText().toString();
                        String newZIP = profileZIP.getText().toString();
                        String newGender = profileGender.getText().toString();
                        String newRace = profileRace.getText().toString();
                        String newOrientation = profileOrientation.getText().toString();

                        setContentView(R.layout.activity_inbox);
                        startActivity(new Intent(ProfilePage.this, Inbox.class));
                    }
                }
        );
    }
}
