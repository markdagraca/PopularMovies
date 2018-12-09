package com.example.markd.popularmovies;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {
    public static void setUsername(String username) {

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("username");
        Log.d("USERCLASS",username+" added");

        myRef.setValue(username);

        User.username = username;
    }

    public User() {
        username="";
    }

    public static String username;

    public static String getUsername() {
        return username;
    }
}
