package ru.job4j.design.parking;

import java.util.Set;

/**
 * interface IParking.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public interface IParking {

    boolean park(Auto car);

    boolean unpark(Auto car);

    int getFreePlaces();

    Set<Auto> getAuto();
}
