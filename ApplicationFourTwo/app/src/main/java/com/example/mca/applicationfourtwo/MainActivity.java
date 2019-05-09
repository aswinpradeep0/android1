package com.example.mca.applicationfourtwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().length()<=0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Some Text",Toast.LENGTH_SHORT).show();
                }
                else {
                    String str="Text Entered : "+e1.getText().toString();
                    String str2="Length : "+String.valueOf(e1.getText().toString().length());
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("str",str);
                    i.putExtra("str2",str2);
                    startActivity(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().length()<=0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Some Text",Toast.LENGTH_SHORT).show();
                }
                else {
                    String str="Text Entered : "+e1.getText().toString();
                    String rev = "Reverse : ";
                    for (int j = e1.getText().toString().length()-1; j>=0;j--) {
                        rev=rev+e1.getText().toString().charAt(j);
                    }
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("str",str);
                    i.putExtra("str2",rev);
                    startActivity(i);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().length()<=0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Some Text",Toast.LENGTH_SHORT).show();
                }
                else {
                    String str="Text Entered : "+e1.getText().toString();
                    String str2="In Upper Case : "+e1.getText().toString().toUpperCase();
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("str",str);
                    i.putExtra("str2",str2);
                    startActivity(i);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().length()<=0)
                {
                    Toast.makeText(getApplicationContext(),"Enter Some Text",Toast.LENGTH_SHORT).show();
                }
                else {
                    String str="Text Entered : "+e1.getText().toString();
                    String str2="In Lower Case : "+e1.getText().toString().toLowerCase();
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("str",str);
                    i.putExtra("str2",str2);
                    startActivity(i);
                }
            }
        });
    }
}
