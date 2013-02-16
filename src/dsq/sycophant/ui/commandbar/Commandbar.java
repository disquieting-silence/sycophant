package dsq.sycophant.ui.commandbar;

import dsq.sycophant.layout.commandbar.button.ButtonIcon;

public interface Commandbar {
    void trigger(int actionId);
    void update();
    void register();

    ButtonIcon get(int actionId);
}
