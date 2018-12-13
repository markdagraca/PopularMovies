package com.example.markd.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MoviePage extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String YOUTUBE_API_KEY = "AIzaSyBgUcx-KHVmu2j3iz_3SApz39TawgYhKa8L";
    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(YOUTUBE_API_KEY, this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView title=findViewById(R.id.moviepage_title);
        TextView description=findViewById(R.id.moviepage_description);

//        Intent previnent=getIntent();
        prevIntent = getIntent();

        title.setText(prevIntent.getStringExtra("video"));
        description.setText(prevIntent.getStringExtra("description"));
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(null== youTubePlayer) return;

        // Start buffering
        if (!b) {
            String video = prevIntent.getStringExtra("video");
            Log.i("MoviePage", video);
            youTubePlayer.cueVideo("u9Mv98Gr5pY"); // venom trailer id u9Mv98Gr5pY
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.i("MoviePage", "Failed");
    }
}
