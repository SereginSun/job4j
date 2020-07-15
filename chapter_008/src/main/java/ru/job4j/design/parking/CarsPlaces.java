package ru.job4j.design.parking;

/**
 * class CarsPlaces - class descendant Places.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class CarsPlaces extends Places {

    public CarsPlaces(int size) {
        super(size);
    }

    /**
     * The method checks the type of vehicle and the availability of free space for it.
     * If there is a place to park a car, it will park it.
     * @param auto - vehicle.
     * @return true if the vehicle is parked, otherwise it is a false.
     */
    @Override
    public boolean park(Auto auto) {
        boolean result = false;
        if (("single").equals(auto.getType()) && getFreePlaces() >= 1) {
            cars.add(auto);
            count++;
            result = true;
        } else if (("double").equals(auto.getType()) && getFreePlaces() >= 2) {
            cars.add(auto);
            count += 2;
            result = true;
        }
        return result;
    }

    /**
     * The method removes the vehicle from the parking lot by its number.
     * @param car - vehicle.
     * @return true if the vehicle is removes, otherwise it is a false.
     */
    public boolean unpark(Auto car) {
        cars.stream().filter(auto -> auto.getNumber().equals(car.getNumber()) && auto.getType().equals("single"))
                .findFirst().ifPresent(auto -> count--);
        cars.stream().filter(auto -> auto.getNumber().equals(car.getNumber()) && auto.getType().equals("double"))
                .findFirst().ifPresent(auto -> count -= 2);
        return cars.removeIf(auto -> auto.getNumber().equals(car.getNumber()));
    }
}
