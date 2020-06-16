package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * interface Report.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public interface Report {

    String generate(Predicate<Employee> filter);
}
