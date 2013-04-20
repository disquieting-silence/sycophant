package dsq.sycophant.layout.tabbar.button;

import dsq.sycophant.action.SimpleAction;

public interface ClickTabIcon extends TabIcon {
    void setClick(final SimpleAction action);
}
