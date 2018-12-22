package rezwan.pstu.cse12.youtubeonlinestatus;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import rezwan.pstu.cse12.youtubeonlinestatus.recievers.NetworkChangeReceiver;

@SuppressLint("ResourceAsColor")
public class RealtimeOnlineStatus {
        //extends BroadcastReceiver{
    /*
    private BroadcastReceiver mNetworkReceiver;
    private final Context context;


    public RealtimeOnlineStatus(Context context) {
        this.context = context;
        mNetworkReceiver = new NetworkChangeReceiver();
    }


    public static void dialog(boolean value, Context context){

        if(value){
            Toasty.custom(context, "Back to online" , R.drawable.ic_face , R.color.md_green_A400, Toast.LENGTH_SHORT, true, true).show();


            tv_check_connection.setText("We are back !!!");
            tv_check_connection.setBackgroundColor(Color.GREEN);
            tv_check_connection.setTextColor(Color.WHITE);

            Handler handler = new Handler();
            Runnable delayrunnable = new Runnable() {
                @Override
                public void run() {
                    tv_check_connection.setVisibility(View.GONE);
                }
            };
            handler.postDelayed(delayrunnable, 3000);


        }else {
            Toasty.custom(context, "No network connection" , R.drawable.ic_error_outline_white_48dp , R.color.md_red_A400, Toast.LENGTH_SHORT, true, true).show();

        }
    }


    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try
        {
            if (isOnline(context)) {
                dialog(true, context);
                Log.e("rezwan", "Online Connect Intenet ");
            } else {
                dialog(false, context);
                Log.e("rezwan", "Conectivity Failure !!! ");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    */
}
