package com.parkingLot;

public class ParkingLotOwner {
    private boolean isLotFull;

    public void capacityIsFull() {
        isLotFull = true;
    }

    public boolean isLotFull() {
        return isLotFull;
    }
}
