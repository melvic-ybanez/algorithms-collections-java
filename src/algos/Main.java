package algos;

import algos.data_structures.lists.List;
import algos.data_structures.stacks.Stack;
import algos.utils.Pair;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> xs = new Stack<>();
        xs.push(1).push(2).push(3);
        System.out.println(xs.getSize());
        System.out.println(xs);
        System.out.println(xs.pop());
        System.out.println(xs.pop());
        System.out.println(xs.pop());
        System.out.println(xs.pop());
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
