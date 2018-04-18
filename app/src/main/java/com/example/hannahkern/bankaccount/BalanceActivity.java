package com.example.hannahkern.bankaccount;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannahkern.bankaccount.database.AccountBaseHelper;
import com.example.hannahkern.bankaccount.database.AccountDbSchema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalanceActivity extends AppCompatActivity {

    private Button withdrawButton;
    private TextView balance;
    private String mBalance;
    private Person mPerson;


    private Context mContext;
    private SQLiteDatabase mDatabase;

    private BalanceActivity(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new AccountBaseHelper(mContext).getWritableDatabase();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        balance = (TextView) findViewById(R.id.balance);

        withdrawButton = (Button)findViewById(R.id.withdraw);
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAccount(mPerson);
            }
        });
    }

    private static ContentValues getContentValues (Person person){
        ContentValues values = new ContentValues();
        values.put(AccountDbSchema.AccountTable.Cols.UUID, person.getId().toString());
        values.put(AccountDbSchema.AccountTable.Cols.NAME, person.getName());
        values.put(AccountDbSchema.AccountTable.Cols.PASSWORD, person.getPasswort());
        values.put(AccountDbSchema.AccountTable.Cols.BALANCE, person.getBalance());

        return values;
    }

    public void updateAccount(Person person){
        String uuidString = person.getId().toString();
        ContentValues values = getContentValues(person);

        mDatabase.update(AccountDbSchema.AccountTable.NAME, values, AccountDbSchema.AccountTable.Cols.UUID + " =?",
                new String[] { uuidString});
    }
}
