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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.movie.movieapp.src.dao.UserDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.mockdata.DataHelper;
import com.movie.movieapp.src.mockdata.Global;
import com.movie.movieapp.src.model.User;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // from UI
    private Button mEmailSignInButton;
    private AutoCompleteTextView username;
    private EditText password;
    private TextView registerTextView;
    private ProgressBar progressBar;

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

        if (Global.users.isEmpty()) {
            DataHelper.insertUsers(db);
        }
        Global.users = userDao.getAll();
        // Set up the login form.
        this.username = (AutoCompleteTextView) findViewById(R.id.username);
        this.password = (EditText) findViewById(R.id.password);
        this.mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        this.registerTextView = (TextView) findViewById(R.id.registerTextView);
        this.progressBar = (ProgressBar) findViewById(R.id.login_progress);
        this.clickSignIn();
        this.goToRegister();
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
            for (User u : Global.users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    userPassMatches = true;
                }
            }
            if (!userPassMatches) {
                this.alertDialog("Wrong username or/and password!");
            }
        }
        if (userPassMatches) {
            this.progressBar.setVisibility(View.VISIBLE);
            Intent myIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(myIntent);
            this.progressBar.setVisibility(View.INVISIBLE);
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

    private void goToRegister() {
        this.registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(myIntent);
            }
        });
    }


}

