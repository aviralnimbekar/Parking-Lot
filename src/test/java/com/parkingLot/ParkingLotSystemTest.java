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
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    void givenAVehicle_WhenParked_ShouldReturnTrue() {
        boolean isParked = parkingLotSystem.park(vehicle);
        Assertions.assertTrue(isParked);
    }

    @Test
    void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(vehicle);
        Assertions.assertFalse(isParked);
    }

    @Test
    void givenAVehicle_WhenParkedAnotherVehicle_ShouldReturnFalse() {
        Object anOtherVehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(anOtherVehicle);
        Assertions.assertFalse(isParked);
    }

    @Test
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }

    @Test
    void givenAVehicle_WhenNotUnParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(null);
        Assertions.assertFalse(isUnParked);
    }

    @Test
    void givenNoVehicle_WhenNotUnParked_ShouldReturnFalse() {
        try {
            parkingLotSystem.unPark(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("No Vehicle Parked to Unpark", e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void givenAVehicle_WhenUnparkAnotherVehicle_ShouReturnFalse() throws ParkingLotException {
        Object anOtherVehicle = new Object();
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(anOtherVehicle);
        Assertions.assertFalse(isUnParked);
    }
}