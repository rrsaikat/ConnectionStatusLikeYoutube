package rezwan.pstu.cse12.youtubeonlinestatus.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import rezwan.pstu.cse12.youtubeonlinestatus.Util.NetworkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private final Context context;
    public NetworkChangeReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            String status = NetworkUtil.getConnectivityStatusString(context);

            Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}