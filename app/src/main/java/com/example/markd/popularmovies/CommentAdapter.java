package com.example.markd.popularmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends ArrayAdapter<Comment> {
    public CommentAdapter(Context context, ArrayList<Comment> comments) {
      super(context,0,comments);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        Comment comment=getItem(position);
        if(convertView==null)
        {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.comment,parent,false);

        }
        TextView text=convertView.findViewById(R.id.comment_comment);
        TextView username=convertView.findViewById(R.id.comment_username);
        TextView date=convertView.findViewById(R.id.comment_date);

        text.setText(comment.getComment());
        username.setText(comment.getUsername());
        date.setText(comment.getDate().toString());


        return convertView;
    }
}
