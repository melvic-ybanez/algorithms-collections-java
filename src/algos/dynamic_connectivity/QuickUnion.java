package algos.dynamic_connectivity;

/**
 * Created by ybamelcash on 3/1/2015.
 */
public class QuickUnion extends UnionFinder {
    public QuickUnion(int n) {
        super(n);
    }
    
    @Override
    public boolean connected(int p, int q) {
        return rootOf(p) == rootOf(q);
    }
    
    private int rootOf(int i) {
        while (ids[i] != i) i = ids[i];
        return i;        
    }

    @Override
    public UnionFinder union(int p, int q) {
        int pRoot = rootOf(p);
        ids[pRoot] = q;
        return this;
    }
}
