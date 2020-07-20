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
    private final int size;

    public BaseAuto(String number, int size) {
        this.number = number;
        this.size = size;
    }

    /**
     * Factory method creating class object Car.
     * @param number vehicle number.
     * @param size vehicle size.
     * @return class object Car.
     */
    public static BaseAuto car(String number, int size) {
        return new BaseAuto(number, size);
    }

    /**
     * Factory method creating class object Truck.
     * @param number vehicle number.
     * @param size vehicle size.
     * @return class object Truck.
     */
    public static BaseAuto truck(String number, int size) {
        return new BaseAuto(number, size);
    }

    /**
     * Factory method creating class object Bus.
     * @param number vehicle number.
     * @param size vehicle size.
     * @return class object Bus.
     */
    public static BaseAuto bus(String number, int size) {
        return new BaseAuto(number, size);
    }

    /**
     * The method sets the type of parking occupied by the vehicle.
     * @param type - the type of vehicle.
     */
//    public void setType(String type) {
//        this.type = type;
//    }

    /**
     * The method returns a number of vehicle.
     * @return a number of vehicle.
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * The method returns a size of parking occupied by the vehicle.
     * @return a vehicle size.
     */
    @Override
    public int getSize() {
        return size;
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
        return size == baseAuto.size
                && Objects.equals(number, baseAuto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size);
    }
}
