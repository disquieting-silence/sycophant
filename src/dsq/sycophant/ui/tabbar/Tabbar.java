package dsq.sycophant.ui.tabbar;

import dsq.sycophant.layout.tabbar.button.TabIcon;

public interface Tabbar {
    void register();
    void select(int actionId);

    TabIcon get(int actionId);
}
