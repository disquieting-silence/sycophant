package dsq.sycophant.layout.tabbar.button;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import dsq.sycophant.action.SimpleAction;

public class DefaultClickTabIcon extends LinearLayout implements ClickTabIcon {
    private final ImageButton button;
    private final TabIcon delegate;

    public DefaultClickTabIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        button = new ImageButton(context);
        this.delegate = new DefaultTabIcon(this, button, context, attrs);
        addView(button);
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

    @Override
    public void setClick(final SimpleAction action) {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!isSelected()) {
                    action.run();
                }
            }
        });
    }
}
