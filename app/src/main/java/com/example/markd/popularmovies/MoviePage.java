package com.example.markd.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Date;

public class MoviePage extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String YOUTUBE_API_KEY = "AIzaSyBgUcx-KHVmu2j3iz_3SApz39TawgYhKa8L";
    private Intent prevIntent;
    private ArrayList<Comment> comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
        prevIntent = getIntent();
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(YOUTUBE_API_KEY, this);

        ListView listView=findViewById(R.id.comment_list);

        comments=CommentList.getComments(Integer.parseInt(prevIntent.getStringExtra("movie")));
        CommentAdapter adapter=new CommentAdapter(this,comments);
        listView.setAdapter(adapter);
        Button submit=findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView text=findViewById(R.id.moviepage_comment);
                if(text.getText().length()>0&&User.username!=null) {
                    CommentList.addcomment(new Comment(User.username, text.getText().toString(), new Date(), Integer.parseInt(prevIntent.getStringExtra("movie"))));
                    text.setText("");
                    finish();
                    startActivity(getIntent());

                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        comments.clear();

        TextView title=findViewById(R.id.moviepage_title);
        TextView description=findViewById(R.id.moviepage_description);
        title.setText(prevIntent.getStringExtra("title"));
        description.setText(prevIntent.getStringExtra("description"));
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(null== youTubePlayer) return;

        // Start buffering
        if (!b) {
            String video = prevIntent.getStringExtra("video");
            Log.i("MoviePage", video);
            youTubePlayer.cueVideo(video); // venom trailer id u9Mv98Gr5pY
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.i("MoviePage", "Failed");
    }
}
