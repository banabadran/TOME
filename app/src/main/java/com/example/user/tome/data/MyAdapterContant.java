package com.example.user.tome.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.tome.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/12/2017.
 */
        public class MyAdapterContant extends ArrayAdapter<MyContant> {
            private DatabaseReference reference;

            public MyAdapterContant(Context context, int resource) {
                super(context, resource);
                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
                email = email.replace(".", "_");
                reference = FirebaseDatabase.getInstance().getReference(email).child("my task");
            }
    public View getView(int postion, View convertView, ViewGroup parent) {

        TextView etphone = (TextView) convertView.findViewById(R.id.etPhone);
        TextView etName = (TextView) convertView.findViewById(R.id.etSearch);
        final MyContant myContant = getItem(postion);
        ImageButton imageButton3=(ImageButton)convertView.findViewById(R.id.imageButton3);


        etName.setText(myContant.getName());
        etphone.setText(myContant.getPhone());




        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }
}







