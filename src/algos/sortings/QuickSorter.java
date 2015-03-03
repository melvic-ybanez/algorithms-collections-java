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
}
