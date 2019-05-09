package example.sk.applicationsix;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etRoll,etName,etCourse;
    SharedPreferences sp;
    String oldr,newr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etRoll=(EditText)findViewById(R.id.etRollNo);
        etName=(EditText)findViewById(R.id.etName);
        etCourse=(EditText)findViewById(R.id.etCourse);
    }
    public void onAddBtnClicked(View v)
    {
        sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        if(etRoll.getText().toString().equals("")||etCourse.getText().toString().equals("")||etName.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else if(!sp.getString("roll" + etRoll.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
        }
        else {
            ed.putString("roll" + etRoll.getText().toString(), etRoll.getText().toString());
            ed.putString("name" + etRoll.getText().toString(), etName.getText().toString());
            ed.putString("course" + etRoll.getText().toString(), etCourse.getText().toString());
            ed.commit();
            Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
            etRoll.setText("");
            etName.setText("");
            etCourse.setText("");
        }
    }
    public void onReadBtnClicked(View v)
    {
        if(etRoll.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Roll Number",Toast.LENGTH_SHORT).show();
            etRoll.setText("");
            etName.setText("");
            etCourse.setText("");
        }
        else {
            oldr=etRoll.getText().toString();
            sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
            if(sp.getString("name" + etRoll.getText().toString(), "").toString().equals(""))
            {
                Toast.makeText(getApplicationContext(),"No Student",Toast.LENGTH_SHORT).show();
            }
            else {
                etName.setText(sp.getString("name" + etRoll.getText().toString(), "").toString());
                etCourse.setText(sp.getString("course" + etRoll.getText().toString(), "").toString());
            }
        }
    }
    public void onUpdateBtnClicked(View v)
    {
        newr=etRoll.getText().toString();
        sp=getSharedPreferences("SD",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        if(etRoll.getText().toString().equals("")||etCourse.getText().toString().equals("")||etName.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else if(!oldr.equals(newr) && !sp.getString("roll" + etRoll.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Already Exists",Toast.LENGTH_SHORT).show();
        }
        else {
            ed.remove("roll" + oldr);
            ed.remove("name" + oldr);
            ed.remove("course" + oldr);
            ed.putString("roll" + etRoll.getText().toString(), etRoll.getText().toString());
            ed.putString("name" + etRoll.getText().toString(), etName.getText().toString());
            ed.putString("course" + etRoll.getText().toString(), etCourse.getText().toString());
            ed.commit();
            ed.apply();
            Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
            etRoll.setText("");
            etName.setText("");
            etCourse.setText("");
        }
    }
    public void onDeleteBtnClicked(View v)
    {
        if(etRoll.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Roll Number",Toast.LENGTH_SHORT).show();
        }
        else if(sp.getString("roll" + etRoll.getText().toString(), "").toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Student Not Found",Toast.LENGTH_SHORT).show();
        }
        else {
            sp = getSharedPreferences("SD", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.remove("roll" + etRoll.getText().toString());
            ed.remove("name" + etRoll.getText().toString());
            ed.remove("course" + etRoll.getText().toString());
            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
            ed.commit();
            ed.apply();
            etRoll.setText("");
            etName.setText("");
            etCourse.setText("");
        }
    }
}
