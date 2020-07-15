package ru.job4j.design.parking;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * class ParkingTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.07.2020
 */
public class ParkingTest {

    @Test
    public void whenEquality() {
        Auto aCar = BaseAuto.car("н321вн36");
        Auto aTruck = BaseAuto.truck("к876хх136");
        assertEquals(BaseAuto.car("н321вн36"), aCar);
        assertEquals(BaseAuto.truck("к876хх136"), aTruck);
    }

    @Test
    public void whenTestType() {
        assertEquals("single", BaseAuto.car("н321вн36").getType());
        assertEquals("double", BaseAuto.truck("к876хх136").getType());
    }

    @Test
    public void whenSizeOfParking() {
        CarsPlaces carsPlaces = new CarsPlaces(10);
        assertEquals(10, carsPlaces.getFreePlaces());
    }

    @Test
    public void when1CarParkToCarsPlaces() {
        Auto aCar = BaseAuto.car("н321вн36");
        CarsPlaces carsPlaces = new CarsPlaces(10);
        carsPlaces.park(aCar);
        assertEquals(9, carsPlaces.getFreePlaces());
    }

    @Test
    public void when1TruckParkToTrucksPlaces() {
        Auto aTruck = BaseAuto.truck("к876хх136");
        TrucksPlaces placesForTrucks = new TrucksPlaces(10);
        placesForTrucks.park(aTruck);
        assertEquals(9, placesForTrucks.getFreePlaces());
    }

    @Test
    public void when1CarUnparkFromCarsPlaces() {
        Auto firstCar = BaseAuto.car("н321вн36");
        Auto secondCar = BaseAuto.car("н321вн136");
        CarsPlaces carsPlaces = new CarsPlaces(10);
        carsPlaces.park(secondCar);
        carsPlaces.park(firstCar);
        carsPlaces.unpark(secondCar);
        assertEquals(9, carsPlaces.getFreePlaces());
    }

    @Test
    public void when1TruckUnparkFromTrucksPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136");
        Auto secondTruck = BaseAuto.truck("к877хх136");
        TrucksPlaces placesForTrucks = new TrucksPlaces(10);
        placesForTrucks.park(secondTruck);
        placesForTrucks.park(firstTruck);
        placesForTrucks.unpark(secondTruck);
        assertEquals(9, placesForTrucks.getFreePlaces());
    }

    @Test
    public void whenParkingTrucksAndUnparkFromCarsPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136");
        Auto secondTruck = BaseAuto.truck("к877хх136");
        Auto thirdTruck = BaseAuto.truck("к878хх136");
        CarsPlaces placesForCars = new CarsPlaces(6);
        placesForCars.park(firstTruck);
        placesForCars.park(secondTruck);
        placesForCars.park(thirdTruck);
        placesForCars.unpark(secondTruck);
        assertEquals(2, placesForCars.getFreePlaces());
    }

    @Test
    public void whenTrucksPlacesIsFullThanParkingTruckToCarsPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136");
        Auto secondTruck = BaseAuto.truck("к877хх136");
        Auto thirdTruck = BaseAuto.truck("к878хх136");
        Parking parking = new Parking(3, 2);
        parking.park(firstTruck);
        parking.park(secondTruck);
        parking.park(thirdTruck);
        assertEquals(1, parking.getFreePlaces());
    }

    @Test
    public void whenParkingCarsAndTrucksThanUnparkAndGetSetAuto() {
        Parking parking = new Parking(4, 2);
        Auto firstTruck = BaseAuto.truck("к876хх136");
        Auto secondTruck = BaseAuto.truck("к877хх136");
        Auto thirdTruck = BaseAuto.truck("к878хх136");
        Auto firstCar = BaseAuto.car("н321вн36");
        Auto secondCar = BaseAuto.car("н322вн136");
        parking.park(firstTruck);
        parking.park(firstCar);
        parking.park(thirdTruck);
        parking.park(secondTruck);
        parking.park(secondCar);
        parking.unpark(firstTruck);
        assertEquals(2, parking.getFreePlaces());
        assertEquals(Set.of(firstCar, secondCar), parking.getCars());
        assertEquals(Set.of(thirdTruck, secondTruck), parking.getTrucks());
    }

    @Test
    public void whenParkingThanAllPlacesIsFull() {
        Parking parking = new Parking(2, 2);
        Auto firstTruck = BaseAuto.truck("к876хх136");
        Auto secondTruck = BaseAuto.truck("к877хх136");
        Auto thirdTruck = BaseAuto.truck("к878хх136");
        Auto firstCar = BaseAuto.car("н321вн36");
        Auto secondCar = BaseAuto.car("н322вн136");
        parking.park(firstTruck);
        parking.park(firstCar);
        parking.park(secondTruck);
        parking.park(secondCar);
        parking.park(thirdTruck);
        assertEquals(0, parking.getFreePlaces());
        assertEquals(Set.of(secondTruck, thirdTruck), parking.getTrucks());
        assertEquals(Set.of(firstTruck), parking.getCars());
    }

    @Test
    public void whenParkingBus() {
        Parking parking = new Parking(2, 2);
        Auto bus = BaseAuto.bus("н123ор36");
        parking.park(bus);
        assertEquals(2, parking.getFreePlaces());
        assertEquals(Set.of(bus), parking.getCars());
    }
}
