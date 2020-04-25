package com.company.show;

import java.lang.Math;
import java.util.Arrays;



public class TransitCalculator {

    double numberOfDays;
    double numberOfIndividualRides;

    public TransitCalculator (int numOfDays, int numOfRides){
        numberOfDays = numOfDays;
        numberOfIndividualRides = numOfRides;
    }

    String[] fareOptions = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};

    Double[] farePrices = {2.75, 33.00, 127.00};


    public double unlimited7Price(){
        double numberOfWeeks = numberOfDays / 7;
        numberOfWeeks = Math.ceil(numberOfWeeks);
        double pricePerRide = numberOfWeeks * 33.0 / numberOfIndividualRides;
        return Math.round(pricePerRide * 100.0) / 100.0;
    }

    public double payPerRidePrice(){
        double pricePerRide = 2.75;
        return pricePerRide;
    }

    public double unlimited30Price(){
        double numberOfMonths = numberOfDays / 30;
        numberOfMonths = Math.ceil(numberOfMonths);
        double pricePerRide = numberOfMonths * 127.0 / numberOfIndividualRides;
        return Math.round(pricePerRide * 100.0) / 100.0;
    }

    public double[] getRidePrices(){
        double[] prices = new double[3];
        prices[0] = payPerRidePrice();
        prices[1] = unlimited7Price();
        prices[2] = unlimited30Price();
        return prices;
    }

    public String getBestFare() {
        double[] pricesArray = getRidePrices();
        double minPrice = pricesArray[0];
        int minPriceindex = 0;
        for (int i = 0; i < pricesArray.length; i++) {
            if (pricesArray[i] < minPrice) {
                minPriceindex = i;
            }
        }
        return "You should get the " + fareOptions[minPriceindex] + " option at $" + farePrices[minPriceindex] + " per ride.";
    }

    public static void main(String[] args){
        TransitCalculator calculateFare = new TransitCalculator(5,12);

        System.out.println(calculateFare.getBestFare());

    }
}