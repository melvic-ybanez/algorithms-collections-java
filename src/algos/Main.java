package algos;

import algos.dynamic_connectivity.QuickUnion;
import algos.dynamic_connectivity.UnionFinder;
import algos.inversions.InversionCounter;
import algos.inversions.InversionSortAndCounter;
import algos.sortings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] xse = { 3, 8, 2, 5, 1, 4, 3, 7, 6 };
        List<Integer> xs = new ArrayList<>();
        for (int x : xse) {
            xs.add(x);
        }
        Sorter<Integer> sorter = new SelectionSorter<>();
        System.out.println(listToString(sorter.sort(xs)));
    }

    public static <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
