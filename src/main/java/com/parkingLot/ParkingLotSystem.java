package com.parkingLot;

public class ParkingLotSystem {

    private final int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null)
            this.vehicle = vehicle;
        else if (this.vehicle.equals(vehicle))
            throw new ParkingLotException(ExceptionType.ALREADY_PARKED, "Vehicle is already Parked");
        else
            throw new ParkingLotException(ExceptionType.LOT_FULL, "Lot is already full");
        currentCapacity++;
        if (this.currentCapacity == this.actualCapacity)
            owner.capacityIsFull();
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

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }
}
