package com.example.mca.applicationfourtwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.txtView1);
        t2=(TextView)findViewById(R.id.txtView2);
        Intent i=getIntent();
        t1.setText(i.getStringExtra("str"));
        t2.setText(i.getStringExtra("str2"));
    }
}
