package com.sghh.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    ArrayList<String> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        AccountManager am = AccountManager.get(this);
        Account[] accounts = am.getAccountsByType("com.google");

        // mArrayListにaccountsのnameを格納
        for (int i = 0; i < accounts.length; i++) {
            mArrayList.add(accounts[i].name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, mArrayList);
        AutoCompleteTextView mail_view = findViewById(R.id.edit_email_address);

        mail_view.setAdapter(adapter);
    }
}