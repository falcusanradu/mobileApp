package com.movie.movieapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.movie.movieapp.src.Session.Session;
import com.movie.movieapp.src.dao.MovieDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.model.Movie;

import java.util.Arrays;
import java.util.List;

public class ShowDetailsActivity extends AppCompatActivity {



    public static Movie movie;

//    public ShowDetailsActivity(Movie movie) {
//        this.movie = movie;
//    }

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        TextView nameTextView = findViewById(R.id.plainTextName);
        nameTextView.setText(movie.getDescription());

        setTitle(movie.getName());

        NumberPicker picker = findViewById(R.id.numberPicker);

        picker.setMinValue(1);
        picker.setMaxValue(10);

        picker.setValue(movie.getNote());

        picker.setWrapSelectorWheel(false);

        if (!Session.getINSTANCE().getUser().getType().equals("admin")) {
            picker.setEnabled(false);
        } else {
            picker.setEnabled(true);
        }

        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                movie.setNote(newVal);
            }
        });

        btn = findViewById(R.id.btnStatus);

        btn.setText(movie.getStatus());

    }

    void changeStatus(View view) {


        if (!btn.getText().toString().equals("seen")) {
            btn.setText("seen");
        } else {
            btn.setText("unseen");
        }

        movie.setStatus(btn.getText().toString());

    }
    

    @Override
    public void onBackPressed() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        MovieDao movieDao = db.movieDao();
        movieDao.update(movie);

        super.onBackPressed();
    }




}
