package com.example.user.tome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        etName=(EditText)findViewById(R.id.etSearch);
        etEmail=(EditText)findViewById(R.id.etEmail);
        btnSend=(Button)findViewById(R.id.btnSend);
        eventHandler();
    }
    private void dataHandler()
    {
        String stName=etName.getText().toString();
        String stEmail=etEmail.getText().toString();
        boolean isOk=true;
        if(etName.length()==0){
            etName.setError("wrong Text");
            isOk=false;
        }
        if(etEmail.length()==0)
        {
            etEmail.setError("wrong Text");
            isOk=false;
        }
        if (isOk)
        {
        // MyTask myTask=new MyTask();


    }

    }
    private void eventHandler()
    {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ForgetPassword.this,TheFirst.class);
                dataHandler();
                startActivity(i);

            }
        });
        }
}
