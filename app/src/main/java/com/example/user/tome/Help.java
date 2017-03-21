package com.example.user.tome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {
    private Button btnSignUp;
    private Button btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnForgotPassword=(Button)findViewById(R.id.btnForgetPassword);
        eventHandler();

    }
    private void eventHandler()
    {
       btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent i=new Intent(Help.this,SignUp.class);
                startActivity(i);

            }
       });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Help.this,ForgetPassword.class);
                startActivity(i);

            }

});

}
}
