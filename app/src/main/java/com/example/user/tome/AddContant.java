package com.example.user.tome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tome.data.MyContant;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/14/2017.
 */
public class AddContant {
    public class AddDiary extends AppCompatActivity {
        private TextView etName;
        private TextView etphone;
        private ImageButton imageButton3;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contant);

            etName= (EditText)findViewById(R.id.etSearch);
            etphone=(EditText)findViewById(R.id.etPhone);
            imageButton3 = (ImageButton) findViewById(R.id.imageButton3);

            eventHandler();

        }

        private void dataHandler() {
            String stphone = etphone.getText().toString();
            String stName = etName.getText().toString();
            boolean isOk = true;

            if (etphone.length() == 0) {
                etphone.setError("wrong Text");
                isOk = false;
            }
            if (etName.length() == 0) {
                etName.setError("wrong Text");
                isOk = false;
            }

            if (isOk) {
                MyContant myContant = new MyContant();

                myContant.setName(stName);
                myContant.setPhone(stphone);



                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                email = email.replace(".", "_");
                reference.child(email).child("my_Contant").push().setValue(myContant, new DatabaseReference.CompletionListener() {
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
           imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataHandler();

                }
            });


        }



    }


}
