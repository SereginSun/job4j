package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * class Node.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.07.2019
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    /**
     * This method adds a child element to the node.
     *
     * @param child - the node that we want to add.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * This method returns a list of children elements for the node.
     *
     * @return a list of children elements.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * This method checks the equality of the added value with
     * the value in the node in the tree.
     * @param that - compared value.
     * @return true - if the values are equal, otherwise - false.
     */
    public boolean eqValues(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}