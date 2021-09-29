package com.parkingLot;

public class ParkingLotSystem {

    private Object vehicle;

    public boolean park(Object vehicle) {
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public boolean unPark(Object vehicle) {
        if (this.vehicle.equals(vehicle)){
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
