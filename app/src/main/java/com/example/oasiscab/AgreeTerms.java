package com.example.oasiscab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgreeTerms extends AppCompatActivity {

    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree_terms);

        signUpBtn =findViewById(R.id.sign_up_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToMainScreen();
            }
        });
    }

    public void intentToMainScreen(){

        Intent intent  = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);


    }
}
