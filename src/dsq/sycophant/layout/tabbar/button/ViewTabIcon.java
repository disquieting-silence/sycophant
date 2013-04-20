package dsq.sycophant.layout.tabbar.button;

import android.view.View;
import android.widget.FrameLayout;

public interface ViewTabIcon extends TabIcon {
    void setView(final FrameLayout parent, final View child);
}
