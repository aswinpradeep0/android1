package com.example.a2acteg1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

        EditText txt3,txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt3=(EditText)findViewById(R.id.txt3);
        txt4=(EditText)findViewById(R.id.txt4);
        Intent ix=getIntent();

        txt3.setText(ix.getStringExtra("name"));
        txt4.setText(ix.getStringExtra("subject"));
    }

    public void onbtn2clicked(View v)
    {
        Intent i2=new Intent(this,MainActivity.class);
        startActivity(i2);
    }
}
