package com.example.mca.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private static final String ActivityName = "MainActivity2";
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(getApplicationContext(),"Activity 2 : OnCreate",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnCreate");
        Intent i=getIntent();
        int num1=Integer.parseInt(i.getStringExtra("Number1"));
        int num2=Integer.parseInt(i.getStringExtra("Number2"));
        String str="";
        for(int j=num1;j<=num2;j++)
        {
            int c=0;
            int k=2;
            while(k<j)
            {
                if(j%k==0)
                {
                    c++;
                }
                k++;
            }
            if(c==0 && j!=0 && j!=1)
            {
                str=str+String.valueOf(j)+",";
            }
        }
        t1=(TextView)findViewById(R.id.seriesTxt);
        if(str=="")
        {
            t1.setText("No Prime Numbers");
        }
        else {
            t1.setText(str);
        }
        b1=(Button)findViewById(R.id.checkAnother);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnStart",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnStart");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnResume",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnResume");

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnPause",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnResume");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnRestart",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnRestart");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnStop",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Activity 2 : OnDestroy",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnDestroy");
    }
}
