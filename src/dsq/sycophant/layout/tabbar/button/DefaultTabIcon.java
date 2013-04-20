package dsq.sycophant.layout.tabbar.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
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

public class DefaultTabIcon implements TabIcon {
    private boolean enabled = true;
    private boolean selected = false;

    private final ImageButton button;
    private final Context context;
    private final LinearLayout parent;

    private final Map<String, List<Integer>> images = new HashMap<String, List<Integer>>();

    public DefaultTabIcon(final LinearLayout parent, final ImageButton button, Context context, AttributeSet attrs) {
        this.parent = parent;
        this.button = button;
        this.context = context;

        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.IconLayout);
        final String iconBase = attributes.getString(R.styleable.IconLayout_icon);

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        button.setLayoutParams(params);

        images.put(iconBase, Arrays.asList(android.R.attr.state_pressed));
        images.put(iconBase, Arrays.asList(0));
        setupSelector();
    }

    private void setupSelector() {
        final Selectors selectors = new DefaultSelectors(context, parent);
        final StateListDrawable states = selectors.custom(images);
        button.setImageDrawable(states);
        final String drawable = selected ? "highlighted_tab" : "transparent";
        button.setBackgroundDrawable(selectors.drawable(drawable));
    }

    @Override
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
        setupSelector();
    }

    @Override
    public void setSelected(final boolean selected) {
        this.selected = selected;
        setupSelector();
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }
}
