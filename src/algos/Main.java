package algos;

import algos.dynamic_connectivity.QuickUnion;
import algos.dynamic_connectivity.UnionFinder;
import algos.inversions.InversionCounter;
import algos.inversions.InversionSortAndCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InversionCounter<Integer> counter = new InversionSortAndCounter<>();
        System.out.println(counter.count(Arrays.asList(6, 5, 4, 3, 2, 1)));
    }

    public <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
