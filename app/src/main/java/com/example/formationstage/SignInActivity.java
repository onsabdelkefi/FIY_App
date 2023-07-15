package com.example.formationstage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity {
    private TextView goToSignUp,goToForgetPw;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Hooks
        goToSignUp = findViewById(R.id.goToSignUp);
        goToForgetPw = findViewById(R.id.goToForgetPw);
        btnSignIn = findViewById(R.id.btnSignIn);

        goToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
        });
        goToForgetPw.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this,ForgetActivity.class));
        });

    }
}