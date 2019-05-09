package com.example.mca.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String ActivityName = "MainActivity";
    Button b1;
    EditText e1;
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Activity 1 : OnCreate",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnCreate");
        b1=(Button)findViewById(R.id.checkButton1);
        e1=(EditText)findViewById(R.id.numEdit1);
        e2=(EditText)findViewById(R.id.numEdit2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                i.putExtra("Number1",e1.getText().toString());
                i.putExtra("Number2",e2.getText().toString());
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart()
    {
super.onStart();
Toast.makeText(getApplicationContext(),"Activity 1 : OnStart",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnStart");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Activity 1 : OnResume",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnResume");

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Activity 1 : OnPause",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnResume");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"Activity 1 : OnRestart",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnRestart");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Activity 1 : OnStop",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Activity 1 : OnDestroy",Toast.LENGTH_SHORT).show();
        Log.d(ActivityName,"OnDestroy");
    }
}
