package com.example.markd.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.id.setText(mMovie.get(position).getDescription());
        holder.overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String m = mMovie.get(position).getDescription();
                openWebPage(m);
            }
        });
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

        public MovieHolder(View itemView){
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.id);
            title = (TextView)itemView.findViewById(R.id.title);
            popularity = (TextView)itemView.findViewById(R.id.popularity);
            poster =(TextView)itemView.findViewById(R.id.poster_path);
            language =(TextView)itemView.findViewById(R.id.orginal_language);
            overview =(TextView)itemView.findViewById(R.id.overview);

        }

        void bind(final int listIndex) {
            id.setText(mMovie.get(listIndex).getId());
            title.setText(mMovie.get(listIndex).getTitle());
            // itemView.setOnClickListener(this);
        }

    }
}
