package com.example.markd.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoviePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView title=findViewById(R.id.moviepage_title);
        TextView description=findViewById(R.id.moviepage_description);

        Intent previnent=getIntent();
        getIntent().getStringExtra("video");

        title.setText(previnent.getStringExtra("title"));
        description.setText(previnent.getStringExtra("description"));
    }
}
