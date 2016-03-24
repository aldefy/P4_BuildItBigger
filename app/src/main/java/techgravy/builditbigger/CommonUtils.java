package techgravy.builditbigger;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.victor.loading.rotate.RotateLoading;

/**
 * Created by aditlal on 24/03/16.
 */
public class CommonUtils {

    private static Dialog mProgressDialog;

    public static void displayProgressDialog(Context context, String message) {
        dismissProgressDialog();
        View loadingView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        mProgressDialog = new Dialog(context);
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.getWindow().setDimAmount(0.8f);
        mProgressDialog.setCancelable(false);
        if (message != null && message.trim().length() > 0) {
            ((TextView) loadingView.findViewById(R.id.messageTextView)).setText(message);
        }
        mProgressDialog.setContentView(loadingView);
        mProgressDialog.show();
        ((RotateLoading) loadingView.findViewById(R.id.loading)).start();
    }

    public static void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }


}

