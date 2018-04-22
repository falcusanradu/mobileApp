package com.movie.movieapp;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.movie.movieapp.src.dao.UserDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.mockdata.DataHelper;
import com.movie.movieapp.src.model.User;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private Button mEmailSignInButton;

    // UI references.
    private AutoCompleteTextView username;
    private EditText password;

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        final UserDao userDao = db.userDao();
        DataHelper.insertUsers(db);
        this.users = userDao.getAll();
        // Set up the login form.
        username = (AutoCompleteTextView) findViewById(R.id.username);

        password = (EditText) findViewById(R.id.password);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        this.clickSignIn();

    }


    private void clickSignIn() {
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        boolean userPassMatches = false;
        if (username.isEmpty() || password.isEmpty()) {
            // error
            this.alertDialog("Email and password must not be empty!");
        } else {
            for (User u : this.users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    userPassMatches = true;
                }
            }
            if (!userPassMatches) {
                this.alertDialog("Wrong username or/and password!");
            }
        }
        if (userPassMatches) {
            Intent myIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(myIntent);
        }
    }

    private void alertDialog(final String message) {
        AlertDialog.Builder alertDialogBuidler = new AlertDialog.Builder(this);
        alertDialogBuidler.setMessage(message).setCancelable(false).setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuidler.create();
        alertDialog.setTitle("Error!");
        alertDialog.show();
    }


}

