package com.example.resedue.resedue;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class server extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    List<users> list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("users").child("data");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<users>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    Toast.makeText(MainActivity.this, dataSnapshot1.getKey(), Toast.LENGTH_SHORT).show();
                    users val = dataSnapshot1.getValue(users.class);
                    users user = new users();
                    String name = val.getName();
//                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    String age = val.getAge();
//                    ref=dataSnapshot1.getKey();
                    String timestamp=val.getTimestamp();

                    user.setName(name);
                    user.setAge(age);
                    user.setTimestamp(timestamp);
                    //user.setKey(dataSnapshot1.getKey());
                    list.add(user);
//                    if(sell.equals("Government"))
//                    {list.add(user);
//                    tx.setText("");}
                }
                Collections.reverse(list);
                RecyclerAdapter1 recyclerAdapter = new RecyclerAdapter1(server.this,list);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(server.this,1);
                recyclerView.setLayoutManager(recyce);
                recyclerView.setItemAnimator( new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });
    }
}
