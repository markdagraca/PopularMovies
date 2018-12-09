package com.example.markd.popularmovies;

import android.app.MediaRouteActionProvider;
import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User {
    public static final String TAG="USER";
    public static void setUsername(String email,String username) {
        Log.d(TAG, "setUsername: Intiated");

        {
            DocumentReference ref=FirebaseFirestore.getInstance().document("users/"+email);
            Map<String,String> dataToSave=new HashMap<String, String>();

            dataToSave.put("username",username);

            ref.set(dataToSave).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Log.d("USERCLASS","it was saved");
                }
            });








            User.username = username;
            
        }

       
    }

    public User() {
        username=null;
    }

    public static String username;

    public static String getUsername(String email) {

        DocumentReference ref=FirebaseFirestore.getInstance().document("users/"+email);
        username=null;
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    username=(String)documentSnapshot.get("username");
                }
                else
                {
                    username=null;
                }
            }
        });
        Log.d(TAG, "getUsername: "+username);
        return username;
    }
    public static void logOut( )
    {
        username=null;
    }


}
