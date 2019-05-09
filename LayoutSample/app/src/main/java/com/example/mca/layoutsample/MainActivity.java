package com.example.mca.layoutsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.loginButton);
        user=(EditText)findViewById(R.id.userNameText);
        pass=(EditText)findViewById(R.id.passText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean logged=false;
                for(int j=0;j<regDetails.userNos;j++)
                {
                    if(regDetails.users[j].equals(user.getText().toString()) && regDetails.pass[j].equals(pass.getText().toString()))
                    {
                        logged=true;
                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                    }
                }
                if(!logged)
                {
                    Toast.makeText(getApplicationContext(),"Incorrect Username or Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
