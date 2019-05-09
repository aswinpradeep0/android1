package com.example.a2dbx1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txt3,txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        Bundle b=getIntent().getExtras();
        txt3.setText(b.getString("txt1"));
        txt4.setText(b.getString("txt2"));
    }
    public  void goback(View v)
    {
        Intent i2=new Intent(this,MainActivity.class);
        startActivity(i2);
    }

}
