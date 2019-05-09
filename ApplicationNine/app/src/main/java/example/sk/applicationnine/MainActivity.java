package example.sk.applicationnine;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    NetworkStateChangeReceiver n;
    IntentFilter i;
    TextView txtWifi,txtMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWifi=(TextView)findViewById(R.id.txtWifi);
        txtMobile=(TextView)findViewById(R.id.txtMobile);
    }
    public void onRegister(View v)
    {
        n=new NetworkStateChangeReceiver(txtWifi,txtMobile);
        i=new IntentFilter();
        i.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        i.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(n,i);
        Toast.makeText(getApplicationContext(),"BroadCast Receiver Registered",Toast.LENGTH_SHORT).show();
    }
    public void unRegister(View v)
    {
        unregisterReceiver(n);
        Toast.makeText(getApplicationContext(),"BroadCast Receiver UnRegistered",Toast.LENGTH_SHORT).show();
        txtWifi.setText("");
        txtMobile.setText("");
    }
}
