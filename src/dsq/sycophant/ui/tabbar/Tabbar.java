package dsq.sycophant.ui.tabbar;

import dsq.sycophant.layout.tabbar.button.ButtonIcon;

public interface Tabbar {
    void register();
    void select(int actionId);

    ButtonIcon get(int actionId);
}
