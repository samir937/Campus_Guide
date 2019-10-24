package com.example.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword,inputFullName,inputBloodGroup;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.sign_in_button);
        btnSignUp = findViewById(R.id.sign_up_button);
        inputEmail = findViewById(R.id.editTextEmail);
        inputPassword = findViewById(R.id.editTextPassword);
        inputFullName=findViewById(R.id.editTextName);
        inputBloodGroup=findViewById(R.id.editTextBloodGroup);
        progressBar =  findViewById(R.id.progressBar);
        btnResetPassword = findViewById(R.id.btn_reset_password);

        getSupportActionBar().hide();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(SignupActivity.this, "Signed Up", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupActivity.this, "Prrssed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                //finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = inputFullName.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String registrationNumber = inputBloodGroup.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    inputFullName.setError("Enter Full Name!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Enter Email Address!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError("Enter Password!");
                    return;
                }

                if (password.length() < 6) {
                    inputPassword.setError("Password too short, enter minimum 6 characters!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(SignupActivity.this, "SignedUp", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignupActivity.this, Login.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
