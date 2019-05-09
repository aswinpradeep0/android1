package com.example.a2acteg1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText)findViewById(R.id.txt1);
        txt2=(EditText)findViewById(R.id.txt2);

    }

    public void onbtn1clicked(View v)
    {
        Intent i1=new Intent(this,Main2Activity.class);
        i1.putExtra("name",txt1.getText().toString());
        i1.putExtra("subject",txt2.getText().toString());

        startActivity(i1);

    }
}
