package algos.dynamic_connectivity;

import java.util.List;

/**
 * Created by ybamelcash on 3/1/2015.
 */
public abstract class UnionFinder {
    protected int[] ids;
    
    public UnionFinder(int n) {
        ids = new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }    
    }
    
    public abstract boolean connected(int p, int q);
    public abstract UnionFinder union(int p, int q);
}
