package ru.job4j.generic;

/**
 * class RoleStore
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class RoleStore<T extends Role> extends AbstractStore<T> {

    public RoleStore(int size) {
        super(size);
    }
}
