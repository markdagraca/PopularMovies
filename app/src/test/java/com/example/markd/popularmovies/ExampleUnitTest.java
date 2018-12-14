package com.example.markd.popularmovies;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void dbTest()
    {
        ArrayList<Movie> output=new ArrayList<Movie>();
        TmdbMovies tmdb=new TmdbApi("6b4dcbc10b352b07959f8f3a9799126e").getMovies();
        MovieResultsPage result=tmdb.getPopularMovies("en",1);
        MovieDb movie=tmdb.getMovie(result.getResults().get(0).getId(),"en",TmdbMovies.MovieMethod.popular,TmdbMovies.MovieMethod.videos,
                TmdbMovies.MovieMethod.similar);
    }
    @Test
    public void commentTest()
    {
        Comment comment=new Comment("markdagraca","test",new Date());
        CommentList.addcomment(1234,comment);

    }

}
