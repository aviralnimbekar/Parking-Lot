package com.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {

    @Test
    void givenAVehicle_WhenParked_ShouldReturnTrue() {
        Object vehicle = new Object();
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        boolean isParked = parkingLotSystem.park(vehicle);
        Assertions.assertTrue(isParked);
    }
}
