package com.example.android.navtest;

import android.support.annotation.NonNull;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    public static String userEmail;//3amlo 34an lma eluser lma y3ml login asglo, bdl m3ml method w 7war y3ny........................nope,lma el user y3ml login hytsgl 34an bzbt,then that's wrong? bs wierdo fa45 , w m4 3arf a search ezay 3n elmo4kla deh, y3ny el condition sa7 w at722 bs elstudio m2moos

    private EditText editTextEmail;
    private EditText editTextPassword;
    private AppCompatButton buttonSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth = FirebaseAuth.getInstance();
        editTextEmail = (EditText) findViewById(R.id.input_email);
        editTextPassword = (EditText) findViewById(R.id.input_password);
        buttonSignup = (AppCompatButton) findViewById(R.id.btn_login);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
    }
    public void loginUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            //display some message here
                            Toast.makeText(loginActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            userEmail=editTextEmail.getText().toString();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            openHome();
                        }
                        else {
                            //display some message here
                            Toast.makeText(loginActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    public void openHome()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View view)
    {
        loginUser();
    }
}
