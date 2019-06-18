package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class NodeTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.06.2019
 */
public class NodeTest {
    Node<String> firstNode = new Node<>("first");
    Node<String> secondNode = new Node<>("second");
    Node<String> thirdNode = new Node<>("third");
    Node<String> fourthNode = new Node<>("fourth");

    @Test
    public void whenListHasLoopThanTrue() {
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = firstNode;
        assertThat(firstNode.hasCycle(firstNode), is(true));
    }

    @Test
    public void whenListHasLoopInMiddleThanTrue() {
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = secondNode;
        fourthNode.next = null;
        assertThat(firstNode.hasCycle(firstNode), is(true));
    }

    @Test
    public void whenListHasLoopThanFalse() {
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = null;
        assertThat(firstNode.hasCycle(firstNode), is(false));
    }
}