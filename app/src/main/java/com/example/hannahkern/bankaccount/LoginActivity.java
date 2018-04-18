package com.example.hannahkern.bankaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private final AppCompatActivity activity = LoginActivity.this;


    private EditText mEditText1;
    private EditText mEditText2;
    private Button mLogin;
    private DatabaseHelper mDatabaseHelper;
    private String name;
    private String passwort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditText1 = (EditText)findViewById(R.id.userName);

        mEditText2 = (EditText)findViewById(R.id.password);

        mLogin = (Button) findViewById(R.id.signButton);
        mLogin.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (mEditText1.getText().toString().equalsIgnoreCase("h") &&
                        mEditText2.getText().toString().equalsIgnoreCase("1")){

                    Intent accountsIntent = new Intent(activity, BalanceActivity.class);
                    startActivity(accountsIntent);

                }
                else {
                    Toast.makeText(activity, "Please enter valid name and password", Toast.LENGTH_SHORT).show();
                }

            }

        });
        mDatabaseHelper = new DatabaseHelper(activity);

    }





}
