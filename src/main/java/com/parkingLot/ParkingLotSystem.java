package com.parkingLot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParkingLotSystem {

    private final List<Object> vehicles;
    private final List<ParkingLotObservers> observers;
    private int actualCapacity;

    public ParkingLotSystem(int capacity) {
        this.vehicles = new LinkedList<>();
        this.observers = new ArrayList<>();
        this.actualCapacity = capacity;
    }

    public void registerObservers(ParkingLotObservers observer) {
        this.observers.add(observer);
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (isVehicleParked(vehicle))
            throw new ParkingLotException(ExceptionType.ALREADY_PARKED, "Vehicle is already Parked");
        if (this.vehicles.size() == this.actualCapacity)
            throw new ParkingLotException(ExceptionType.LOT_FULL, "Lot is already full");
        this.vehicles.add(vehicle);
        if (this.vehicles.size() == this.actualCapacity)
           observers.forEach(ParkingLotObservers::capacityIsFull);
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicles.contains(vehicle);
    }

    public void unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null)
            throw new ParkingLotException(ExceptionType.NO_VEHICLE, "Please enter valid Vehicle");
        if (this.vehicles.size() == 0)
            throw new ParkingLotException(ExceptionType.NO_VEHICLE, "No Vehicle Parked to Unpark");
        if (!this.vehicles.contains(vehicle))
            throw new ParkingLotException(ExceptionType.DIFF_VEHICLE, "This is not your Vehicle");
        this.vehicles.remove(vehicle);
    }

    public boolean isVehicleUnParked(Object vehicle) {
        return !this.vehicles.contains(vehicle);
    }
}
