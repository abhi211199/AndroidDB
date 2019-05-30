package com.example.resedue.resedue;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class form extends AppCompatActivity {

    EditText name,age;
    FirebaseDatabase database;
    users user;
    String s,key;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        database=FirebaseDatabase.getInstance();
        user=new users();
    }

    //getting values of form
    public void getVal()
    {
        user.setAge(age.getText().toString());
        user.setName(name.getText().toString());
        String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        user.setTimestamp(timeStamp);
    }

    public boolean check()
    {
        if(((name.getText().toString()).isEmpty())||((age.getText().toString()).isEmpty())) {
            return true;
        }
        return false;
    }
    //adding values in database
    public void add(View view) {
        if (check()) {
            Toast.makeText(form.this, "Please enter proper details!!", Toast.LENGTH_SHORT).show();
        } else {
            getVal();
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("users");
            key = ref.push().getKey();
//        Toast.makeText(this,key,Toast.LENGTH_LONG).show();
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    getVal();
                    ref.child("data").child(key).setValue(user);
                    Toast.makeText(form.this, "Data Successfully entered!!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
}
