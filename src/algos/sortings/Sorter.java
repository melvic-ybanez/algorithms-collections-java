package algos.sortings;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 2/23/2015.
 */
public abstract class Sorter <T extends Comparable<T>> {
    private Comparator<T> comparator;
    
    public Sorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    
    public Sorter() {
        this(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
    public Comparator<T> getComparator() {
        return comparator;
    }
    
    public abstract List<T> sort(List<T> xs);
}
