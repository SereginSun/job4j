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

    void park(Auto car);

    void unpark(Auto car);

    int getFreePlaces();

    Set<Auto> getAuto();
}
