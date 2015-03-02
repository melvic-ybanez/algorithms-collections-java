package algos.utils;

/**
 * Created by ybamelcash on 3/2/2015.
 */
public class Pair<A, B> {
    private A first;
    private B second;
    
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    
    public A getFirst() {
        return first;
    }
    
    public B getSecond() {
        return second;
    }
    
    public Pair<A, B> withFirst(A newFirst) {
        return new Pair<>(newFirst, second);
    }
    
    public Pair<A, B> withSecond(B newSecond) {
        return new Pair<>(first, newSecond);
    }
}
