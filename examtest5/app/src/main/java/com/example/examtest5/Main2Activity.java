package com.example.examtest5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2=(Button)findViewById(R.id.button2);
    }
    public  void  btnclicky(View v)
    {
        Intent in2;
        in2=new Intent(this,MainActivity.class);
        startActivity(in2);

    }
}
