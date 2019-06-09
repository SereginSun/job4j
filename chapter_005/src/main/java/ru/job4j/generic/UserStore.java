package ru.job4j.generic;

/**
 * class UserStore
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}