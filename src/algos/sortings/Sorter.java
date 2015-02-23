package algos.sortings;

import java.util.List;

/**
 * Created by ybamelcash on 2/23/2015.
 */
public interface Sorter <T extends Comparable<T>>{
    public List<T> sort(List<T> xs);
}
