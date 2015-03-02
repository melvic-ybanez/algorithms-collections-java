package algos.inversions;

import algos.utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ybamelcash on 3/2/2015.
 */
public class InversionSortAndCounter<T extends Comparable<T>> extends InversionCounter <T> {
    @Override
    public int count(List<T> xs) {
        return sortAndCount(xs).getSecond();
    }
    
    private Pair<List<T>, Integer> sortAndCount(List<T> xs) {
        if (xs.size() <= 1) {
            return new Pair<>(xs, 0);
        } 
        
        int half = xs.size() / 2;
        Pair<List<T>, Integer> left = sortAndCount(xs.subList(0, half));
        Pair<List<T>, Integer> right = sortAndCount(xs.subList(half, xs.size()));
        Pair<List<T>, Integer> split = countSplitInversions(left.getFirst(), right.getFirst());
        
        return split.withSecond(left.getSecond() + right.getSecond() + split.getSecond());
    }
    
    private Pair<List<T>, Integer> countSplitInversions(List<T> xs, List<T> ys) {
        List<T> zs = new ArrayList<>();
        int count = 0;
        int i = 0;
        int j = 0;
        
        while (true) {
            if (i < xs.size() && j < ys.size()) {
                T x = xs.get(i);
                T y = ys.get(j);
                if (lessThanOrEqualTo(x, y)) {
                    zs.add(x);
                    i++;
                } else {
                    zs.add(y);
                    count += xs.size() - i;
                    j++;
                }
            } else if (i < xs.size()) {
                zs.add(xs.get(i));
                i++;
            } else if (j < ys.size()) {
                zs.add(ys.get(j));
                j++;
            } else break;
        }
        
        return new Pair<>(zs, count);
    }
}
