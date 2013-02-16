package dsq.sycophant.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import dsq.sycophant.action.SingleAction;
import dsq.sycophant.thedroid.DbCrudAdapter;

public interface Dialogs {
    <A> Dialog create(final Activity activity, final DbCrudAdapter<A> adapter, final String title, final String field,
                  final SingleAction<A> action);
    <A> Dialog update(final Activity activity, final DbCrudAdapter<A> adapter, final String title, final String tag,
                  final String field, final SingleAction<A> action);
}
