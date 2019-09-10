import java.util.List;

/**
 * Created by shawn on 4/24/2017.
 */
public interface Sorter<E> {

    enum Order {
        ASCENDING, DESCENDING
    }

    void sort(List<E> eList, Order order);
}
