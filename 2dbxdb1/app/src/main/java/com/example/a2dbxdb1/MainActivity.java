package com.example.a2dbxdb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Button btnviewall,btnadd,btndelete,btnread,btnupdate;
    EditText txtid,txtname,txtsub;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtid=(EditText)findViewById(R.id.txtid);
        txtname=(EditText)findViewById(R.id.txtname);
        txtsub=(EditText)findViewById(R.id.txtsub);
        db=openOrCreateDatabase("studentdb", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists studenttbl(eid varchar(20),ename varchar(20),esub varchar(20))");
    }

    public  void onbtnread(View v)
    {
        validate();
        Cursor c=db.rawQuery("select * from studenttbl where eid='"+txtid.getText().toString()+"'",null);
        if(c.moveToFirst())
        {
            txtname.setText(c.getString(1));
            txtsub.setText(c.getString(2));
        }
        else
        {
            Toast.makeText(this,"no such record exists",Toast.LENGTH_LONG).show();
        }
    }

    private void validate()
    {
        if(txtid.getText().toString().equals(""))
        {
            Toast.makeText(this,"field empty",Toast.LENGTH_LONG).show();
        }
    }


    public  void onbtnadd(View v)
    {
        db.execSQL("insert into studenttbl values('"+txtid.getText().toString()+"','"+txtname.getText().toString()+"','"+txtsub.getText().toString() + "');");
        Toast.makeText(this,"Student added",Toast.LENGTH_LONG).show();

    }

    public  void  onbtndelete(View v)
    {
        db.execSQL("delete from studenttbl where eid='"+txtid.getText().toString()+"'");
        Toast.makeText(this,"deleted",Toast.LENGTH_LONG).show();
    }

    public  void  onbtnupdate(View v)
    {
        Cursor c=db.rawQuery("select * from studenttbl where eid='"+txtid.getText().toString()+"'",null);
        if(c.moveToFirst())
        {
            db.execSQL("update studenttbl set ename='"+txtname.getText()+"',esub='"+txtsub.getText()+"'where eid='"+txtid.getText()+"'");
            Toast.makeText(this,"updated",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"not exist",Toast.LENGTH_LONG).show();
        }
    }

    public  void  onbtnviewall(View v)
    {
        Cursor c=db.rawQuery("select * from studenttbl",null);
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append(c.getString(0)+"\n");
            buffer.append(c.getString(1)+"\n");
            buffer.append(c.getString(2)+"\n\n");



        }
        AlertDialog.Builder builder=new  AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("student details");
        builder.setMessage(buffer.toString());
        builder.show();
    }
}
