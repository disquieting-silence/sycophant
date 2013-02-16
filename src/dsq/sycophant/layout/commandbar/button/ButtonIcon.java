package dsq.sycophant.layout.commandbar.button;

import dsq.sycophant.action.SimpleAction;
import dsq.sycophant.ui.button.ButtonImages;

public interface ButtonIcon {
    void setAction(SimpleAction action);
    void setActionEnabled(boolean enabled);
    void setImages(ButtonImages images);
}