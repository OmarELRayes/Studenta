package com.example.android.navtest;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;

public class signupActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPassword2;
    private AppCompatButton buttonSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        firebaseAuth = FirebaseAuth.getInstance();

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.input_email);
        editTextPassword = (EditText) findViewById(R.id.input_password);
        editTextPassword2 = (EditText) findViewById(R.id.input_cpassword);
        editTextname=(EditText) findViewById(R.id.input_name);
        buttonSignup = (AppCompatButton) findViewById(R.id.btn_signup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);

        }

    private void registerUser() {

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();
        String password2 = editTextPassword2.getText().toString();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

         if (password.equals(password2))
        {
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_LONG).show();
            return;
        }
        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            Calendar c = Calendar.getInstance();
                            //display some message here
                            Toast.makeText(signupActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            user newUser= new user(1,editTextname.getText().toString(),"blabla","01060878610",editTextEmail.getText().toString(),"blabla",c.getTime(),"Student");
                            FirebaseDatabase  database =FirebaseDatabase.getInstance();
                            DatabaseReference databaseReference=database.getReference();
                            databaseReference.child("users").push().setValue(newUser);
                        }
                        else {
                            //display some message here
                            Toast.makeText(signupActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
   @Override
    public void onClick(View view){
    registerUser();
   }


}

