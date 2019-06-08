package ru.job4j.generic;

/**
 * class UserStore
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class UserStore<T extends User> extends AbstractStore<T> {

    public UserStore(int size) {
        super(size);
    }
}