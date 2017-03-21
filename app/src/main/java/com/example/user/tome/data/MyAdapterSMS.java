package com.example.user.tome.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.tome.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 11/27/2016.
 */
public class MyAdapterSMS extends ArrayAdapter<MySMS> {
    private DatabaseReference reference;

    public MyAdapterSMS(Context context, int resource) {
        super(context, resource);
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        email = email.replace(".", "_");
        reference = FirebaseDatabase.getInstance().getReference(email).child("my task");
    }

    public View getView(int postion, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.itm_diary,parent,false);

        EditText tvIsIncome = (EditText) convertView.findViewById(R.id.isIncome);
      EditText etName = (EditText) convertView.findViewById(R.id.etSearch);
        EditText etNumber = (EditText) convertView.findViewById(R.id.etNumber);
        EditText etText = (EditText) convertView.findViewById(R.id.etSearch);
        final ImageButton btnDel = (ImageButton) convertView.findViewById(R.id.btnDel);

        EditText etDate = (EditText) convertView.findViewById(R.id.etDate);
        ImageButton btnAdd = (ImageButton) convertView.findViewById(R.id.btnAdd);

        final MySMS mySMS = getItem(postion);
        tvIsIncome.setText(mySMS.isIncome()+"");
        etName.setText(mySMS.getName());
        etNumber.setText(mySMS.getNumber());
        etText.setText(mySMS.getText());
        etDate.setText((CharSequence) mySMS.getDate());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(mySMS.getId()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            Toast.makeText(getContext(), "deleted", Toast.LENGTH_LONG).show();
                            remove(mySMS);
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

