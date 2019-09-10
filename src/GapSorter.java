import java.util.List;

/**
 * Created by shawn on 4/24/2017.
 */
public class GapSorter<E extends Comparable<E>> implements Sorter<E>{
    public GapSorter(){
    }
    InsertionSorter lol = new InsertionSorter();
    public void sort(List<E> eList, Order order){
        int gap = (int)Math.floor(eList.size()/2);
        while (gap > 0){
            if (gap == 1){
                lol.sort(eList, order);
            }
            else {
                for (int i = gap; i < eList.size(); i++) {
                    int j = i;
                    E k = eList.get(i);
                    while (j >= gap && compareToSort(eList.get(i), eList.get(j - gap), order) < 0) {
                        eList.set(j, eList.get(j - gap));
                    }
                    eList.set(j, k);
                }
            }
            gap = (int)Math.floor(gap/2);
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
