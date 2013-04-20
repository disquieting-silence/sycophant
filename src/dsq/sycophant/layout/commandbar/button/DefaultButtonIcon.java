package dsq.sycophant.layout.commandbar.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import dsq.sycophant.R;
import dsq.sycophant.action.SimpleAction;
import dsq.sycophant.layout.common.selector.button.DefaultSelectors;
import dsq.sycophant.layout.common.selector.button.Selectors;
import dsq.sycophant.ui.button.ButtonImages;
import dsq.sycophant.ui.button.DefaultButtonImages;

public class DefaultButtonIcon extends LinearLayout implements ButtonIcon {
    private final ImageButton button;

    private boolean enabled = true;
    private final Context context;

    private ButtonImages images;

    public DefaultButtonIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.IconLayout);
        final String iconBase = attributes.getString(R.styleable.IconLayout_icon);

        button = new ImageButton(context);

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);

        addView(button);
        images = new DefaultButtonImages(iconBase);
        setupSelector();
    }

    private void setupSelector() {
        final Selectors selectors = new DefaultSelectors(context, this);
        button.setImageDrawable(enabled ? selectors.enabled(images) : selectors.disabled(images));
        button.setBackgroundDrawable(selectors.drawable("transparent"));
    }

    /* FIX: Really wish this was an interface .... Dupe from listless. */
    public void setAction(final SimpleAction action) {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                if (enabled) action.run();
            }
        });
    }

    public void setActionEnabled(final boolean enabled) {
        this.enabled = enabled;
        setupSelector();
    }

    public void setImages(final ButtonImages images) {
        this.images = images;
        setupSelector();
    }
}
