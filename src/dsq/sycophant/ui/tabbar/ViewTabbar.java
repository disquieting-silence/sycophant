package dsq.sycophant.ui.tabbar;

import android.app.Activity;
import android.widget.FrameLayout;
import dsq.sycophant.layout.tabbar.button.TabIcon;
import dsq.sycophant.layout.tabbar.button.ViewTabIcon;
import dsq.thedroid.ui.ComponentIndex;

import java.util.HashMap;
import java.util.Map;

public class ViewTabbar implements Tabbar {
    private final Activity activity;
    private final Map<Integer, ComponentIndex> tabs;
    private final FrameLayout parent;

    public ViewTabbar(final Activity activity, final ComponentIndex frameIndex, final Map<Integer, ComponentIndex> actions) {
        this.activity = activity;
        this.tabs = new HashMap<Integer, ComponentIndex>(actions);

        this.parent = (FrameLayout)activity.findViewById(frameIndex.value);
    }

    public void register() {
        for (Integer buttonId : tabs.keySet()) {
            final ComponentIndex index = tabs.get(buttonId);
            final ViewTabIcon icon = get(buttonId);
            icon.setView(parent, activity.findViewById(index.value));
        }
    }

    @Override
    public void select(final int actionId) {
        for (Integer id : tabs.keySet()) {
            final TabIcon tabIcon = get(id);
            tabIcon.setSelected(false);
        }
        final TabIcon selected = get(actionId);
        selected.setSelected(true);

        trigger(actionId);
    }

    private void trigger(final int actionId) {
        final ComponentIndex index = tabs.get(actionId);
        parent.bringChildToFront(activity.findViewById(index.value));
    }

    public ViewTabIcon get(final int actionId) {
        return (ViewTabIcon)activity.findViewById(actionId);
    }
}
