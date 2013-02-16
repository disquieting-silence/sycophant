package dsq.sycophant.action;

public interface ItemAction<A> {
    void run(long id, A v);
}