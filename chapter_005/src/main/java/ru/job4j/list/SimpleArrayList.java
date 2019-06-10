package ru.job4j.list;

/**
 * class SimpleArrayList - in this class must implement the method delete for a single-linked list.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.06.2019
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * This method inserts the specified item at the top of the list.
     *
     * @param data - the element to add.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * This method removes the first item from the list.
     *
     * @return data of the deleted element.
     */
    public E delete() {
        E result = null;
        if (size > 0) {
            result = this.first.data;
            this.first = this.first.next;
            this.size--;
        }
        return result;
    }

    /**
     * This method returns an element by index.
     *
     * @param index - index of the element to return.
     * @return an element by index.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * This method returns the size of the collection.
     *
     * @return the size of  the collection.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * The class is intended for data storage.
     *
     * @param <E> - generalized parameter of the type of stored data.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}