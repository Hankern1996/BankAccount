package com.example.hannahkern.bankaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class BalanceActivity extends AppCompatActivity {

    private Button withdrawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        withdrawButton = (Button)findViewById(R.id.withdraw);


    }
}
