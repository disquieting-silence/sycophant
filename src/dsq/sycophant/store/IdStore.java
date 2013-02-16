package dsq.sycophant.store;

public interface IdStore {
    long get();
    void set(long id);
    boolean isSet();
}
