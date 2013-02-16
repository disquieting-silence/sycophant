package dsq.sycophant.action;

public class NoopItemAction<A> implements ItemAction<A> {
    @Override
    public void run(final long id, final A v) {
    }
}
