package algos;

import algos.data_structures.list.List;
import algos.utils.Pair;

public class Main {

    public static void main(String[] args) {
        List<Integer> xs = new List<>(1).insert(2).insert(3);
        System.out.println(xs);
        System.out.println(xs.search(5));
        System.out.println(xs.search(3));
        Pair<Boolean, List<Integer>> result = xs.delete(3);
        System.out.println(result.getFirst());
        System.out.println(result.getSecond());
    }

    public static <T> String listToString(java.util.List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
