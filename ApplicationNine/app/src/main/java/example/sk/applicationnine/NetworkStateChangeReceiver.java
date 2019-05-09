package example.sk.applicationnine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkStateChangeReceiver extends BroadcastReceiver
{
    TextView txtwifi,txtmob;
    public NetworkStateChangeReceiver(TextView t1,TextView t2)
    {
        txtwifi=t1;
        txtmob=t2;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String status=getStatus(context);
        //Toast.makeText(context,status,Toast.LENGTH_SHORT).show();
    }
    public String getStatus(Context context)
    {

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
            {
                txtwifi.setText("Wifi Status : Connected");
                txtmob.setText("Mobile Data Status : Disconnected");
                return "Wifi Connected";
            }
            else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                txtwifi.setText("Wifi Status : Disconnected");
                txtmob.setText("Mobile Data Status : Connected");
                return "Mobile Data Connected";
            }
        }
        txtwifi.setText("Wifi Status : Disonnected");
        txtmob.setText("Mobile Data Status : Disconnected");
        return "Not Connected";
    }
}
