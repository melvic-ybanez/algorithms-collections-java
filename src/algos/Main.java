package algos;

import algos.dynamic_connectivity.QuickUnion;
import algos.dynamic_connectivity.UnionFinder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UnionFinder uf = new QuickUnion(10);
        System.out.println(uf.connected(2, 6));
        System.out.println(uf.connected(4, 5));
        uf.union(4, 5);
        System.out.println(uf.connected(4, 5));
        uf.union(2, 4).union(2, 6);
        System.out.println(uf.connected(2, 5));
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
