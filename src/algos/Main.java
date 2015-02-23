package algos;

import algos.sortings.MergeSorter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> xs = new ArrayList<>();
        int[] xsItems = { 5, 6, 2, 1, 4 };
        for (int xsItem : xsItems) {
            xs.add(xsItem);
        }
        MergeSorter sorter = new MergeSorter(Integer.MAX_VALUE);
        System.out.println(sorter.sort(xs));
        System.out.println(sorter.sort(new ArrayList()));
    }

    public <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
