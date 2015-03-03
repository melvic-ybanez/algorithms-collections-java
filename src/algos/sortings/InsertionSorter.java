package algos.sortings;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 2/23/2015.
 */
public class InsertionSorter<T extends Comparable<T>> extends Sorter<T> {
    public InsertionSorter() {
        super();
    }

    public InsertionSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> xs) {
        for (int i = 1; i < xs.size(); i++) {
            T key = xs.get(i);
            int j = i - 1;
            for (; j > -1; j--) {
                T key1 = xs.get(j);
                if (getComparator().compare(key1, key) <= 0) {
                    break;
                }
                xs.set(j + 1, key1);
            }
            xs.set(j + 1, key);
        } 
        return xs;
    }
}
