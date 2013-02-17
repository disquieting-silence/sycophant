package dsq.sycophant.ui.dialog;

import android.app.Activity;
import dsq.sycophant.action.SimpleAction;

public class TextDialogSimpleAction implements SimpleAction {

    public final Activity activity;
    public final int dialogId;

    public TextDialogSimpleAction(final Activity activity, final int dialogId) {
        this.activity = activity;
        this.dialogId = dialogId;
    }

    @Override
    public void run() {
        activity.removeDialog(dialogId);
        activity.showDialog(dialogId);
    }
}
