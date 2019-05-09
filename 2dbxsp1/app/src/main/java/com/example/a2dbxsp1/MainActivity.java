package com.example.a2dbxsp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtid, txtname, txtsub;
    SharedPreferences sp;
    String oldr, newr;
    Vibrator vibrator;
    //SharedPreferences.Editor ed = sp.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtid = (EditText) findViewById(R.id.txtid);
        txtname = (EditText) findViewById(R.id.txtname);
        txtsub = (EditText) findViewById(R.id.txtsub);
        sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
        //vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //SharedPreferences.Editor ed = sp.edit();


    }

    public void onbtnadd(View v) {
        //sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("txtid" + txtid.getText().toString(), txtid.getText().toString());
        ed.putString("txtname" + txtid.getText().toString(), txtname.getText().toString());
        ed.putString("txtsub" + txtid.getText().toString(), txtsub.getText().toString());
        ed.commit();
        Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();

    }

    public void onbtnread(View v) {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
        //Vibrator.vibrate(200);

        oldr = txtid.getText().toString();
        sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
        txtname.setText(sp.getString("txtname" + txtid.getText().toString(), "").toString());
        txtsub.setText(sp.getString("txtsub" + txtid.getText().toString(), "").toString());
    }

    public void onbtndelete(View v) {
        SharedPreferences.Editor ed=sp.edit();

        ed.remove("txtid" + txtid.getText().toString());
        ed.remove("txtname" + txtid.getText().toString());
        ed.remove("txtsub" + txtid.getText().toString());
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
        ed.commit();
        ed.apply();
    }


    public void onbtnupdate(View v) {
        SharedPreferences.Editor ed=sp.edit();

        newr = txtid.getText().toString();
        ed.remove("txtid" + oldr);
        ed.remove("txtname" + oldr);
        ed.remove("txtsub" + oldr);
        ed.putString("txtid" + txtid.getText().toString(), txtid.getText().toString());
        ed.putString("txtname" + txtid.getText().toString(), txtname.getText().toString());
        ed.putString("txtsub" + txtid.getText().toString(), txtsub.getText().toString());
        ed.commit();
        ed.apply();
        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();

    }
}
