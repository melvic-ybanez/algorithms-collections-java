package algos.inversions;

import algos.utils.Pair;

import java.util.Collections;
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
            return new Pair<>(Collections.emptyList(), 0);
        } 
        
        int half = xs.size() / 2;
        Pair<List<T>, Integer> left = sortAndCount(xs.subList(0, half));
        Pair<List<T>, Integer> right = sortAndCount(xs.subList(half, xs.size()));
        Pair<List<T>, Integer> split = countSplitInversions(left.getFirst(), right.getFirst());
        
        return split.withSecond(left.getSecond() + right.getSecond() + split.getSecond());
    }
    
    private Pair<List<T>, Integer> countSplitInversions(List<T> xs, List<T> ys) {
        
    } 
}
