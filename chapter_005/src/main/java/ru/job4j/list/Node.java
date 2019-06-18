package ru.job4j.list;

/**
 * class Node.
 * Use of Floyd's "Turtle and Hare" algorithm
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.06.2018
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * This method checks the presence of a cycle in a single-linked list.
     * @param first - The first element of a single-linked list.
     * @return true if there are circular references in the list.
     */
    public boolean hasCycle(Node<T> first) {
        Node<T> slow = first;
        Node<T> fast = first;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
