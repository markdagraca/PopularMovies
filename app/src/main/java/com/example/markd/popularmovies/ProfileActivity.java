package com.example.markd.popularmovies;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            TextView username=(TextView) findViewById(R.id.profile_username);
            User.setProfileImage((ImageView) findViewById(R.id.profile_image));
            User.getUsername(username);
            TextView email=(TextView)findViewById(R.id.profile_email);
            email.setText("Email: "+auth.getCurrentUser().getEmail().toString());
            if(username.getText().length()>0)
            username.setText("Username: "+username.getText());
        }







    }
    public void logout(android.view.View view)
    {
        FirebaseAuth.getInstance().signOut();
        User.logOut();
        finish();
    }
}
