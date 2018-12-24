package rezwan.pstu.cse12.youtubeonlinestatus.recievers.CustomSnackBar;

import com.google.android.material.snackbar.Snackbar;

public enum Duration {
    SHORT, LONG, CUSTOM, INFINITE;

    public static int getDuration(Duration duration){
        switch (duration){
            case SHORT:
                return Snackbar.LENGTH_SHORT;
            case LONG:
                return Snackbar.LENGTH_LONG;
            case INFINITE:
                return Snackbar.LENGTH_INDEFINITE;
        }

        return Snackbar.LENGTH_SHORT;
    }
}
