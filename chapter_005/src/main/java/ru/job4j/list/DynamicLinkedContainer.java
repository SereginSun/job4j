package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class DynamicLinkedContainer, based on linked list.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru).
 * @version $Id$
 * @since 12.06.2019
 */
public class DynamicLinkedContainer<E> implements Iterable<E> {

    private Node<E> node;
    private int position;
    private int modCount;

    /**
     * Constructs an empty list.
     */
    public DynamicLinkedContainer() {
        this.node = null;
        this.position = 0;
        this.modCount = 0;
    }

    /**
     * This method adds value to the container.
     *
     * @param value - value added to container.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.node;
        this.node = newLink;
        this.modCount++;
        this.position++;
    }

    /**
     * This method returns an array element by his index.
     *
     * @param index - index of element.
     * @return array element at index.
     */
    public E get(int index) {
        if (index > this.position) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = this.node;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Returns an iterator for the elements in this list in proper sequence.
     * The returned iterator is fail-fast.
     *
     * @return an iterator object.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int iterCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (iterCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }

    /**
     * Data storage class
     *
     * @param <E> - a reference type of data value
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
