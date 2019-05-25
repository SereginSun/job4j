package ru.job4j.search;

import java.util.LinkedList;

/**
 * class PriorityQueue
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.03.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method put() must insert an element at the desired position.
     * Position is determined by the field priority.
     * To insert use add(int index, E value)
     * @param task task in the list
     */
    public void put(Task task) {
        var count = 0;
        for (var index : this.tasks) {
            if (task.getPriority() < index.getPriority()) {
                break;
            }
            count++;
        }
        this.tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
