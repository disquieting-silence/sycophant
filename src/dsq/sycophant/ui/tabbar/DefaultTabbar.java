package dsq.sycophant.ui.tabbar;

import android.app.Activity;
import dsq.sycophant.layout.tabbar.button.ButtonIcon;

import java.util.HashMap;
import java.util.Map;

public class DefaultTabbar implements Tabbar {
    private final Activity activity;
    private final Map<Integer, Class<?>> actions;


    public DefaultTabbar(final Activity activity, final Map<Integer, Class<?>> actions) {
        this.activity = activity;
        this.actions = new HashMap<Integer, Class<?>>(actions);
    }

    public void register() {
        for (Integer viewId : actions.keySet()) {
            final Class<?> cls = actions.get(viewId);
            final ButtonIcon icon = get(viewId);
            icon.setView(cls);
        }
    }

    @Override
    public void select(final int actionId) {
        for (Integer id : actions.keySet()) {
            final ButtonIcon buttonIcon = get(id);
            buttonIcon.setSelected(false);
        }
        final ButtonIcon selected = get(actionId);
        selected.setSelected(true);
    }

    public ButtonIcon get(final int actionId) {
        return (ButtonIcon)activity.findViewById(actionId);
    }
}
