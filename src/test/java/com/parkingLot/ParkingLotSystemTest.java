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
    void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        parkingLotSystem.park(vehicle);
        boolean isUnParked = parkingLotSystem.unPark(vehicle);
        Assertions.assertTrue(isUnParked);
    }
}