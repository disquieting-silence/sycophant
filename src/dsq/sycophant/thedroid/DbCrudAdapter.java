package dsq.sycophant.thedroid;

import android.content.ContentValues;
import dsq.thedroid.db.DbAdapter;

// Not sure about this.
public interface DbCrudAdapter<A> extends DbAdapter {
    A create(ContentValues values);
    A update(long id, ContentValues values);
}
