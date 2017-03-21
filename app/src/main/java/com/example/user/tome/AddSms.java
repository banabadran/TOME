package com.example.user.tome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tome.data.MySMS;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 2/26/2017.
 */
public class AddSms extends AppCompatActivity {
    private TextView isIncome;
    private TextView etName;
    private TextView etNumber;
    private TextView etText;
   private ImageButton btnDel;
    private ImageButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etText = (EditText) findViewById(R.id.etSearch);
        etName = (EditText) findViewById(R.id.etSearch);
        btnDel = (ImageButton) findViewById(R.id.btnDel);
        btnAdd=(ImageButton)findViewById(R.id.btnAdd);
        isIncome = (EditText) findViewById(R.id.isIncome);
        etNumber = (EditText) findViewById(R.id.etNumber);
         eventHandler();
        dataHandler();

    }

    private void dataHandler() {
        String stText = etText.getText().toString();
        String stisIncome = isIncome.getText().toString();
        String stName = etName.getText().toString();
        String stNumber = etNumber.getText().toString();
        boolean isOk = true;

        if (etText.length() == 0) {
            etText.setError("wrong Text");
            isOk = false;
        }
        if (etName.length() == 0) {
            etName.setError("wrong Text");
            isOk = false;
        }
        if (etNumber.length() == 0) {
            etNumber.setError("wrong Text");
            isOk = false;
        }

        if (isIncome.length() == 0) {
            isIncome.setError("wrong Text");
            isOk = false;
        }
        if (isOk) {

            MySMS mySms = new MySMS();
           Date mydate= Calendar.getInstance().getTime();
            mySms.setText(stText);
            mySms.setName(stName);
            mySms.setNumber(stNumber);
            mySms.setIncome(stisIncome);
            mySms.setDate(mydate);


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email = email.replace(".", "_");
            reference.child(email).child("my_sms").push().setValue(mySms, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError==null)
                    {
                        Toast.makeText(AddSms.this,"saved",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(AddSms.this,"saving filed"+databaseError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }




    private void eventHandler() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddSms.this,MainActivity.class);
                startActivity(i);

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });
    }

}