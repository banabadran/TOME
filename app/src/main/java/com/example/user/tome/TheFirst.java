package com.example.user.tome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.SignInButton;

public class TheFirst extends AppCompatActivity
{
   private Button btnHelp;
    private Button btnOk;
    private EditText etPassword;
    private TextView tvToMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_first);
        btnHelp=(Button) findViewById(R.id.btnHelp);
        btnOk=(Button)findViewById(R.id.btnOk);
        etPassword=(EditText)findViewById(R.id.etPassword);
        tvToMe=(TextView)findViewById(R.id.tvToMe);
       eventHandler();

    }
    private void dataHandler(){
        String stPassword=etPassword.getText().toString();
        boolean isok=true;

        if(stPassword.length()==0)
        {
            etPassword.setError("wrong Password");
            isok=false;
        }
        if(isok)//true password
        {
            Intent i = new Intent(TheFirst.this, MainActivity.class);

            startActivity(i);
        }

    }
    private void eventHandler()
    {
        btnHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TheFirst.this, Help.class);
                startActivity(i);
            }
            });
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                dataHandler();

            }
            });

    }
}
