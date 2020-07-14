package ru.job4j.design.parking;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * abstract class Places - describes places for vehicles.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public abstract class Places implements IParking {
    protected Set<Auto> cars = new LinkedHashSet<>();
    protected int size;
    protected int count;

    protected Places(int size) {
        this.size = size;
        this.count = 0;
    }

    /**
     * The method returns the number of free places.
     * @return the number of free places.
     */
    @Override
    public int getFreePlaces() {
        return size - count;
    }

    /**
     * The method returns a Set of vehicles.
     * @return a Set of vehicles.
     */
    public Set<Auto> getAuto() {
        return cars;
    }
}
