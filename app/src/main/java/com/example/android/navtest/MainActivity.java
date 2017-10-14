package com.example.android.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
    }
    public void loginForm(View view)
    {
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
        finish();
    }

    public void signupForm(View view)
    {
        Intent intent = new Intent(this, signupActivity.class);
        startActivity(intent);
    }


}
