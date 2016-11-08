package com.example.user.tome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class SignIn extends AppCompatActivity {
private EditText etEmail;
    private EditText etPassword;
    private EditText etRePassword;
    private EditText etName ;
    private Button btnSave;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.setValue("hello world");
        reference.push().setValue("hello world");
        etEmail=(EditText) findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etpassword);
        etRePassword=(EditText)findViewById(R.id.etRePassword);
        etName=(EditText)findViewById(R.id.etName);
        btnSave=(Button)findViewById(R.id.btnSave);
        auth= FirebaseAuth.getInstance();
        eventHandler();



    }


    private void dataHandler() {
        String stEmail = etEmail.getText().toString();
        String stName = etName.getText().toString();
        String stpassword = etPassword.getText().toString();
        String stRePassword = etRePassword.getText().toString();
        Boolean isOk = true;
        if (stEmail.length() == 0) {
            etEmail.setError("wrong Email");
            isOk = false;
        }
        if (stName.length() == 0) {
            etName.setError("wrong Name");
            isOk = false;

        }
        if (stpassword.length() == 0) {
            etPassword.setError("wrong Password");
            isOk = false;
        }
        if (stRePassword.length() == 0) {
            etRePassword.setError("wrong RePassword");
            isOk = false;
        }
        if (isOk) {
            //msh 3arfe aza crraet ao sign in
           creatAcount(stEmail, stpassword);
        }
    }

        private void eventHandler()
    {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent i=new Intent(SignIn.this, TheFirst.class);
                dataHandler();
            //  startActivity(i);
            }

        });
    }
    private FirebaseAuth.AuthStateListener authStateListener1=new FirebaseAuth.AuthStateListener()
    {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            //4.
            FirebaseUser user=firebaseAuth.getCurrentUser();
            if(user!=null)
            {
                //user is signed in
                Toast.makeText(SignIn.this, "user is signed in.", Toast.LENGTH_SHORT).show();

            }
            else
            {
                //user signed out
                Toast.makeText(SignIn.this, "user signed out.", Toast.LENGTH_SHORT).show();

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null)
            auth.removeAuthStateListener(authStateListener);
    }

    private void creatAcount(String Email, String Password ) {
        auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignIn.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignIn.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }



    private FirebaseAuth.AuthStateListener authStateListener=new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            //4.
            FirebaseUser user=firebaseAuth.getCurrentUser();
            if(user!=null)
            {
                //user is signed in
                Toast.makeText(SignIn.this, "user is signed in.", Toast.LENGTH_SHORT).show();

            }
            else
            {
                //user signed out
                Toast.makeText(SignIn.this, "user signed out.", Toast.LENGTH_SHORT).show();

            }

    }
    };
}





