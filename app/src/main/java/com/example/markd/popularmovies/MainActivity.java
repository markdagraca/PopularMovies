package com.example.markd.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.URL;


public class MainActivity extends AppCompatActivity {
    public static final String TAG="Main";
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private Menu menu;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        Log.d("Main","On Create");

        final TextView tv = (TextView) findViewById(R.id.tv);
        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data;

                URL url;
                url = NetworkUtils.buildURL();
                String response;




                Log.d("getting JSON  ? : ","URL HERE , (need to turn into JSON  parsed)" + url);


                tv.setText(" need to chang this to parsedJSON/into recybler view " + url);


//                urlString = "http://api.openweathermap.org/data/2.5/weather?q=khulna,bd";
//                new ProcessJSON().execute(urlString);
            }
        });





    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
         currentUser = mAuth.getCurrentUser();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        this.menu=menu;
        if(mAuth.getCurrentUser()==null)
        {

            MenuItem login=menu.findItem(R.id.log_out);
            login.setVisible(false);
        }
        else
        {
            MenuItem login=menu.findItem(R.id.sign_in);
            login.setVisible(false);

        }


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d("Main Activty", (String) item.getTitle());
        if(item.getTitle().equals("Sign In"))
        {
            Log.d(TAG,"Activity switch to signin");
            Intent signin=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(signin);


        }
        else if(item.getTitle().equals("Log Out"))
        {

            FirebaseAuth.getInstance().signOut();
            Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);



        }



        return super.onOptionsItemSelected(item);
    }

}
