package com.example.user.tome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by user on 3/19/2017.
 */
public class listdiary extends AppCompatActivity {
    private ListView etList;
    private EditText etSearch;
    private ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdiary);

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

            listdiary listDiary = new listdiary();
            // listdiary.setSearch(stSearch);
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

