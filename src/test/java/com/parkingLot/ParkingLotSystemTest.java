package com.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {

    Object vehicle;
    ParkingLotSystem parkingLotSystem;

    @BeforeEach
    void setUp() {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem(1);
    }

    @Test
    void givenAVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
        Assertions.assertTrue(isParked);
    }

    @Test
    void givenAVehicle_WhenAlreadyParked_ShouldReturnAlreadyParkedMessage() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.ALREADY_PARKED, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenParkedAnotherVehicle_ShouldReturnLotFullMessage() throws ParkingLotException {
        Object vehicle2 = new Object();
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.park(vehicle2);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.LOT_FULL, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean isUnParked = parkingLotSystem.isVehicleUnParked(vehicle);
        Assertions.assertTrue(isUnParked);
    }

    @Test
    void givenAVehicle_WhenNotUnParked_ShouldReturnNoVehicleAvailableMessage() {
        try {
            parkingLotSystem.unPark(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.NO_VEHICLE, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenNoVehicle_WhenNotUnParked_ShouldReturnNotValidVehicleMessage() {
        try {
            parkingLotSystem.unPark(null);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.NO_VEHICLE, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenUnparkAnotherVehicle_ShouReturnDiffVehicleMessage() throws ParkingLotException {
        Object vehicle2 = new Object();
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.unPark(vehicle2);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.DIFF_VEHICLE, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenWhenParkingLotIsFull_ShouldInformTheOwner() throws ParkingLotException {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerObservers(owner);
        parkingLotSystem.park(vehicle);
        boolean isFull = owner.isLotFull();
        Assertions.assertTrue(isFull);
    }

    @Test
    void givenWhenParkingLotIsFullWhenCapacityIs2_ShouldInformTheOwner() throws ParkingLotException {
        Object vehicle2 = new Object();
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerObservers(owner);
        parkingLotSystem.setCapacity(2);
        parkingLotSystem.park(vehicle);
        parkingLotSystem.park(vehicle2);
        boolean isFull = owner.isLotFull();
        Assertions.assertTrue(isFull);
    }

    @Test
    void givenWhenParkingLotIsNotFull_ShouldInformOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerObservers(owner);
        boolean isFull = owner.isLotFull();
        Assertions.assertFalse(isFull);
    }

    @Test
    void givenCapacityIs2_ShouldAbleToPark2Vehicle() throws ParkingLotException {
        Object vehicle2 = new Object();
        parkingLotSystem.setCapacity(2);
        parkingLotSystem.park(vehicle);
        parkingLotSystem.park(vehicle2);
        boolean isParked1 = parkingLotSystem.isVehicleParked(vehicle);
        boolean isParked2 = parkingLotSystem.isVehicleParked(vehicle2);
        Assertions.assertTrue(isParked1 && isParked2);
    }

    @Test
    void givenWhenParkingLotIsFull_ShouldInformSecurity() throws ParkingLotException {
        AirPostSecurity airPostSecurity = new AirPostSecurity();
        parkingLotSystem.registerObservers(airPostSecurity);
        parkingLotSystem.park(vehicle);
        boolean isFull = airPostSecurity.isLotFull();
        Assertions.assertTrue(isFull);
    }

    @Test
    void givenWhenParkingLotIsNotFull_ShouldSecurity() {
        AirPostSecurity airPostSecurity = new AirPostSecurity();
        parkingLotSystem.registerObservers(airPostSecurity);
        boolean isFull = airPostSecurity.isLotFull();
        Assertions.assertFalse(isFull);
    }

    @Test
    void givenWhenParkingLotHasSpace_ShouldInformTheOwner() throws ParkingLotException {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerObservers(owner);
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean isFull = owner.isLotFull();
        Assertions.assertFalse(isFull);
    }
}