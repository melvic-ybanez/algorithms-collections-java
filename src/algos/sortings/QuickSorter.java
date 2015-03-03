package algos.sortings;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 3/3/2015.
 */
public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {
    public QuickSorter(Comparator<T> comparator) {
        super(comparator);
    }
    
    public QuickSorter() {
        super();
    }
    
    @Override
    public List<T> sort(List<T> xs) {
        return null;
    }
    
    public List<T> partition(List<T> xs, int l, int r) {
        if (r - l <= 1 || xs.size() <= l) return xs;
        T pivot = xs.get(l);
        int i = l + 1;
        for (int j = l + 1; j < r; j++) {
            if (getComparator().compare(xs.get(j), pivot) <= 0) {
                swap(xs, j, i);
                i++;
            }
        }
        swap(xs, l, i - 1);
        return xs;
    }
    
    private List<T> swap(List<T> xs, int a, int b) {
        T temp = xs.get(a);
        xs.set(a, xs.get(b));
        xs.set(b, temp);
        return xs;
    }
}
