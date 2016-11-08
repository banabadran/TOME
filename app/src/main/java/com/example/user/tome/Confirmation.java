package com.example.user.tome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Confirmation extends AppCompatActivity {
    private EditText etPassword;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        etPassword=(EditText)findViewById(R.id.etPassword);
        //eventHandler();
    }
    private void dataHandler(){
        String stPassword=etPassword.getText().toString();
        Boolean isOk=true;
        if(stPassword.length()==0)
            etPassword.setError("wrong Password");
           isOk=false;
    }
    private void eventHandler()
    {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent()
            }
        });
    }
}
