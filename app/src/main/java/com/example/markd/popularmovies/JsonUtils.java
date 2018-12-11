package com.example.markd.popularmovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {


    public static ArrayList<Movie> parseNews(String testString) {
        ArrayList<Movie> output=new ArrayList<Movie>();
        JSONObject json= null;
        try {
            json = new JSONObject(testString);
            JSONArray articles=json.getJSONArray("results");
            for(int i=0;i<articles.length();i++)
            {
                JSONObject temp=articles.getJSONObject(i);
                output.add(new Movie((String)temp.get("id"),(String)temp.get("title"),
                        (String)temp.get("popularity"),(String)temp.get("poster_path"),(float)temp.get("orginal_language"),
                        (String)temp.get("overview")));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return output;

    }


}

