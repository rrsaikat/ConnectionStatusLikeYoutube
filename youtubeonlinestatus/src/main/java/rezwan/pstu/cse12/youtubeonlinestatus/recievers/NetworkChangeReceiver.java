package rezwan.pstu.cse12.youtubeonlinestatus.recievers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import de.mateware.snacky.Snacky;

public class NetworkChangeReceiver extends Activity{

    public BroadcastReceiver br;
    Context context;

    public NetworkChangeReceiver(Context context) {
        this.context = context;
    }


    public void checkConnection(){
        if (br == null){
            br = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Bundle extras = intent.getExtras();
                    NetworkInfo info = (NetworkInfo) extras.getParcelable("networkInfo");

                   NetworkInfo.State state = info.getState();
                    Log.d("Test Internet", info.toString()+" " +state.toString());

                    if (state == NetworkInfo.State.CONNECTED){
                        //Toast.makeText(context, "Back to online", Toast.LENGTH_SHORT).show();
                        Snacky.builder()
                                .setActivity((Activity) context)
                                .setBackgroundColor(Color.parseColor("#43a047"))
                                .setText("Back online")
                                .setTextColor(Color.parseColor("#ffffff"))
                                .setTextSize(12)
                                .setTextTypefaceStyle(Typeface.BOLD)
                                .setMaxLines(1)
                                .centerText()
                                .setDuration(Snacky.LENGTH_SHORT)
                                .build()
                                .show();

                    }else {
                        //Toast.makeText(context, "No connection", Toast.LENGTH_LONG).show();
                        Snacky.builder()
                                .setActivity((Activity) context)
                                .setBackgroundColor(Color.parseColor("#455a64"))
                                .setText("No connection")
                                .setTextColor(Color.parseColor("#ffffff"))
                                .setTextSize(12)
                                .setTextTypefaceStyle(Typeface.BOLD)
                                .setMaxLines(1)
                                .centerText()
                                .setDuration(Snacky.LENGTH_INDEFINITE)
                                .build()
                                .show();
                    }

                }
            };
/*
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReciever((BroadcastReceiver) br, intentFilter);

*/
            registerNetworkBroadcastForNougat(context);
        }

    }



    private void registerNetworkBroadcastForNougat(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.registerReceiver(br, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.registerReceiver(br, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            context.registerReceiver(br, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkChanges(Context context) {
        try {
            context.unregisterReceiver(br);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges(context);
    }
}