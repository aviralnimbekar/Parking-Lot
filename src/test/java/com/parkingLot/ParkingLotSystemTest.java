package com.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {

    Object vehicle;
    ParkingLotSystem parkingLotSystem;
    ParkingLotOwner owner;
    @BeforeEach
    void setUp() {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem(1);
        owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
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
        Object anOtherVehicle = new Object();
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.park(anOtherVehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.LOT_FULL, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        parkingLotSystem.unPark(vehicle);
        boolean isUnParked = parkingLotSystem.isVehicleUnParked();
        Assertions.assertTrue(isUnParked);
    }

    @Test
    void givenAVehicle_WhenNotUnParked_ShouldReturnUnparkingFailMessage() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.unPark(null);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.NOT_UNPARKED, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenNoVehicle_WhenNotUnParked_ShouldReturnNoVehicleAvailableMessage() {
        try {
            parkingLotSystem.unPark(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.NO_VEHICLE, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenUnparkAnotherVehicle_ShouReturnDiffVehicleMessage() throws ParkingLotException {
        Object anOtherVehicle = new Object();
        parkingLotSystem.park(vehicle);
        try {
            parkingLotSystem.unPark(anOtherVehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals(ExceptionType.DIFF_VEHICLE, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenWhenParkingLotIsFull_ShouldInformTheOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
        try {
            parkingLotSystem.park(vehicle);
        } catch (ParkingLotException e) {
            boolean isFull = owner.isLotFull();
            Assertions.assertTrue(isFull);
        }
    }

    @Test
    void givenWhenParkingLotIsNotFull_ShouldInformOwner() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
        boolean isFull = owner.isLotFull();
        Assertions.assertFalse(isFull);
    }
}