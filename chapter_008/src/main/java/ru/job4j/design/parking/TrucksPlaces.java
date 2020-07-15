package ru.job4j.design.parking;

/**
 * class TrucksPlaces - class descendant Places.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class TrucksPlaces extends Places {

    public TrucksPlaces(int size) {
        super(size);
    }

    /**
     * The method checks the type of vehicle and the availability of free space for it.
     * If there is a place to park a car, it will park it.
     * @param truck - vehicle.
     * @return true if the vehicle is parked, otherwise it is a false.
     */
    @Override
    public boolean park(Auto truck) {
        boolean result = false;
        if (("double").equals(truck.getType()) && getFreePlaces() >= 1) {
            cars.add(truck);
            count++;
            result = true;
        }
        return result;
    }

    /**
     * The method removes the vehicle from the parking lot by its number.
     * @param truck - vehicle.
     * @return true if the vehicle is removes, otherwise it is a false.
     */
    public boolean unpark(Auto truck) {
        cars.stream().filter(auto -> auto.getNumber().equals(truck.getNumber()) && auto.getType().equals("double"))
                .findFirst().ifPresent(auto -> count--);
        return cars.removeIf(auto -> auto.getNumber().equals(truck.getNumber()));
    }
}
