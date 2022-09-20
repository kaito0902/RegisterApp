package com.sghh.android;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button mRegister_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRegister_button = findViewById(R.id.register_button);

        mRegister_button.setOnClickListener(view -> {
            // GET_ACCOUNTSが許可されている場合true
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
                onRegistrationStart();
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.GET_ACCOUNTS}, 0);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onRegistrationStart();
            }
        }
    }

    // RegistrationActivityへの遷移メソッド
    private void onRegistrationStart() {
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
    }
}