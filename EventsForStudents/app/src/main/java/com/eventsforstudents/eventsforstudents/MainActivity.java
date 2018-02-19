package com.eventsforstudents.eventsforstudents;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button btnLogin;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_for_students);

        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().equals("") || password.getText().toString().equals("")) {

                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Fix this error");
                    builder.setMessage("Enter email and password");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                else
                {
                    BackgroundTask backgroundTask = new BackgroundTask(MainActivity.this);
                    backgroundTask.execute("login", email.getText().toString(), password.getText().toString());
                }
            }
        });

        configureSignUpButton();
    }

    private void configureSignUpButton(){
        Button signUpButton = (Button) findViewById(R.id.signUp_btn);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}
