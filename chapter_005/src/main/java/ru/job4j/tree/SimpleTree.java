package ru.job4j.tree;

import java.util.Optional;

/**
 * interface SimpleTree.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.07.2019
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * add child element to parent, parent can have child list.
     * @param parent parent.
     * @param child child.
     * @return true - if a child element has been added, otherwise - false.
     */
    boolean add(E parent, E child);

    /**
     * The method checks if there is a value in the tree.
     * Starts checking with the root. Adds it to the queue.
     * Removes it from the queue. If the root does not contain the desired item,
     * then its descendants are added to the queue.
     * Then elements are retrieved in turn, if the element does not contain a value,
     * all its descendants are added to the queue.
     * Thus, the verification occurs by level (root, all elements of level 1, 2, etc.).
     *
     * @param value - required value.
     * @return returns the node in which the value is found.
     */
    Optional<Node<E>> findBy(E value);
}
