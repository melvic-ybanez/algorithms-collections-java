package algos;

import algos.dynamic_connectivity.QuickUnion;
import algos.dynamic_connectivity.UnionFinder;
import algos.inversions.InversionCounter;
import algos.inversions.InversionSortAndCounter;
import algos.sortings.*;
import algos.strings.PatternMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(PatternMatcher.find("ab", "abbas"));
    }

    public static <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
