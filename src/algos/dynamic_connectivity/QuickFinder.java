package algos.dynamic_connectivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 3/1/2015.
 */
public class QuickFinder<T extends Comparable<T>> implements UnionFinder<T> {
    private List<T> xs;
    private Comparator<T> comparator;
    
    public QuickFinder(List<T> xs, Comparator<T> comparator) {
        this.xs = xs;
        this.comparator = comparator;
    }
    
    public QuickFinder(List<T> xs) {
        this(xs, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
    public boolean connected(int p, int q) {
        return equalElements(xs.get(p), xs.get(q)); 
    }
    
    public List<T> union(int p, int q) {
        T pElem = xs.get(p);
        T qElem = xs.get(q);
        for (int i = 0; i < xs.size(); i++) {
            if (equalElements(xs.get(i), pElem)) {
                xs.set(i, qElem);
            }
        }
        return xs;
    }

    private boolean equalElements(T a, T b) {
        return comparator.compare(a, b) == 0;
    }
}
