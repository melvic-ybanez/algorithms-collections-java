package algos;

import algos.data_structures.lists.List;
import algos.utils.Pair;

public class Main {

    public static void main(String[] args) {
        List<Integer> xs = new List<>();
        //xs.insert(1).insert(2).insert(3);
        System.out.println(xs.getSize());
        System.out.println(xs);
        System.out.println(xs.delete(3));
        System.out.println(xs);
        System.out.println(xs.getSize());
    }

    public static <T> String listToString(java.util.List<T> xs) {
        StringBuilder bd = new StringBuilder("");
        for (T x : xs) {
            bd.append(x + " ");
        }
        return bd.toString();
    }
}
