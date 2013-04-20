package dsq.sycophant.layout.tabbar.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultViewTabIcon extends LinearLayout implements ViewTabIcon {
    private final ImageButton button;
    private final TabIcon delegate;

    private final Map<String, List<Integer>> images = new HashMap<String, List<Integer>>();

    public DefaultViewTabIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        button = new ImageButton(context);
        this.delegate = new DefaultTabIcon(this, button, context, attrs);
        addView(button);
    }

    @Override
    public void setView(final FrameLayout parent, final View child) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!isSelected()) {
                    parent.bringChildToFront(child);
                }
            }
        });
    }

    @Override
    public void setEnabled(final boolean enabled) {
        delegate.setEnabled(enabled);
    }

    @Override
    public void setSelected(final boolean selected) {
        delegate.setSelected(selected);
    }

    @Override
    public boolean isSelected() {
        return delegate.isSelected();
    }
}
