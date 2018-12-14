package com.example.markd.popularmovies;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentList {
    public static void addcomment(Comment comment) {
        DocumentReference ref = FirebaseFirestore.getInstance().document("comments/" + comment.hashCode());
//        Map<String,Comment> dataToSave=new HashMap<String, Comment>();
//
//        dataToSave.put("username",comment);

        ref.set(comment);


    }
    private static ArrayList<Comment> output = new ArrayList<>();

    public static ArrayList<Comment> getComments(int movieid) {

        FirebaseFirestore.getInstance().collection("comments").whereEqualTo("id",movieid).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()) {

                    for (QueryDocumentSnapshot q : queryDocumentSnapshots) {
                        output.add(q.toObject(Comment.class));

                    }



                }
            }
        });
        return output;
    }
}








