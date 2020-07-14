package ru.job4j.design.parking;

import java.util.Set;

/**
 * class IParking - describes the interaction of a vehicle with parking places.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class Parking {
    private final IParking cars;
    private final IParking trucks;

    public Parking(int carsPlaces, int trucksPlaces) {
        this.cars = new CarsPlaces(carsPlaces);
        this.trucks = new TrucksPlaces(trucksPlaces);
    }

    /**
     * The method tells the client whether the vehicle can be parked.
     * @param auto - vehicle.
     */
    public void park(Auto auto) {
        if (cars.park(auto)) {
            System.out.printf("this auto with number %s parked to CarsPlaces successful!%n", auto.getNumber());
        } else if (trucks.park(auto)) {
            System.out.printf("this auto with number %s parked to CarsPlaces successful!%n", auto.getNumber());
        } else {
            System.out.printf("no free places%n");
        }
    }

    /**
     * The method returns the total number of free places.
     * @return the total number of free places.
     */
    public int getFreePlaces() {
        return cars.getFreePlaces() + trucks.getFreePlaces();
    }

    /**
     * The method removes the vehicle from the parking lot and tells the customer the number of this vehicle.
     * @param auto - vehicle.
     */
    public void unpark(Auto auto) {
        if (cars.unpark(auto) || trucks.unpark(auto)) {
            System.out.printf("this auto with number %s has left!%n", auto.getNumber());
        }
    }

    /**
     * The method returns a Set of vehicles parked in parking for car.
     * @return a Set of vehicles parked in parking for car.
     */
    public Set<Auto> getCars() {
        return cars.getAuto();
    }

    /**
     * The method returns a Set of vehicles parked in parking for trucks.
     * @return a Set of vehicles parked in parking for trucks.
     */
    public Set<Auto> getTrucks() {
        return trucks.getAuto();
    }
}
