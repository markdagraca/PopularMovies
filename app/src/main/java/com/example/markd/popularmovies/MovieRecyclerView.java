package com.example.markd.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MovieRecyclerView extends RecyclerView.Adapter<MovieRecyclerView.MovieHolder> {

    Context mContext;
    ArrayList<Movie> mMovie;

    public MovieRecyclerView(Context context, ArrayList<Movie> movieData) {
        this.mContext = context;
        this.mMovie = movieData;

    }

    @Override
    public MovieRecyclerView.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttatchToParentImmiatley = false;
        View view = inflater.inflate(R.layout.item, parent, shouldAttatchToParentImmiatley);
        MovieHolder viewHolder = new MovieHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(MovieRecyclerView.MovieHolder holder , final int position)
    {
        holder.title.setText(mMovie.get(position).getTitle());
//        holder.id.setText(mMovie.get(position).getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(mContext,MoviePage.class);;
             intent.putExtra("movie",mMovie.get(position).getId());
             intent.putExtra("title",mMovie.get(position).getTitle());
             intent.putExtra("poster",mMovie.get(position).getPosterUrl());
             intent.putExtra("backdrop",mMovie.get(position).getBackdropPath());
             intent.putExtra("description",mMovie.get(position).getDescription());

             Intent[] i={intent};
             mContext.startActivities(i);

            }
        });
        holder.setIndex(position);
        holder.loadimage(mMovie.get(position).getPosterUrl());

    }
    @Override
    public int getItemCount() {
        return mMovie.size();
    }


    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            webpage = Uri.parse("http://" + url);
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }
    public class MovieHolder extends RecyclerView.ViewHolder {

        private TextView id,title,popularity,poster,language,overview;
        private ImageView image;
        int index;
        String posterUrl="";


        public MovieHolder(View itemView){
            super(itemView);
            posterUrl=mMovie.get(index).getPosterUrl();

//
//            title = (TextView)itemView.findViewById(R.id.title);
//
//
//
//            title.setVisibility(View.INVISIBLE);
            title=itemView.findViewById(R.id.movie_title);
            image=itemView.findViewById(R.id.poster);
            Log.d("MovieViewHolder", "MovieHolder: "+posterUrl);



        }

        void bind(final int listIndex) {
            id.setText(mMovie.get(listIndex).getId());
            title.setText(mMovie.get(listIndex).getTitle());
            index=listIndex;
            posterUrl=mMovie.get(listIndex).getPosterUrl();
            Log.d("MovieViewHolder", "bind: "+mMovie.get(listIndex).getTitle());

            // itemView.setOnClickListener(this);
        }
        void setIndex(int index)
        {
            this.index=index;
        }
        void loadimage(String Url)
        {
            Picasso.get().load("https://image.tmdb.org/t/p/w400"+Url).into(image);
        }


    }
}
