package dsq.sycophant.layout.tabbar.button;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import dsq.sycophant.R;
import dsq.sycophant.layout.common.selector.button.DefaultSelectors;
import dsq.sycophant.layout.common.selector.button.Selectors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class DefaultActivityTabIcon extends LinearLayout implements ActivityTabIcon {
    private final ImageButton button;
    private final Context context;
    private final TabIcon delegate;

    public DefaultActivityTabIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        button = new ImageButton(context);
        this.delegate = new DefaultTabIcon(this, button, context, attrs);
        addView(button);
    }

    @Override
    public void setView(final Class<?> cls) {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!isSelected()) {
                    final Intent intent = new Intent(context, cls);
                    context.startActivity(intent);
                    if (context instanceof Activity) ((Activity)context).finish();
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
