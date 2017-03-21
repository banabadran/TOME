package com.example.user.tome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.user.tome.data.MyAdapterDiary;
import com.example.user.tome.data.MyAdapterSMS;
import com.example.user.tome.data.MyDiary;
import com.example.user.tome.data.MySMS;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button btnPhotoandVideo;
    private Button btnSms;
    private Button btnDiary;
    private ImageButton btnAdd;
    MyAdapterDiary adapterDiary;
    MyAdapterSMS adapterSMS;
    RadioButton rbDiary, rbSms, rbMedia;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);

        list = (ListView) findViewById(R.id.listView);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        rbDiary = (RadioButton) findViewById(R.id.btnDiary);
        rbSms = (RadioButton) findViewById(R.id.btnSms);
        rbMedia = (RadioButton) findViewById(R.id.btnPhotoandVideo);
        eventHandler();


        adapterDiary = new MyAdapterDiary(getBaseContext(), R.layout.activity_diary);
        list.setAdapter(adapterDiary);


        adapterSMS = new MyAdapterSMS(getBaseContext(), R.layout.activity_sms);
       list.setAdapter(adapterSMS);
    }

    private void eventHandler() {


        rbDiary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                    initListViewDairy();
            }
        });
        rbSms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    initListViewSMS();
                }
            }
        });
        rbMedia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    // initListViewDairy();
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbDiary.isChecked()) {
                    startActivity(new Intent(getBaseContext(), AddDiary.class));

                }
                if (rbSms.isChecked()) {
                    startActivity(new Intent(getBaseContext(), AddSms.class));

                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (rbDiary.isChecked()) {
            initListViewDairy();
        }
        if (rbSms.isChecked()) {
            initListViewSMS();


        }
    }

    private void initListViewDairy() {

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child(email).child("my_diary").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapterDiary.clear();
                list.setAdapter(adapterDiary);
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MyDiary myTask = ds.getValue(MyDiary.class);
                    myTask.setId(ds.getKey());
                    adapterDiary.add(myTask);
                }
                list.setAdapter(adapterDiary);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void initListViewSMS() {

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child(email).child("my_sms").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapterSMS.clear();
                list.setAdapter(adapterSMS);
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MySMS myTask = ds.getValue(MySMS.class);
                    myTask.setId(ds.getKey());
                    adapterSMS.add(myTask);
                }
                list.setAdapter(adapterSMS);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}





