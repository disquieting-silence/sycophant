package dsq.sycophant.layout.common.selector.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.widget.LinearLayout;
import dsq.sycophant.ui.button.ButtonImages;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultSelectors implements Selectors {

    private final Context context;
    private final LinearLayout layout;

    public DefaultSelectors(final Context context, final LinearLayout layout) {
        this.context = context;
        this.layout = layout;
    }

    @Override
    public StateListDrawable enabled(final ButtonImages images) {
        final StateListDrawable states = new StateListDrawable();
        setSelectorState(states, images.pressed(), new int[]{android.R.attr.state_pressed});
        setSelectorState(states, images.normal(), new int[0]);
        return states;
    }

    @Override
    public StateListDrawable disabled(final ButtonImages images) {
        final StateListDrawable disabledStates = new StateListDrawable();
        setSelectorState(disabledStates, images.disabled(), new int[0]);
        return disabledStates;
    }

    @Override
    public StateListDrawable custom(final Map<String, List<Integer>> states) {
        final StateListDrawable r = new StateListDrawable();
        final Set<String> keys = states.keySet();
        for (String key : keys) {
            final List<Integer> raw = states.get(key);
            int[] list = new int[raw.size()];
            for (int i = 0; i < list.length; i++) {
                list[i] = raw.get(i);
            }
            setSelectorState(r, key, list);
        }
        return r;
    }

    @Override
    public Drawable transparent() {
        return getImage("transparent");
    }

    private void setSelectorState(final StateListDrawable states, final String imageName, final int[] stateSet) {
        final Drawable image = getImage(imageName);
        if (image != null) states.addState(stateSet, image);
    }

    private Drawable getImage(final String image) {
        final int pressedId = getResourceByName(image);
        Log.v("SYCOPHANT", image + " " + pressedId);
        return pressedId != 0 ? layout.getResources().getDrawable(pressedId) : null;
    }

    private int getResourceByName(final String image) {
        return context.getResources().getIdentifier(image, "drawable", context.getPackageName());
    }
}
