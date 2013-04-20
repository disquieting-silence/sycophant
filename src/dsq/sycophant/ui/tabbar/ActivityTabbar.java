package dsq.sycophant.ui.tabbar;

import android.app.Activity;
import dsq.sycophant.layout.tabbar.button.ActivityTabIcon;
import dsq.sycophant.layout.tabbar.button.TabIcon;

import java.util.HashMap;
import java.util.Map;

public class ActivityTabbar implements Tabbar {
    private final Activity activity;
    private final Map<Integer, Class<?>> actions;


    public ActivityTabbar(final Activity activity, final Map<Integer, Class<?>> actions) {
        this.activity = activity;
        this.actions = new HashMap<Integer, Class<?>>(actions);
    }

    public void register() {
        for (Integer viewId : actions.keySet()) {
            final Class<?> cls = actions.get(viewId);
            final ActivityTabIcon icon = get(viewId);
            icon.setView(cls);
        }
    }

    @Override
    public void select(final int actionId) {
        for (Integer id : actions.keySet()) {
            final TabIcon tabIcon = get(id);
            tabIcon.setSelected(false);
        }
        final TabIcon selected = get(actionId);
        selected.setSelected(true);
    }

    @Override
    public void trigger(final int actionId) {
        // Maybe implement later.
    }

    public ActivityTabIcon get(final int actionId) {
        return (ActivityTabIcon)activity.findViewById(actionId);
    }
}
