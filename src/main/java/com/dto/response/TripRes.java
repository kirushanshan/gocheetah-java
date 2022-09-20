package com.dto.response;

public class TripRes {

    private int tripId;
    private String sourceLocation;
    private String destinationLocation;
    private String travelDateTime;
    private String branchName;

    private String driverName;

    private  String driverPhoneNumber;

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    private double tripFare;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getTravelDateTime() {
        return travelDateTime;
    }

    public void setTravelDateTime(String travelDateTime) {
        this.travelDateTime = travelDateTime;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getTripFare() {
        return tripFare;
    }

    public void setTripFare(double tripFare) {
        this.tripFare = tripFare;
    }
}
