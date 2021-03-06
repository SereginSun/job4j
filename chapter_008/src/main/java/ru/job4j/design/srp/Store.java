package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * interface Store.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public interface Store {

    List<Employee> findBy(Predicate<Employee> filter);
}
