package com.example.markd.popularmovies;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
    public static void setUsername(GoogleSignInAccount google) {
        Log.d(TAG, "setUsername: Intiated");

        {
            DocumentReference ref=FirebaseFirestore.getInstance().document("users/"+google.getEmail());
            Map<String,String> dataToSave=new HashMap<String, String>();

            dataToSave.put("username",google.getDisplayName());
            dataToSave.put("profile_image",google.getPhotoUrl().toString());


            ref.set(dataToSave).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Log.d("USERCLASS","it was saved");
                }
            });








            username=google.getDisplayName();

        }


    }

    public User() {
        username=null;
    }

    public static String username;

    public static String getUsername(String email) {

        if(username==null) {
            DocumentReference ref = FirebaseFirestore.getInstance().document("users/" + email);
            username = null;

            ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Log.d(TAG, "onSuccess: ");
                    if (documentSnapshot.exists()) {

                        username = (String) documentSnapshot.get("username");

                    } else {
                        username = null;
                    }


                }
            });
        }
        else
        {
            return username;
        }
        Log.d(TAG, "getUsername: "+username);
        return username;
    }


    public static void logOut( )
    {
        username=null;
    }
    public static void getUsername(final TextView view)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()==null||auth.getCurrentUser().getEmail()==null) {
            return;
        }

        view.setText("");
        if(auth.getCurrentUser()==null)
        {
            view.setText("No user logged in");
        }
        if(username!=null)
        {
            view.setText(username);
        }
         DocumentReference ref = FirebaseFirestore.getInstance().document("users/" + auth.getCurrentUser().getEmail());
            username = null;

            ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Log.d(TAG, "onSuccess: ");
                    if (documentSnapshot.exists()) {

                        username = (String) documentSnapshot.get("username");


                    } else {
                        username = null;
                    }
                    view.setText(username);


                }
            });
    }

    public static void setProfileImage(final ImageView view)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        DocumentReference ref = FirebaseFirestore.getInstance().document("users/" + auth.getCurrentUser().getEmail());
        username = null;

        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            String image=null;
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d(TAG, "onSuccess: ");
                if (documentSnapshot.exists()) {

                    Log.d(TAG, "onSuccess: Image being created");
                     image= (String) documentSnapshot.get("profile_image");

                    Log.d(TAG, "onSuccess: with image "+image);
                    Picasso.get().load(image).into(view);




                }

            }


        });

    }





}
