package com.example.formationstage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    private TextView goToSignIn;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks
        goToSignIn = findViewById(R.id.goToSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        goToSignIn.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
        });
    }
}