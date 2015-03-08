package algos.data_structures.trees;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by ybamelcash on 3/8/2015.
 */
public class BST<E extends Comparable<E>> {
    private E item;
    private BST<E> left;
    private BST<E> right;
    private Comparator<E> comparator;
    
    public BST(E item, BST<E> left, BST<E> right, Comparator<E> comparator) {
        reset(item, left, right);
        this.comparator = comparator;
    }
    
    public BST(E item, BST<E> left, BST<E> right) {
        this(item, left, right, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
    public BST(E item) {
        this(item, null, null);
    }
    
    public BST() {}
    
    public BST<E> search(E item) {
        if (isEmpty()) return null;
        int comparison = compare(item, getItem());
        if (comparison == 0) return this;
        if (comparison < 0) return hasLeft()? getLeft().search(item) : null;
        if (comparison > 0) return hasRight()? getRight().search(item) : null;
    }
    
    private int compare(E item1, E item2) {
        return Objects.compare(item1, item2, comparator);
    }
    
    private void reset(E item, BST<E> left, BST<E> right) {
        setItem(item);
        setLeft(left);
        setRight(right);
    }
    
    public void setItem(E item) {
        this.item = item;
    }
    
    public void setLeft(BST<E> left) {
        this.left = left;
    }
    
    public void setRight(BST<E> right) {
        this.right = right;
    }
    
    public E getItem() {
        return item;
    }
    
    public BST<E> getLeft() {
        return left;
    }
    
    public BST<E> getRight() {
        return right;
    }
    
    public boolean hasLeft() {
        return getLeft() != null;
    }
    
    public boolean hasRight() {
        return getRight() != null;
    }
    
    public boolean isLeaf() {
        return !isEmpty() && (!hasLeft() || !hasRight());
    }
    
    public boolean isEmpty() {
        return getItem() == null && !hasLeft() && !hasRight();
    }
}
