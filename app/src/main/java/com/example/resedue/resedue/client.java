package com.example.resedue.resedue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class client extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
    }

    public void fx(View view)
    {
        Intent intent=new Intent(this,form.class);
        startActivity(intent);
    }
    public void fx1(View view)
    {
        Intent intent=new Intent(this,server.class);
        startActivity(intent);
    }
}
