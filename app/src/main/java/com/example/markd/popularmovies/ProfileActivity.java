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
            User.setProfileImage((ImageView) findViewById(R.id.profile_image));
            User.getUsername((TextView) findViewById(R.id.profile_username));
            TextView email=(TextView)findViewById(R.id.profile_email);
            email.setText(auth.getCurrentUser().getEmail().toString());
        }







    }
    public void logout(android.view.View view)
    {
        FirebaseAuth.getInstance().signOut();
        User.logOut();

        Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
