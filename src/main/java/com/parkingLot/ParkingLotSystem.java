package com.parkingLot;

public class ParkingLotSystem {

    private Object vehicle;
    private final SecurityPerson securityPerson;

    public ParkingLotSystem(SecurityPerson securityPerson) {
        this.securityPerson = securityPerson;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null)
            this.vehicle = vehicle;
        else if (this.vehicle.equals(vehicle))
            throw new ParkingLotException(ExceptionType.ALREADY_PARKED, "Vehicle is already Parked");
        else
            throw new ParkingLotException(ExceptionType.LOT_FULL, "Lot is already full");
    }

    public boolean isVehicleParked(Object vehicle) {
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

    public boolean isVehicleUnParked() {
        return this.vehicle == null;
    }

    public boolean isLotFull() {
        return this.vehicle != null;
    }

    public void informSecPer(Object vehicle) {
        if (isLotFull())
            securityPerson.isLotFull(vehicle);
    }
}
