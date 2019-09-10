import java.util.ArrayList;

/**
 * Created by shawn on 4/27/2017.
 */
public class Main {
    public static void main(String... args) {
        Sorter<String> insertionsorter = new InsertionSorter();
        Sorter<Double> gapsorter = new GapSorter();
        Sorter<Integer> mergesorter = new MergeSorter();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(5);
        a1.add(2);
        a1.add(3);
        a1.add(1);
        a1.add(7);
        mergesorter.sort(a1, Sorter.Order.ASCENDING);
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("almost");
        a2.add("It");
        a2.add("summer");
        a2.add("break");
        a2.add("is");
        insertionsorter.sort(a2, Sorter.Order.ASCENDING);
        ArrayList<Double> a3 = new ArrayList<Double>();
        a3.add(0.6);
        a3.add(0.8);
        a3.add(0.7);
        a3.add(1.0);
        a3.add(-5.8);
        a3.add(0.0);
        a3.add(0.0);
        gapsorter.sort(a3, Sorter.Order.ASCENDING);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());

// similarly for the other sorters
    }
}
