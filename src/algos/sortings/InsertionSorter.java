package algos.sortings;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 2/23/2015.
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {
    private Comparator<T> comparator;
    
    public InsertionSorter() {
        this(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public InsertionSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> sort(List<T> xs) {
        for (int i = 1; i < xs.size(); i++) {
            T key = xs.get(i);
            int j = i - 1;
            for (; j > -1; j--) {
                T key1 = xs.get(j);
                if (comparator.compare(key1, key) <= 0) {
                    break;
                }
                xs.set(j + 1, key1);
            }
            xs.set(j + 1, key);
        } 
        return xs;
    }
}
