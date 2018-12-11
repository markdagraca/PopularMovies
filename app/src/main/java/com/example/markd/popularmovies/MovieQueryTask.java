package com.example.markd.popularmovies;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class MovieQueryTask extends AsyncTask<Void, Void, String> {




    TextView mSearchResultsTextView;
    @Override
    protected String doInBackground(Void... voids) {
        try {
            String json = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildURL());

     Log.d("here ","test" + json);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
