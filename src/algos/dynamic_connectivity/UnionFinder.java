package algos.dynamic_connectivity;

import java.util.List;

/**
 * Created by ybamelcash on 3/1/2015.
 */
public interface UnionFinder<T extends Comparable<T>> {
    public boolean connected(int p, int q);
    public List<T> union(int p, int q); 
}
