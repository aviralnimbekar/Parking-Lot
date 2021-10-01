package com.parkingLot;

public class AirPostSecurity implements ParkingLotObservers{
    private boolean isLotFull;

    public boolean isLotFull() {
        return isLotFull;
    }

    @Override
    public void capacityIsFull() {
        isLotFull = true;
    }
}
