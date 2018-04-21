package com.movie.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.movie.movieapp.src.model.Movie;

public class ShowDetailsActivity extends AppCompatActivity {

    public static Movie movie;

//    public ShowDetailsActivity(Movie movie) {
//        this.movie = movie;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        TextView nameTextView = findViewById(R.id.plainTextName);
        nameTextView.setText(movie.getDescription());

    }


}
