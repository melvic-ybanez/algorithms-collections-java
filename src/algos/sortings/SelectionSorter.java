package algos.sortings;

import algos.utils.Utils;

import java.util.List;

/**
 * Created by ybamelcash on 3/5/2015.
 */
public class SelectionSorter<T extends Comparable<T>> extends Sorter<T> {
    @Override
    public List<T> sort(List<T> xs) {
        for (int i = 0; i < xs.size(); i++) {
            int min = i;
            for (int j = i + 1; j < xs.size(); j++) {
                if (getComparator().compare(xs.get(j), xs.get(min)) <= 0) {
                    min = j;
                }
            }
            Utils.swap(xs, i, min);
        }
        return xs;
    }
}
