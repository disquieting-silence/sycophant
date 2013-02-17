package dsq.sycophant.ui.dialog;

import android.app.Activity;
import android.content.Intent;
import dsq.sycophant.action.IdAction;

public class TextDialogIdAction implements IdAction {
    public final Activity activity;
    public final String idTag;
    public final int dialogId;

    public TextDialogIdAction(final Activity activity, final String idTag, final int dialogId) {
        this.activity = activity;
        this.idTag = idTag;
        this.dialogId = dialogId;
    }

    @Override
    public void run(final long id) {
        Intent intent = new Intent();
        intent.putExtra(idTag, id);
        activity.setIntent(intent);
        displayDialog(dialogId);
    }

    private void displayDialog(final int dialogId) {
        activity.removeDialog(dialogId);
        activity.showDialog(dialogId);
    }
}
