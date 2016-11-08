package com.example.user.tome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class List extends AppCompatActivity {
    private Button btnPhoto;
    private Button btnVideo;
    private Button btnMassage;
    private Button btnDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btnPhoto=(Button)findViewById(R.id.btnPhoto);
        btnVideo=(Button)findViewById(R.id.btnVideo);
        btnMassage=(Button)findViewById(R.id.btnMassage);
        btnDiary=(Button)findViewById(R.id.btnDiary);
        //eventHandler();
    }
    private void eventHandler()
    {
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        }
    }

