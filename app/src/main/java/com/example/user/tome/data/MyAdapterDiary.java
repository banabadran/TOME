package com.example.user.tome.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tome.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

/**
 * Created by user on 2/28/2017.
 */
public class MyAdapterDiary extends ArrayAdapter<MyDiary> {

    private DatabaseReference reference;

    public MyAdapterDiary(Context context, int resource) {
        super(context, resource);
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        email = email.replace(".", "_");
        reference = FirebaseDatabase.getInstance().getReference(email).child("my_diary");
    }

    public View getView(int postion, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.itm_diary,parent,false);

        TextView etTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView etText = (TextView) convertView.findViewById(R.id.tvText);
       final MyDiary myDiary = getItem(postion);
       TextView etDate = (TextView) convertView.findViewById(R.id.tvDate);
        ImageButton btnDel=(ImageButton)convertView.findViewById(R.id.btnDel);
      ImageButton btnAdd=(ImageButton)convertView.findViewById(R.id.btnAdd);


        etText.setText(myDiary.getText());
        etTitle.setText(myDiary.getTitle());

        etDate.setText( myDiary.getDate().toString());


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(myDiary.getId()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            Toast.makeText(getContext(), "deleted", Toast.LENGTH_LONG).show();
                            remove(myDiary);
                            setNotifyOnChange(true);
                        }
                    }
                });

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }
}

