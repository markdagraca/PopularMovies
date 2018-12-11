package com.example.markd.popularmovies;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkParsing  {



    public static ArrayList<Movie> parseMovie(String jsonData) {
        ArrayList<Movie> listOfNews = new ArrayList<Movie>();

        try {
            JSONObject obj = new JSONObject(jsonData);
            JSONArray articles = obj.getJSONArray("articles");

            for (int i = 0; i < articles.length(); i++) {

                JSONObject curr = articles.getJSONObject(i);

                listOfNews.add(new Movie(curr.getString("id"),
                        curr.getString("title"), curr.getString("description"),
                        curr.getString("url"), curr.getLong("urlToImage"),
                        curr.getString("publishedAt")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listOfNews;
    }




}
