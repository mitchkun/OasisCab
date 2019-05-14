package com.example.oasiscab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeScreen extends AppCompatActivity {

    private ImageView nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               intentToSignUp();
            }
        });
    }

    //    intent to sign up screen
    public  void intentToSignUp(){

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
//      Slide to the left when moving to the new one
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}
