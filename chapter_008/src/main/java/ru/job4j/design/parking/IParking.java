package ru.job4j.design.parking;

public interface IParking {

    boolean park(Auto car);

    boolean unpark(Auto car);

    int getFreePlaces();
}
