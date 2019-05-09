package com.example.a2dbx1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2;
    TextView txtsum;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText)findViewById(R.id.txt1);
        txt2=(EditText)findViewById(R.id.txt2);
        txtsum=(TextView)findViewById(R.id.txtsum);
        btn1=(Button)findViewById(R.id.btn1);
    }
    public void gofront(View v)
    {
        Intent i1=new Intent(this,Main2Activity.class);
        Bundle b=new Bundle();
        b.putString("txt1",txt1.getText().toString());
        b.putString("txt2",txt2.getText().toString());
        i1.putExtras(b);
        startActivity(i1);
    }

    public void interchange(View v)
    {
        String t;
        t=txt1.getText().toString();
        txt1.setText(txt2.getText().toString());
        txt2.setText(t);

    }
    public void findsum(View v)
    {
        Float n1=Float.parseFloat(txt1.getText().toString());
        Float n2=Float.parseFloat(txt2.getText().toString());
        Float n3=n1/n2;
        txtsum.setText(n3.toString());
    }
}
