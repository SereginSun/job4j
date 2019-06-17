package ru.job4j.list;

/**
 * class SimpleQueue, based on two stacks.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 17.06.2019
 */
public class SimpleQueue<E> {
    private SimpleStack<E> input = new SimpleStack<>();
    private SimpleStack<E> output = new SimpleStack<>();
    private int size;

    /**
     * The method returns the value and remove it from the reverse stack.
     *
     * @return deleted value.
     */
    public E poll() {
        for (int i = 0; i < this.size; i++) {
            this.output.push(this.input.poll());
        }
        this.size = 0;
        return this.output.poll();
    }

    /**
     * This method puts the value in the stack.
     *
     * @param value - value to be placed to the stack.
     */
    public void push(E value) {
        this.input.push(value);
        this.size++;
    }
}
