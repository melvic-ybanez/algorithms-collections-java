package algos.sortings;

import algos.utils.Pair;
import algos.utils.Utils;

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
        return quickSort(xs, 0, xs.size());
    }
    
    private List<T> quickSort(List<T> xs, int l, int r) {
        if (xs.size() <= 1 || r - l <= 1) return xs;
        int i = partition(xs, l, r);
        quickSort(xs, l, i - 2);
        quickSort(xs, i, r);
        return xs;
    }
    
    private int partition(List<T> xs, int l, int r) {
        T pivot = xs.get(l);
        int i = l + 1;
        for (int j = l + 1; j < r; j++) {
            if (getComparator().compare(xs.get(j), pivot) < 0) {
                Utils.swap(xs, j, i);
                i++;
            }
        }
        Utils.swap(xs, l, i - 1);
        return i;
    }
}
