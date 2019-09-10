import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawn on 4/24/2017.
 */
public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {
    public MergeSorter(){

    }
    public void sort(List<E> eList, Order order){

        List<E> newList = mergeSort(eList, order);
        for (int i = 0; i < eList.size(); i++){
            eList.set(i, newList.get(i));
        }
    }

    private List<E> mergeSort(List<E> eList, Order order){
        List<E> lList = new ArrayList<E>();
        List<E> rList = new ArrayList<E>();
        if (eList.size() == 1){
            return eList;
        }
        for (int i = 0; i < eList.size(); i++){
            E tmp = eList.get(i);
            if (i < eList.size()/2){
                lList.add(tmp);
            } else {
                rList.add(tmp);
            }
        }
        lList = mergeSort(lList, order);
        rList = mergeSort(rList, order);
        return merge(lList, rList, order);
    }
    private List<E> merge(List<E> lList, List<E> rList, Order order){
        List<E> r = new ArrayList<E>();
        while (!lList.isEmpty() && !rList.isEmpty()){
            if (compareToSort(lList.get(0), rList.get(0), order) <= 0){
                r.add(lList.get(0));
                lList.remove(0);
            } else {
                r.add(rList.get(0));
                rList.remove(0);
            }
        }
        while (!lList.isEmpty()){
            r.add(lList.get(0));
            lList.remove(0);
        }
        while (!rList.isEmpty()){
            r.add(rList.get(0));
            rList.remove(0);
        }
        return r;
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
