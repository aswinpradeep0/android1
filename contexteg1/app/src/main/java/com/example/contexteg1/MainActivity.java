package com.example.contexteg1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(TextView)findViewById(R.id.txt1);
        registerForContextMenu(txt1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select");
        menu.add("call");
        menu.add("SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //
        if(item.getTitle().toString().equals("call"))
        {
            Toast.makeText(this,"call selected",Toast.LENGTH_LONG).show();
        }
        if(item.getTitle().toString().equals("SMS"))
        {
            Toast.makeText(this,"sms selected",Toast.LENGTH_LONG).show();
        }return super.onContextItemSelected(item);
    }
}
