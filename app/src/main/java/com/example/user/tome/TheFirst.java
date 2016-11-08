package com.example.user.tome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

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
      //  eventHandler();

    }
    private void dataHandler(){
        boolean isok=true;
        String stPassword=etPassword.getText().toString();
        if(stPassword.length()==0)
        {
            etPassword.setError("wrong Password");
            isok=false;
        }
        if(isok)
            Crea
    }
}
