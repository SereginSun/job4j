package ru.job4j.design.parking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * class IParking - describes the interaction of a vehicle with parking places.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class Parking {
    private int carsPlaces;
    private int trucksPlaces;
    private final Auto[] arrCars;
    private final Auto[] arrTrucks;

    public Parking(int carsPlaces, int trucksPlaces) {
        this.carsPlaces = carsPlaces;
        this.trucksPlaces = trucksPlaces;
        this.arrCars = new Auto[carsPlaces];
        this.arrTrucks = new Auto[trucksPlaces];
    }

    /**
     * The method tells the client whether the vehicle can be parked.
     * @param auto - vehicle.
     */
    public void park(Auto auto) {
        if (auto.getSize() > 1) {
            int temp = (int) Math.ceil(auto.getSize() / 2.0);
            if (temp <= trucksPlaces) {
                neighborsCheck(auto, arrTrucks, temp);
                trucksPlaces -= temp;
            } else if (auto.getSize() <= carsPlaces) {
                neighborsCheck(auto, arrCars, auto.getSize());
                carsPlaces -= auto.getSize();
            }
        } else if (auto.getSize() <= carsPlaces) {
            for (int i = 0; i < arrCars.length; i++) {
                if (arrCars[i] == null) {
                    arrCars[i] = auto;
                    carsPlaces -= auto.getSize();
                    break;
                }
            }
        }
    }

    public void neighborsCheck(Auto auto, Auto[] vehicles, int size) {
        int count = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                count++;
                if (count == size) {
                    for (int j = i; j > i - count; j--) {
                        vehicles[j] = auto;
                    }
                    break;
                }
            }
        }
    }

    /**
     * The method returns the total number of free places.
     * @return the total number of free places.
     */
    public int getFreePlaces() {
        return carsPlaces + trucksPlaces;
    }

    /**
     * The method removes the vehicle from the parking lot.
     * @param auto - vehicle.
     */
    public void unpark(Auto auto) {
        for (int i = 0; i < arrCars.length; i++) {
            if (arrCars[i] != null && arrCars[i].equals(auto)) {
                arrCars[i] = null;
                carsPlaces++;
            }
        }

        for (int i = 0; i < arrTrucks.length; i++) {
            if (arrTrucks[i] != null && arrTrucks[i].equals(auto)) {
                arrTrucks[i] = null;
                trucksPlaces++;
            }
        }
    }

    /**
     * The method returns a Set of vehicles.
     * @return a Set of vehicles.
     */
    public Set<Auto> getVehicles() {
        Set<Auto> set = new HashSet<>();
        Collections.addAll(set, arrCars);
        Collections.addAll(set, arrTrucks);
        return set.stream().filter(Objects::nonNull).collect(Collectors.toSet());
    }
}
