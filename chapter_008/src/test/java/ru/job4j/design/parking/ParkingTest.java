package ru.job4j.design.parking;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        Auto aCar = BaseAuto.car("н321вн36", 1);
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        assertEquals(BaseAuto.car("н321вн36", 1), aCar);
        assertEquals(BaseAuto.truck("к876хх136", 2), aTruck);
    }

    @Test
    public void when1CarParkToCarsPlaces() {
        Auto aCar = BaseAuto.car("н321вн36", 1);
        Parking aPark = new Parking(1, 1);
        aPark.park(aCar);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aCar);
        assertThat(result, is(expected));
    }

    @Test
    public void when1TruckParkToCarsPlaces() {
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        Parking aPark = new Parking(2, 0);
        aPark.park(aTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(0));
    }

    @Test
    public void whenParkingCarAndTruckToCarsPlaces() {
        Auto aCar = BaseAuto.car("н321вн36", 1);
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        Parking aPark = new Parking(3, 0);
        aPark.park(aCar);
        aPark.park(aTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aCar, aTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(0));
    }

    @Test
    public void whenParking3CarAnd2Truck() {
        Auto aCar = BaseAuto.car("н321вн36", 1);
        Auto bCar = BaseAuto.car("н322вн36", 1);
        Auto cCar = BaseAuto.car("н323вн36", 1);
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        Auto bTruck = BaseAuto.truck("к877хх136", 2);
        Parking aPark = new Parking(4, 1);
        aPark.park(aCar);
        aPark.park(aTruck);
        aPark.park(bTruck);
        aPark.park(bCar);
        aPark.park(cCar);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aTruck, bTruck, aCar, bCar);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(0));
    }

    @Test
    public void whenParking2CarsToCarsPlacesAndUnparking1Car() {
        Auto firstCar = BaseAuto.car("н321вн36", 1);
        Auto secondCar = BaseAuto.car("н321вн136", 1);
        Parking aPark = new Parking(2, 0);
        aPark.park(secondCar);
        aPark.park(firstCar);
        aPark.unpark(secondCar);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstCar);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(1));
    }

    @Test
    public void whenParking1TruckAndUnparkFromTrucksPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136", 2);
        Auto secondTruck = BaseAuto.truck("к877хх136", 2);
        Parking aPark = new Parking(0, 2);
        aPark.park(secondTruck);
        aPark.park(firstTruck);
        aPark.unpark(secondTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(1));
    }

    @Test
    public void whenParkingTrucksAndUnparkFromCarsPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136", 2);
        Auto secondTruck = BaseAuto.truck("к877хх136", 2);
        Auto thirdTruck = BaseAuto.truck("к878хх136", 2);
        Parking aPark = new Parking(7, 0);
        aPark.park(firstTruck);
        aPark.park(secondTruck);
        aPark.park(thirdTruck);
        aPark.unpark(secondTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstTruck, thirdTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(3));
    }

    @Test
    public void whenTrucksPlacesIsFullThanParkingTruckToCarsPlaces() {
        Auto firstTruck = BaseAuto.truck("к876хх136", 2);
        Auto secondTruck = BaseAuto.truck("к877хх136", 2);
        Auto thirdTruck = BaseAuto.truck("к878хх136", 2);
        Parking aPark = new Parking(3, 2);
        aPark.park(firstTruck);
        aPark.park(secondTruck);
        aPark.park(thirdTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstTruck, secondTruck, thirdTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(1));
    }

    @Test
    public void whenParkingCarsAndTrucksThanUnparkAndGetSetAuto() {
        Parking aPark = new Parking(4, 2);
        Auto firstTruck = BaseAuto.truck("к876хх136", 2);
        Auto secondTruck = BaseAuto.truck("к877хх136", 2);
        Auto thirdTruck = BaseAuto.truck("к878хх136", 2);
        Auto firstCar = BaseAuto.car("н321вн36", 1);
        Auto secondCar = BaseAuto.car("н322вн136", 1);
        aPark.park(firstTruck);
        aPark.park(firstCar);
        aPark.park(thirdTruck);
        aPark.park(secondTruck);
        aPark.park(secondCar);
        aPark.unpark(firstTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstCar, thirdTruck, secondTruck, secondCar);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(1));
    }

    @Test
    public void whenParkingThanAllPlacesIsFull() {
        Parking aPark = new Parking(2, 2);
        Auto firstTruck = BaseAuto.truck("к876хх136", 2);
        Auto secondTruck = BaseAuto.truck("к877хх136", 2);
        Auto thirdTruck = BaseAuto.truck("к878хх136", 2);
        Auto firstCar = BaseAuto.car("н321вн36", 1);
        Auto secondCar = BaseAuto.car("н322вн136", 1);
        aPark.park(firstTruck);
        aPark.park(firstCar);
        aPark.park(secondTruck);
        aPark.park(secondCar);
        aPark.park(thirdTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(firstTruck, firstCar, secondTruck, secondCar);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(0));
    }

    @Test
    public void whenParkingBusToTrucksPlaces() {
        Parking aPark = new Parking(2, 2);
        Auto aBus = BaseAuto.bus("н123ор36", 3);
        aPark.park(aBus);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aBus);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(2));
    }

    @Test
    public void whenParking1Bus1TruckAndUnpark1Bus() {
        Auto aBus = BaseAuto.bus("ан1077в136", 6);
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        Parking aPark = new Parking(4, 3);
        aPark.park(aBus);
        aPark.park(aTruck);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aBus, aTruck);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(2));
    }

    @Test
    public void whenParking1Bus1Truck1CarAndUnparking1Bus1Truck() {
        Auto aBus = BaseAuto.bus("ан1077в136", 9);
        Auto aTruck = BaseAuto.truck("к876хх136", 2);
        Auto aCar = BaseAuto.car("н321вн36", 1);
        Parking aPark = new Parking(10, 3);
        aPark.park(aBus);
        aPark.park(aTruck);
        aPark.park(aCar);
        aPark.unpark(aTruck);
        aPark.unpark(aBus);
        Set<Auto> result = aPark.getVehicles();
        Set<Auto> expected = Set.of(aCar);
        assertThat(result, is(expected));
        assertThat(aPark.getFreePlaces(), is(12));
    }
}
