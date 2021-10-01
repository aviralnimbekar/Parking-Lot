package com.parkingLot;

public class ParkingLotOwner implements ParkingLotObservers {
    private boolean isLotFull;

    public boolean isLotFull() {
        return isLotFull;
    }

    @Override
    public void capacityIsFull() {
        isLotFull = true;
    }

    @Override
    public void spaceIsAvailable() {
    isLotFull = false;
    }
}