package com.example.user.tome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
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
 * Created by user on 3/19/2017.
 */
public class listsms extends AppCompatActivity {
    private ListView etList;
    private EditText etSearch;
    private ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listsms);

        etList = (ListView) findViewById(R.id.etList);
        etSearch = (EditText) findViewById(R.id.etSearch);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);

        eventHandler();
        dataHandler();

    }
    protected void onStart(){
        super.onStart();
    }
    private void dataHandler() {
        String stText = etSearch.getText().toString();

        boolean isOk = true;

        if (etSearch.length() == 0) {
            etSearch.setError("wrong Text");
            isOk = false;
        }

        if (isOk) {

            listsms listSms = new listsms();
          //  listSms.setSearch(stSearch);
        }

    }
    private void eventHandler() {


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });
    }

}
