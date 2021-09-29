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

    public boolean unPark(Object vehicle) throws ParkingLotException {
        try {
            if (this.vehicle.equals(vehicle)) {
                this.vehicle = null;
                return true;
            }
        } catch (NullPointerException e) {
            throw new ParkingLotException("No Vehicle Parked to Unpark");
        }
        return false;
    }
}
