package rezwan.pstu.cse12.youtubeonlinestatus.recievers.CustomSnackBar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;

public class SnackBar {
    // snackbar main contex
    private static Context snackContext;
    private static com.google.android.material.snackbar.Snackbar snackbar;
    private static SnackBar singleton;

    //variables
    private static int colorCode = Type.getColorCode(Type.SUCCESS);
    private static String snackMessage = "Welcome !";
    private static int snackDuration = Duration.getDuration(Duration.SHORT);
    private static View view;

    private static boolean isCustomView;
    private static boolean isFillParent;
    private static Align textAlign;

    public static SnackBar with(Context context, View fab){
        snackContext = context.getApplicationContext();
        if (singleton == null)
            singleton = new SnackBar();

        if (fab == null) {
            View rootView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
            view = rootView;
            snackbar = com.google.android.material.snackbar.Snackbar
                    .make(view, "", snackDuration);
        }else {
            isCustomView = false;
            isFillParent = false;
            textAlign = Align.LEFT;
        }
        return singleton;
    }

    public static SnackBar type(Type type){
        colorCode = Type.getColorCode(type);
        return singleton;
    }

    public static SnackBar type(Type type, int color) {
        if (type == Type.CUSTOM)
            colorCode = color;
        else
            colorCode = Type.getColorCode(type);
        return singleton;
    }

    public static SnackBar message(CharSequence displayMessage){
      snackMessage = displayMessage.toString();
      return singleton;
    }

    public static SnackBar duration(Duration duration){
        if (duration != Duration.CUSTOM){
            snackDuration = Duration.getDuration(duration);
        }
        return singleton;
    }

    public static SnackBar duration(Duration durationtype , int duration){
        if (durationtype == Duration.CUSTOM){
            snackDuration = duration;
        }
        return singleton;
    }

    public static SnackBar contentView(final View view, int heightInDP){
        isCustomView = true;
        final Snackbar.SnackbarLayout snackLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        Snackbar.SnackbarLayout.LayoutParams params = (Snackbar.SnackbarLayout.LayoutParams) snackLayout.getLayoutParams();

        params.height = (int) pxFromDp(heightInDP);
        //TextView textView = (TextView) snackLayout.findViewById(android.support.design.R.id.snackbar_text);
        //textView.setVisibility(View.INVISIBLE);

        snackLayout.addView(view, 0, params);
        return singleton;
    }

    public static SnackBar fillParent(boolean fillParent) {
        isFillParent = fillParent;
        return singleton;
    }

    public static SnackBar textAlign(Align align) {
        textAlign = align;
        return singleton;
    }

    private static View getSnackBarLayout() {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;
    }

    private static SnackBar setColor(int colorId) {
        View snackBarView = getSnackBarLayout();
        if (snackBarView != null) {
            snackBarView.setBackgroundColor(colorId);
        }

        return singleton;
    }
/*
    private static void setTextAlignment(com.google.android.material.snackbar.Snackbar snackbar) {
        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) textView.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        textView.setLayoutParams(params);

        switch (textAlign) {
            case CENTER:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                else
                    textView.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
            case RIGHT:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                else
                    textView.setGravity(Gravity.RIGHT);
                break;
            case LEFT:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                else
                    textView.setGravity(Gravity.LEFT);
                break;
            default:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                else
                    textView.setGravity(Gravity.LEFT);
                break;
        }
    }
*/
    public static void show() {
        if (isCustomView) {
            snackbar.setDuration(snackDuration);
            snackbar.show();
        } else {
            snackbar = com.google.android.material.snackbar.Snackbar
                    .make(view, snackMessage, snackDuration)
                    .setDuration(snackDuration);

            if (isFillParent)
                snackbar.getView().getLayoutParams().width = AppBarLayout.LayoutParams.MATCH_PARENT;

            //setTextAlignment(snackbar);

            setColor(colorCode);

            View snackbarView = snackbar.getView();
            //TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            //textView.setMaxLines(10);
        }
        snackbar.show();
    }

    private static float pxFromDp(int dp) {
        return dp * snackContext.getResources().getDisplayMetrics().density;
    }

    public static void dismiss() {
        if (snackbar != null) {
            if (snackbar.isShown()) {
                snackbar.dismiss();
            }
        }
    }
}
