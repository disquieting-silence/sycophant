package dsq.sycophant.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import dsq.sycophant.action.SingleAction;
import dsq.sycophant.thedroid.DbCrudAdapter;
import dsq.thedroid.db.DbUtils;

public class DefaultDialogs implements Dialogs {

    private final TextDialog texts = new DefaultTextDialog();

    @Override
    public <A> Dialog create(final Activity activity, final DbCrudAdapter<A> adapter, final String title, final String field,
        final SingleAction<A> action) {
        return texts.dialog(activity, title, "", new DialogListener() {
            @Override
            public void onSuccess(final String value) {
                final ContentValues values = new ContentValues();
                values.put(field, value);
                final A a = adapter.create(values);
                action.run(a);
            }
        });
    }

    @Override
    public <A> Dialog update(final Activity activity, final DbCrudAdapter<A> adapter, final String title, final String tag, final String field, final SingleAction<A> action) {
        final Intent intent = activity.getIntent();
        final long itemId = intent.getLongExtra(tag, -1);
        intent.removeExtra(tag);

        final Cursor cursor = adapter.fetchById(itemId);
        if (cursor.moveToFirst()) {
            final String name = DbUtils.getColumn(cursor, field);
            return texts.dialog(activity, title, name, new DialogListener() {
                @Override
                public void onSuccess(final String value) {
                    final ContentValues values = new ContentValues();
                    values.put(field, value);
                    final A a = adapter.update(itemId, values);
                    action.run(a);
                }
            });
        } else {
            // Groan.
            return null;
        }
    }
}
