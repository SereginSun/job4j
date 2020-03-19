package ru.job4j.calculator;

/**
 * abstract class BaseAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public abstract class BaseAction implements UserAction {
    private final String key;
    private final String name;

    public BaseAction(final String key, final String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public String info() {
        return String.format("\"%s\" - %s", this.key, this.name);
    }
}
