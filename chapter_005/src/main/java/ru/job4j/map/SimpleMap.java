package ru.job4j.map;

import java.util.*;

/**
 * class SimpleMap.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.07.2019
 *
 */
public class SimpleMap<K, V> implements Iterable {
    private Node<K, V>[] hashTable;
    private int modCount;
    private int size;
    private float threshold;

    /**
     * constructor, in which the initial size of the array
     * is specified (number of baskets).
     */
    public SimpleMap() {
        this.hashTable = new Node[16];
        this.size = 0;
        this.modCount = 0;
        this.threshold = hashTable.length * 0.75f;
    }

    /**
     * This method adds a key-value pair to the map.
     *
     * @param key - key value.
     * @param value - value by key.
     * @return a boolean value true if the key-value pair is added to the map, otherwise it is false.
     */
    public boolean insert(final K key, final V value) {
        if (size >= threshold) {
            threshold *= 2;
            arrayIncrease();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = indexFor(key);

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method provides the addition of a key-value pair to the map,
     * provided that there is a free basket for the calculated index.
     *
     * @param index - calculated basket index by hash code.
     * @param newNode - new key-value pair which we are going to add to the map.
     * @return a boolean value true if the key-value pair is added to the map, otherwise it is false.
     */
    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        modCount++;
        return true;
    }

    /**
     * This method allows you to overwritten the value by key equal to the key
     * of the key-value pair to be added.
     *
     * @param nodeFromList - key-value pair from a linked list taken from the recycle bin by index.
     * @param newNode - new key-value pair which we are going to add to the map.
     * @param value - the value of the new key-value pair that we want to add to the map.
     * @return a boolean value true if the value by key was overwritten, otherwise it is false.
     */
    private boolean keyExistButValueNew(final Node<K, V> nodeFromList,
                                        final Node<K, V> newNode,
                                        final V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * This method increases the array of baskets in the map if the map is loaded
     * or equal to or greater than the loadFactor.
     */
    private void arrayIncrease() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    /**
     * This method resolves collisions in the map that arise due to the imperfection of
     * a mathematical function. That is, the added key-value pair has the same hash code,
     * and, therefore, the basket index as the key-value pair located in the map.
     * When such a situation arises, the key-value pair is added to the linked list in the same basket.
     *
     * @param nodeFromList - key-value pair from a linked list taken from the recycle bin by index.
     * @param newNode - new key-value pair which we are going to add to the map.
     * @param nodes - Linked list from class Node.
     * @return the boolean value is true if the key-value pair has been added to the linked list
     * of the corresponding basket, otherwise false.
     */
    private boolean collisionProcessing(final Node<K, V> nodeFromList,
                                        final Node<K, V> newNode,
                                        final List<Node<K, V>> nodes) {

        if (newNode.hash == nodeFromList.hash
                && !Objects.equals(newNode.key, nodeFromList.key)
                && !Objects.equals(newNode.getValue(), nodeFromList.getValue())) {
            nodes.add(newNode);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * This method returns the value by key from the map.
     *
     * @param key - key value.
     * @return the value by key,
     * and if there is no such key in the card, then this method will return null.
     */
    public V get(final K key) {
        int index = indexFor(key);

        if (index < hashTable.length && hashTable[index] != null) {

            if (hashTable[index].getNodes().size() == 1 && key.equals(hashTable[index].getKey())) {
                return hashTable[index].getNodes().get(0).getValue();
            }

            List<Node<K, V>> nodeList = hashTable[index].getNodes();
            for (Node<K, V> node : nodeList) {
                if (key.equals(node.key)) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    /**
     * This method removes a key-value pair from the map by key value
     *
     * @param key - key value.
     * @return a boolean value true if the method succeeds in removing
     * the key-value pair from the map otherwise - false.
     */
    public boolean delete(final K key) {
        int index = indexFor(key);
        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].getNodes().size() == 1 && key.equals(hashTable[index].getKey())) {
            hashTable[index] = null;
            size--;
            modCount++;
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.key)) {
                nodeList.remove(node);
                size--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns the integer map size.
     *
     * @return the integer map size.
     */
    public int size() {
        return size;
    }

    /**
     * This method calculates the hash code of a key-value pair by key.
     *
     * @param key - key value.
     * @return he hash code by key.
     */
    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode() ^ key.hashCode() >>> 16;
    }

    /**
     * This method calculates the basket index in the array by key.
     *
     * @param key - key value.
     * @return the basket index.
     */
    private int indexFor(K key) {
        return hash(key) & hashTable.length - 1;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int counterBasket = 0;
            private int valuesCounter = 0;
            Iterator<Node<K, V>> nodeIterator = null;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (valuesCounter == size) {
                    return false;
                }
                if (nodeIterator == null || !nodeIterator.hasNext()) {
                    if (moveToNextBasket()) {
                        nodeIterator = hashTable[counterBasket].getNodes().iterator();
                    } else {
                        return false;
                    }
                }
                return nodeIterator.hasNext();
            }

            private boolean moveToNextBasket() {
                counterBasket++;
                while (counterBasket < hashTable.length - 1 && hashTable[counterBasket] == null) {
                    counterBasket++;
                }
                return true;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new ConcurrentModificationException();
                }
                valuesCounter++;
                return nodeIterator.next().getValue();
            }
        };
    }

    /**
     * class Node - key-value implementing pair.
     *
     * @param <K> key parameter type.
     * @param <V> key parameter type.
     */
    public class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.nodes = new LinkedList<>();
            this.key = key;
            this.value = value;
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?, ?> node = (Node<?, ?>) o;

            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}