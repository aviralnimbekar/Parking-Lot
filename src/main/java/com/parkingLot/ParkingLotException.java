package com.parkingLot;

public class ParkingLotException extends Exception {

    ExceptionType type;

    public ParkingLotException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
