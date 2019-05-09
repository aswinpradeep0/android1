package com.example.mca.activitysample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.backBtn);
        t1=(TextView)findViewById(R.id.textView1);
        Intent i=getIntent();
        int n=Integer.parseInt(i.getStringExtra("checkNum"));
        int temp=n;
        int s=0;
        while (n>0)
        {
            int r=n%10;
            s=s+(r*r*r);
            n=n/10;
        }
        if(temp==s)
        {
            t1.setText(String.valueOf(temp)+" is an Armstrong Number");
        }
        else
        {
            t1.setText("Not an armstrong number");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
