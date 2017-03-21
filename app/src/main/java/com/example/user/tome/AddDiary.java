package com.example.user.tome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tome.data.MyDiary;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddDiary extends AppCompatActivity {
    private TextView etText;
    private TextView etTitle;
    private Date etDate;
    private RatingBar ratingBar;
    private ImageButton btnAdd;
    private ImageButton btnDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        etTitle= (EditText)findViewById(R.id.etTitle);
        etText=(EditText)findViewById(R.id.etSearch);
        btnDel = (ImageButton) findViewById(R.id.btnDel);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        eventHandler();

    }

    private void dataHandler() {
        String stText = etText.getText().toString();
        String stTitle = etTitle.getText().toString();
      int rate=ratingBar.getNumStars();
        boolean isOk = true;

        if (etText.length() == 0) {
            etText.setError("wrong Text");
            isOk = false;
        }
        if (etTitle.length() == 0) {
            etTitle.setError("wrong Text");
            isOk = false;
        }

        if (isOk) {
            MyDiary myDiary = new MyDiary();
            Date mydate = Calendar.getInstance().getTime();

            myDiary.setText(stText);
            myDiary.setTitle(stTitle);
            myDiary.setDate(mydate);
            myDiary.setImportance(rate);


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email = email.replace(".", "_");
            reference.child(email).child("my_diary").push().setValue(myDiary, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        Toast.makeText(AddDiary.this, "saved", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(AddDiary.this, "saving filed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void eventHandler()
    {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });


    }



}


