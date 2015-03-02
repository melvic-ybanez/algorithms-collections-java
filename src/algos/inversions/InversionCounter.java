package algos.inversions;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 3/2/2015.
 */
public abstract class InversionCounter<T extends Comparable<T>> {
    private Comparator<T> comparator;
    
    public InversionCounter(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    
    public InversionCounter() {
        this(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
    protected boolean lessThan(T a, T b) {
        return comparator.compare(a, b) < 0;
    }
    
    public abstract int count(List<T> xs);
}
