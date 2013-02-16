package dsq.sycophant.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;

public interface TextDialog {
    AlertDialog dialog(final Activity activity, final String message, String initial, final DialogListener listener);
}
