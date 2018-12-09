package com.example.markd.popularmovies;


import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {


    /**
     * These utilities will be used to communicate with the network.
     */

    final static String MOVIEDB_API_URL =
           " https://api.themoviedb.org/3/movie/popular?api_key=6b4dcbc10b352b07959f8f3a9799126e&language=en-US&page=1";

    public static URL buildURL (){
        Uri builtUri = Uri.parse(MOVIEDB_API_URL).buildUpon(). build();

        URL url = null;


        try{
            url = new URL(builtUri.toString());
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }

        return url;

    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}

