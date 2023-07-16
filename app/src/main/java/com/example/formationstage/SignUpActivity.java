package com.example.formationstage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpActivity extends AppCompatActivity {
    private TextView goToSignIn;
    private EditText username,signUpEmail,signUpPw,phoneNum;
    private String usernameSt,signUpEmailSt,signUpPwSt,phoneNumSt;
    private Button btnSignUp;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks
        goToSignIn = findViewById(R.id.goToSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        username = findViewById(R.id.username);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPw = findViewById(R.id.signUpPw);
        phoneNum = findViewById(R.id.phoneNum);

        firebaseAuth = FirebaseAuth.getInstance();

        goToSignIn.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
        });
        btnSignUp.setOnClickListener(v -> {
            if (validate()){
                String user_email = signUpEmail.getText().toString().trim();
                String user_password = signUpPw.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this,"Registration Done! Please check your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                        }else {
                            Toast.makeText(SignUpActivity.this,"Register FAILED!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Toast.makeText(this,"Done!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validate(){
        boolean result = false;
        usernameSt = username.getText().toString();
        signUpEmailSt = signUpEmail.getText().toString();
        signUpPwSt = signUpPw.getText().toString();
        phoneNumSt = phoneNum.getText().toString();

        if (usernameSt.isEmpty() || usernameSt.length()<7) {
            username.setError("username is Invalid!");
        }else if (signUpEmailSt.isEmpty() || !signUpEmailSt.contains("@") || !signUpEmailSt.contains(".")){
            signUpEmail.setError("Email is Invalid!");
        }else if (signUpPwSt.isEmpty() || signUpPwSt.length()<8) {
            signUpPw.setError("Password is Invalid!");
        }else if (phoneNumSt.isEmpty() || phoneNumSt.length()!=8) {
            phoneNum.setError("Phone Number is Invalid!");
        }else {
            result = true;
        }
        return result;
    }
}
