import java.util.List;

/**
 * Created by shawn on 4/24/2017.
 */
public class InsertionSorter<E extends Comparable<E>> implements Sorter<E> {
    public InsertionSorter(){
    }
    public void sort(List<E> eList, Order order){
        int i, j;
        E newValue;
        for (i = 1; i < eList.size(); i++) {
            newValue = eList.get(i);
            j = i;
            while (j > 0 && compareToSort(eList.get(j - 1), newValue, order) > 0){
                eList.set(j, eList.get(j - 1));
                j--;
            }
            eList.set(j, newValue);
        }
    }

    private int compareToSort(E o1, E o2, Order order){
        switch(order){
            case ASCENDING:
                return o1.compareTo(o2);
            case DESCENDING:
                return o1.compareTo(o2) * -1;
            default: break;
        }
        return 0;
    }
}
