package com.example.markd.popularmovies;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkParsing extends AsyncTask<Integer,Void,ArrayList<Movie>>  {


    public  MovieRecyclerView mAdapter;

    private ArrayList<Movie> getPopularMovies()
    {
        return getPopularMovies(1);
    }
    private ArrayList<Movie> getPopularMovies(int page)
    {
        ArrayList<Movie> output=new ArrayList<Movie>();
        TmdbMovies tmdb=new TmdbApi("6b4dcbc10b352b07959f8f3a9799126e").getMovies();
        MovieResultsPage result=tmdb.getPopularMovies("en",page);


        for(int i=0;i<result.getResults().size();i++)
        {
            output.add(getMovie(result.getResults().get(i).getId(),tmdb));

        }





        return output;
    }
    private Movie getMovie(int id,TmdbMovies tmdb)
    {
        Movie movie=null;
        MovieDb movieDb=tmdb.getMovie(id,"en",TmdbMovies.MovieMethod.popular,TmdbMovies.MovieMethod.videos,
                TmdbMovies.MovieMethod.similar);

        String videolink="";
        List<Video> videos = movieDb.getVideos();

        if(videos.size()>0)
        {
            for(int i=0;i< videos.size();i++)
            {

                if(videos.get(i).getSite().equals("YouTube"))
                {
                    if(videos.get(i).getType().equals("Trailer")) {
                        videolink = videos.get(i).getKey();
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> similarMovies=new ArrayList<Integer>();
        for (int i = 0; i < movieDb.getSimilarMovies().size(); i++) {
            similarMovies.add(movieDb.getSimilarMovies().get(i).getId());

        }

        movie=new Movie(movieDb.getImdbID(),movieDb.getPosterPath(),movieDb.getTitle(),movieDb.getOverview(),movieDb.getId(),movieDb.getBackdropPath(),movieDb.getReleaseDate(),videolink,similarMovies);


        return movie;
    }


    @Override
    protected ArrayList<Movie> doInBackground(Integer... ints) {
         if(ints.length>0)
         {

             return mAdapter.mMovie=getPopularMovies();
         }
         else
         {
             return getPopularMovies(ints[0]);
         }
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> movies) {
        super.onPostExecute(movies);
        mAdapter.notifyDataSetChanged();
    }

    public void setAdapter(MovieRecyclerView mAdapter) {
        this.mAdapter=mAdapter;
    }
}
