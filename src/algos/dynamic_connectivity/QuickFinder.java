package algos.dynamic_connectivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ybamelcash on 3/1/2015.
 */
public class QuickFinder extends UnionFinder {
    public QuickFinder(int n) {
        super(n);
    }
    
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }
    
    public UnionFinder union(int p, int q) {
        int pValue = ids[p];
        int qValue = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pValue) {
                ids[i] = qValue;
            }
        }
        return this;
    }
}
