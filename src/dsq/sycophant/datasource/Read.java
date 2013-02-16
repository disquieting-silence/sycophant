package dsq.sycophant.datasource;

public interface Read<A> {
    A read(long id);
}
