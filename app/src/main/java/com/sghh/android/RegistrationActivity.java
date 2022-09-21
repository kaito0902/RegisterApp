package com.sghh.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        AccountManager am = AccountManager.get(this);
        Account[] accounts = am.getAccountsByType("com.google");

        ArrayAdapter<Account> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, accounts);
        AutoCompleteTextView mail_view = findViewById(R.id.edit_email_address);

        mail_view.setAdapter(adapter);
    }
}