package com.example.nathapong.app76_masterlocationandgpsservices;


import android.location.Location;

public class TaxiManager {

    private Location destinationLocation;


    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }


    public float returnTheDistanceToDestinationLocationInMeters(Location currentLocation){

        if (currentLocation != null && destinationLocation != null){

            return currentLocation.distanceTo(destinationLocation);
        }
        else {
            return -100.0f;
        }
    }


    public String returnTheMilesBetweenCurrentLocationAndDestinationLocation
            (Location currentLocation, int metersPerMile){

        int miles = (int)(returnTheDistanceToDestinationLocationInMeters(currentLocation) / metersPerMile);

        if (miles == 1){
            return "1 Mile";
        }
        else if (miles > 1){
            return miles + "Miles";
        }
        else {
            return "No Miles";
        }
    }


    public String returnTheTimeLeftToGetToDestinationLocation
            (Location currentLocation, float milePerHour, int metersPerMile){

        float distanceInMeters = returnTheDistanceToDestinationLocationInMeters(currentLocation);

        float timeLeft = distanceInMeters / (milePerHour * metersPerMile);

        String timeResult = "";

        int timeLeftInHour = (int)timeLeft;


        if (timeLeftInHour == 1){
            timeResult += " 1 Hour ";
        }
        else if (timeLeftInHour > 1){
            timeResult += timeLeftInHour + " Hours ";
        }

        int minutesLeft = (int)((timeLeft - timeLeftInHour) * 60);


        if (minutesLeft ==1){
            timeResult += " 1 Minute ";
        }
        else if (minutesLeft > 1){
            timeResult += minutesLeft + " Minutes";
        }


        if (timeLeftInHour <= 0 && minutesLeft <= 0){
            timeResult = "Less than a minute left to get to the destination location";
        }

        return timeResult;
    }
}
