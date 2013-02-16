package dsq.sycophant.datasource;

import android.content.ContentValues;

public interface Write {
    void write(long id, ContentValues values);
}
