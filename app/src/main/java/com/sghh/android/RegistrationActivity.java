package com.sghh.android;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private static final String[] MAILS = new String[]{
            "abcd@abcd.com", "efgh@efgh.com", "ijkl@ijklcom", "mnop@mnop.com",
            "aaa@aaa.com", "aaaa@aaaa.com", "aaaaa@aaaaa.com"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, MAILS);
        AutoCompleteTextView mail_view = findViewById(R.id.edit_email_address);

        mail_view.setAdapter(adapter);
    }
}