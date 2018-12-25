package rezwan.pstu.cse12.youtubeonlinesatuslibrary;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import rezwan.pstu.cse12.youtubeonlinestatus.recievers.NetworkChangeReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // NetworkChangeReceiver r = new NetworkChangeReceiver(this);
       // r.checkConnection();
    }
}
