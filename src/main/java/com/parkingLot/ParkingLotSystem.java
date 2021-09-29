package com.parkingLot;

public class ParkingLotSystem {

    private Object vehicle;

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null)
            this.vehicle = vehicle;
        else if (this.vehicle.equals(vehicle))
            throw new ParkingLotException(ExceptionType.ALREADY_PARKED, "Vehicle is already Parked");
        else
            throw new ParkingLotException(ExceptionType.LOT_FULL, "Lot is already full");
    }

    public boolean isParked(Object vehicle) {
        return this.vehicle.equals(vehicle);
    }

    public void unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            throw new ParkingLotException(ExceptionType.NOT_UNPARKED, "Vehicle Unparking failed");
        if (this.vehicle == null)
            throw new ParkingLotException(ExceptionType.NO_VEHICLE, "No Vehicle Parked to Unpark");
        if (!this.vehicle.equals(vehicle))
            throw new ParkingLotException(ExceptionType.DIFF_VEHICLE, "This is not your Vehicle");
        if (this.vehicle.equals(vehicle))
            this.vehicle = null;
    }

    public boolean isUnParked() {
        return this.vehicle == null;
    }
}
