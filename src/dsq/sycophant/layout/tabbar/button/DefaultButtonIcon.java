package dsq.sycophant.layout.tabbar.button;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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

public class DefaultButtonIcon extends LinearLayout implements ButtonIcon {

    private boolean enabled = true;
    private boolean selected = false;

    private final ImageButton button;
    private final Context context;

    private final Map<String, List<Integer>> images = new HashMap<String, List<Integer>>();

    public DefaultButtonIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.IconLayout);
        final String iconBase = attributes.getString(R.styleable.IconLayout_icon);

        button = new ImageButton(context);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        button.setLayoutParams(params);

        addView(button);
        images.put(iconBase, Arrays.asList(android.R.attr.state_pressed));
        images.put(iconBase, Arrays.asList(0));
        setupSelector();
    }

    private void setupSelector() {
        final Selectors selectors = new DefaultSelectors(context, this);
        final StateListDrawable states = selectors.custom(images);
        button.setImageDrawable(states);
        button.setBackgroundDrawable(selectors.transparent());
    }

    @Override
    public void setView(final Class<?> cls) {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!selected) {
                    final Intent intent = new Intent(context, cls);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
