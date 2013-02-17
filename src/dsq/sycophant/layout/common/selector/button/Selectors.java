package dsq.sycophant.layout.common.selector.button;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import dsq.sycophant.ui.button.ButtonImages;

import java.util.List;
import java.util.Map;

public interface Selectors {
    StateListDrawable enabled(ButtonImages images);
    StateListDrawable disabled(ButtonImages images);
    StateListDrawable custom(Map<String, List<Integer>> states);
    Drawable drawable(String name);
}
