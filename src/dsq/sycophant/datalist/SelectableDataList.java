package dsq.sycophant.datalist;

import dsq.sycophant.action.ItemAction;

public interface SelectableDataList<A> {
    long selected();
    void refresh();
    void onSelect(ItemAction<A> action);
}