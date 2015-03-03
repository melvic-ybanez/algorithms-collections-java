package algos.sortings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 2/20/2015.
 */
public class MergeSorter<T extends Comparable<T>> extends Sorter<T> {
    private T sentinel;

    public MergeSorter(T sentinel) {
        super();
        this.sentinel = sentinel;
    }

    public MergeSorter(Comparator<T> comparator, T sentinel) {
        super(comparator);
        this.sentinel = sentinel;
    }

    public List<T> merge(List<T> xs, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            left.add(xs.get(p + i));
        }
        for (int i = 0; i < n2; i++) {
            right.add(xs.get(q + i + 1));
        }

        left.add(sentinel);
        right.add(sentinel);
        
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            T leftItem = left.get(i);
            T rightItem = right.get(j);
            if (getComparator().compare(leftItem, rightItem) <= 0) {
                xs.set(k, leftItem);
                i++;
            } else {
                xs.set(k, rightItem);
                j++;
            }
        }
        return xs;
    }
    
    @Override
    public List<T> sort(List<T> xs) {
        return mergeSort(xs, 0, xs.size() - 1);
    }
    
    private List<T> mergeSort(List<T> xs, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            xs = mergeSort(xs, p, q);
            xs = mergeSort(xs, q + 1, r);
            xs = merge(xs, p, q, r);
        }
        return xs;
    }
}
