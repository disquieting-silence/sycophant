package dsq.sycophant.ui.tabbar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import dsq.sycophant.action.IdAction;
import dsq.sycophant.action.SimpleAction;
import dsq.sycophant.layout.tabbar.button.TabIcon;
import dsq.sycophant.layout.tabbar.button.ClickTabIcon;
import dsq.thedroid.ui.ComponentIndex;

import java.util.HashMap;
import java.util.Map;

public class ViewTabbar implements Tabbar {
    private final Activity activity;
    private final Map<Integer, ComponentIndex> tabs;
    private final FrameLayout parent;
    private IdAction listener;

    public ViewTabbar(final Activity activity, final ComponentIndex frameIndex, final Map<Integer, ComponentIndex> actions) {
        this.activity = activity;
        this.tabs = new HashMap<Integer, ComponentIndex>(actions);

        this.parent = (FrameLayout)activity.findViewById(frameIndex.value);
    }

    public void register() {
        for (Integer buttonId : tabs.keySet()) {
            final ComponentIndex index = tabs.get(buttonId);
            final ClickTabIcon icon = get(buttonId);
            final View view = activity.findViewById(index.value);
            final SimpleAction action = viewAction(buttonId, view);
            icon.setClick(action);
        }
    }

    private SimpleAction viewAction(final Integer index, final View view) {
        return new SimpleAction() {
            @Override
            public void run() {
                for (Integer buttonId : tabs.keySet()) {
                    final ClickTabIcon button = get(buttonId);
                    button.setSelected(false);
                }

                final ClickTabIcon clicked = get(index);
                clicked.setSelected(true);
                trigger(index);
            }
        };
    }

    @Override
    public void select(final int actionId) {
        for (Integer id : tabs.keySet()) {
            final TabIcon tabIcon = get(id);
            tabIcon.setSelected(false);
        }
        final TabIcon selected = get(actionId);
        selected.setSelected(true);
    }

    @Override
    public void trigger(final int actionId) {
        final ComponentIndex index = tabs.get(actionId);
        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            child.setVisibility(View.GONE);
        }

        final View view = activity.findViewById(index.value);
        view.setVisibility(View.VISIBLE);
        if (listener != null) listener.run(actionId);
    }

    public ClickTabIcon get(final int actionId) {
        return (ClickTabIcon)activity.findViewById(actionId);
    }

    @Override
    public void setOnChange(final IdAction action) {
        listener = action;
    }
}
