package ru.job4j.search;

/**
 * class Task
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.03.2019
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}