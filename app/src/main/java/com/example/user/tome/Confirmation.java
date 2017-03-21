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
        btnOk=(Button)findViewById(R.id.btnOk);
        eventHandler();
    }
    private void dataHandler() {

        String stPassword = etPassword.getText().toString();
        boolean isOk = true;

        if (stPassword.length()<1) {
            etPassword.setError("wrong Password");
            isOk = false;

        }
      if (isOk)
      {
//          Intent i=new Intent(Confirmation.this,SaveSms.class);
//          startActivity(i);

      }

    }

    private void eventHandler()
    {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
                Intent i=new Intent(Confirmation.this,SavePhotoAndVideo.class);
                startActivity(i);

            }
        });
    }
}
