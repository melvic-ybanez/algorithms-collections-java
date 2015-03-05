package algos.utils;

import java.util.List;

/**
 * Created by ybamelcash on 3/5/2015.
 */
public class Utils {
    public static <T> void swap(List<T> xs, int a, int b) {
        T temp = xs.get(a);
        xs.set(a, xs.get(b));
        xs.set(b, temp);
    }
}
