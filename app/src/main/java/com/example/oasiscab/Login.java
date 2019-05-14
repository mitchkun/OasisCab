package com.example.oasiscab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

//    Local variable declaration

    private TextView signupText;
    private  Button loginButton;
    public EditText loginEmailId, logInpasswd;
    //Button btnLogIn;
    //TextView signup;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        loginEmailId = findViewById(R.id.phone_number);
        logInpasswd = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_btn);
        //signupText = findViewById(R.id.TVSignIn);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(Login.this, "User logged in ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(Login.this, MainActivity.class);
                    startActivity(I);
                } else {
                    Toast.makeText(Login.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

//        Local variable instantiation
        signupText = findViewById(R.id.dont_have_account);
        loginButton = findViewById(R.id.login_btn);

//        Sign up text onclick action
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToSignUp();
            }
        });

//        login button onclick action
        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToMainScreen();
            }
        });*/
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = loginEmailId.getText().toString();
                String userPaswd = logInpasswd.getText().toString();
                if (userEmail.isEmpty()) {
                    loginEmailId.setError("Provide your Email first!");
                    loginEmailId.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    logInpasswd.setError("Enter Password!");
                    logInpasswd.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(Login.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(Login.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Not successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

//    intent to sign up screen
    public  void intentToSignUp(){

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
//      Slide to the left when moving to the new one
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

//    Intent to main screen
    public void intentToMainScreen(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
