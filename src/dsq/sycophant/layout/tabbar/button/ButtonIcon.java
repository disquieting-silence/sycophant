package dsq.sycophant.layout.tabbar.button;

public interface ButtonIcon {
    void setView(final Class<?> cls);
    void setEnabled(boolean enabled);
    void setSelected(boolean selected);
}
