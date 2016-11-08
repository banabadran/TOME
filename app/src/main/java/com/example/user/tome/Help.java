package com.example.user.tome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Help extends AppCompatActivity {
    private Button btnSignIn;
    private Button btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnForgotPassword=(Button)findViewById(R.id.btnForgetPassword);
        eventHandler();

    }
    private void eventHandler()
    {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Help.this,SignIn.class);
                startActivity(i);

            }
        });
    }


}
