package algos.data_structures.trees;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Created by ybamelcash on 3/8/2015.
 */
public class BST<A extends Comparable<A>> {
    private A item;
    private BST<A> left;
    private BST<A> right;
    private Comparator<A> comparator;
    
    public BST(A item, BST<A> left, BST<A> right, Comparator<A> comparator) {
        reset(item, left, right);
        this.comparator = comparator;
    }
    
    public BST(A item, BST<A> left, BST<A> right) {
        this(item, left, right, (o1, o2) -> o1.compareTo(o2));
    }
    
    public BST(A item) {
        this(item, BST.empty(), BST.empty());
    }
    
    public BST() {}
    
    public static <E extends Comparable<E>> BST<E> empty() {
        return new BST<>();
    }
    
    public BST<A> search(A item) {
        if (isEmpty()) return BST.empty();
        int comparison = compare(item, getItem());
        if (comparison < 0) return hasLeft()? getLeft().search(item) : BST.empty();
        if (comparison > 0) return hasRight()? getRight().search(item) : BST.empty();
        return this;
    }
    
    public BST<A> findMinimum() {
        if (hasLeft()) return getLeft().findMinimum();
        return this;
    }
    
    public BST<A> findMaximum() {
        if (hasRight()) return getRight().findMaximum();
        return this;
    }
    
    public <B> B inOrder(B acc, BiFunction<A, B, B> f) {
        if (isEmpty()) return acc;
        B leftResult = hasLeft()? getLeft().inOrder(acc, f) : acc;
        B newAcc = f.apply(getItem(), leftResult);
        B rightResult = hasRight()? getRight().inOrder(newAcc, f) : newAcc;
        return rightResult;
    }
    
    public <B> B preOrder(B acc, BiFunction<A, B, B> f) {
        if (isEmpty()) return acc;
        B newAcc = f.apply(getItem(), acc);
        B leftResult = hasLeft()? getLeft().preOrder(newAcc, f) : newAcc;
        B rightResult = hasRight()? getRight().preOrder(leftResult, f) : leftResult;
        return rightResult;
    }
    
    public <B> B postOrder(B acc, BiFunction<A, B, B> f) {
        if (isEmpty()) return acc;
        B leftResult = hasLeft()? getLeft().postOrder(acc, f) : acc;
        B rightResult = hasRight()? getRight().postOrder(leftResult, f) : leftResult;
        return f.apply(getItem(), rightResult);
    }
    
    private int compare(A item1, A item2) {
        return Objects.compare(item1, item2, comparator);
    }
    
    private void reset(A item, BST<A> left, BST<A> right) {
        setItem(item);
        setLeft(left);
        setRight(right);
    }
    
    public void setItem(A item) {
        this.item = item;
    }
    
    public void setLeft(BST<A> left) {
        this.left = left;
    }
    
    public void setRight(BST<A> right) {
        this.right = right;
    }
    
    public A getItem() {
        return item;
    }
    
    public BST<A> getLeft() {
        return right;
    }

    public BST<A> getRight() {
        return right;
    }
    
    public boolean hasLeft() {
        return getLeft() != null && !getLeft().isEmpty();
    }
    
    public boolean hasRight() {
        return getRight() != null && !getRight().isEmpty();
    }
    
    public boolean isLeaf() {
        return !isEmpty() && (!hasLeft() || !hasRight());
    }
    
    public boolean isEmpty() {
        return getItem() == null && getLeft() == null && getRight() == null;
    }
}
