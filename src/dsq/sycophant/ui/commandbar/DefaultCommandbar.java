package dsq.sycophant.ui.commandbar;

import android.app.Activity;
import dsq.sycophant.action.IdAction;
import dsq.sycophant.action.SimpleAction;
import dsq.sycophant.layout.commandbar.button.ButtonIcon;
import dsq.sycophant.store.IdStore;

import java.util.HashMap;
import java.util.Map;

public class DefaultCommandbar implements Commandbar {
    private final Activity activity;
    private final Map<Integer, IdAction> actions;
    private final IdStore id;

    public DefaultCommandbar(final Activity activity, final Map<Integer, IdAction> actions, final IdStore id) {
        this.activity = activity;
        this.actions = new HashMap<Integer, IdAction>(actions);
        this.id = id;
    }

    public void trigger(final int actionId) {
        // not implemented yet.
    }

    public void update() {
        // basic disable anything with no id
        for (Integer viewId : actions.keySet()) {
            final ButtonIcon icon = (ButtonIcon)activity.findViewById(viewId);
            icon.setActionEnabled(id.isSet());
        }
    }

    public void register() {
        for (Integer viewId : actions.keySet()) {
            final IdAction action = actions.get(viewId);
            final ButtonIcon icon = (ButtonIcon)activity.findViewById(viewId);
            icon.setAction(new SimpleAction() {
                public void run() {
                    if (id.isSet()) {
                        final long currentId = id.get();
                        action.run(currentId);
                    }
                }
            });
        }
    }

    public ButtonIcon get(final int actionId) {
        return (ButtonIcon)activity.findViewById(actionId);
    }
}
