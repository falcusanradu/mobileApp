package com.movie.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText toSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toSearchText = findViewById(R.id.searchText);


    }

    void search(View view) {

        String text = toSearchText.getText().toString();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        switch (view.getId()){
            case R.id.btnSearch:
                if (text.isEmpty()) {
                    return;
                }

                intent.putExtra("searchKey", text);
                break;



            case R.id.btnAllMovies:
                intent.putExtra("searchKey", "all");
                break;

            case R.id.btnHorror:
                intent.putExtra("searchKey", "horror");
                break;

            case R.id.btnAction:
                intent.putExtra("searchKey", "action");
                break;

            case R.id.btnComedy:
                intent.putExtra("searchKey", "comedy");
                break;

            case R.id.btnDrama:
                intent.putExtra("searchKey", "drama");
                break;

            case R.id.btnAdventure:
                intent.putExtra("searchKey", "adventure");
                break;

            case R.id.btnOtherGenres:
                intent.putExtra("searchKey", "other");
                break;
            case R.id.btnThriller:
                intent.putExtra("searchKey", "thriller");
                break;
        }

        startActivity(intent);




    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void logout(View view) {
        super.onBackPressed();
    }

}
