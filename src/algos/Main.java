package algos;

import algos.dynamic_connectivity.QuickFinder;
import algos.dynamic_connectivity.UnionFinder;
import algos.sortings.MergeSorter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> xs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            xs.add(i);
        }
        UnionFinder<Integer> uf = new QuickFinder<>(xs);
        System.out.println(uf.connected(2, 6));
        System.out.println(uf.connected(4, 5));
        uf.union(4, 5);
        System.out.println(uf.connected(4, 5));
        uf.union(2, 4);
        System.out.println(uf.connected(2, 5));
        uf.union(2, 6);
        System.out.println(uf.connected(5, 6));
    }

    public <T> String listToString(List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
