package com.example.mca.layoutsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    EditText user;
    EditText pass;
    EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.subBtn);
        user=(EditText)findViewById(R.id.editName);
        pass=(EditText)findViewById(R.id.editPass);
        mail=(EditText)findViewById(R.id.editEmail);
    }
    public void regSuccess(View v)
    {
        if(user.getText().toString().trim().length()<=0)
        {
            Toast.makeText(getApplicationContext(),"Enter UserName",Toast.LENGTH_SHORT).show();
        }
        else if(pass.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
        }
        else if(mail.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(getApplicationContext(),"Enter Mail",Toast.LENGTH_SHORT).show();
        }
        else {
            regDetails.users[regDetails.userNos]=user.getText().toString();
            regDetails.pass[regDetails.userNos]=user.getText().toString();
            regDetails.userNos++;
            Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }

    }
}
