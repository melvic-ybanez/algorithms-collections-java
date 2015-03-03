package algos;

import algos.dynamic_connectivity.QuickUnion;
import algos.dynamic_connectivity.UnionFinder;
import algos.inversions.InversionCounter;
import algos.inversions.InversionSortAndCounter;
import algos.sortings.InsertionSorter;
import algos.sortings.MergeSorter;
import algos.sortings.QuickSorter;
import algos.sortings.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] xse = { 3, 8, 2, 5, 1, 4, 7, 6 };
        List<Integer> xs = new ArrayList<>();
        for (int x : xse) {
            xs.add(x);
        }
        QuickSorter<Integer> sorter = new QuickSorter<>();
        System.out.println(listToString(sorter.partition(xs, 0, xs.size() - 1)));
    }

    public static <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
