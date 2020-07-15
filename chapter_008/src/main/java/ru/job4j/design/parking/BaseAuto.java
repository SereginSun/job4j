package ru.job4j.design.parking;

import java.util.Objects;

/**
 * class BaseAuto - describes the creation and behavior of a vehicle.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class BaseAuto implements Auto {
    private final String number;
    private String type;

    public BaseAuto(String number) {
        this.number = number;
    }

    /**
     * Factory method creating class object Car.
     * @param number vehicle number.
     * @return class object Car.
     */
    public static BaseAuto car(String number) {
        BaseAuto car = new BaseAuto(number);
        car.setType("single");
        return car;
    }

    /**
     * Factory method creating class object Truck.
     * @param number vehicle number.
     * @return class object Truck.
     */
    public static BaseAuto truck(String number) {
        BaseAuto truck = new BaseAuto(number);
        truck.setType("double");
        return truck;
    }

    public static BaseAuto bus(String number) {
        BaseAuto bus = new BaseAuto(number);
        bus.setType("double");
        return bus;
    }

    /**
     * The method sets the type of parking occupied by the vehicle.
     * @param type - the type of vehicle.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The method returns a number of vehicle.
     * @return a number of vehicle.
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * The method returns a type of parking occupied by the vehicle.
     * @return a type of vehicle.
     */
    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseAuto baseAuto = (BaseAuto) o;
        return type.equals(baseAuto.type)
                && Objects.equals(number, baseAuto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
