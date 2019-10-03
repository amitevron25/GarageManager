package shuki.vehicle;
import shuki.engine.electricengine.ElectricEngine;
import shuki.engine.engine.Engine;
import shuki.engine.fuelengine.FuelEngine;
import shuki.typeofvehicles.car.Car;
import shuki.typeofvehicles.motorcycle.Motorcycle;
import shuki.typeofvehicles.truck.Truck;

import java.util.*;

public enum GarageManager {

    INSTANCE;

    HashMap<String, Vehicle> vehicle = new HashMap<>();

    /**
     *
     * @param typeOfVehicle indication of type of vehicle
     * @param objectBuilder an object of type vehicle object builder class
     * @param licenseNumber the license plate number
     * @param ownerName the owner name
     * @param ownerPhone the owner phone
     * @param modelName the model name
     * @param manufactureName the manufacture name
     * @param energyLeft the energy left
     * @param currentAirPressure the current air pressure in wheels
     * @param currentAmount the current amount of energy
     */
    public void createVehicle(int typeOfVehicle, VehicleObjectBuilder objectBuilder, String licenseNumber, String ownerName,
                              String ownerPhone, String modelName, String manufactureName, float energyLeft,
                              float currentAirPressure, float currentAmount) {

        switch (typeOfVehicle) {
            case 1:
                vehicle.put(licenseNumber, objectBuilder.createFuelMotorcycle(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount));
                break;
            case 2:
                vehicle.put(licenseNumber, objectBuilder.createElectricMotorcycle(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount));
                break;
            case 3:
                vehicle.put(licenseNumber, objectBuilder.createFuelCar(licenseNumber, ownerName, ownerPhone, modelName,
                            manufactureName, energyLeft, currentAirPressure, currentAmount));
                break;
            case 4:
                vehicle.put(licenseNumber, objectBuilder.createElectricCar(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount));
                break;
            case 5:
                vehicle.put(licenseNumber, objectBuilder.createTruck(licenseNumber, ownerName, ownerPhone, modelName,
                            manufactureName, energyLeft, currentAirPressure, currentAmount));
                break;
        }
    }

    /**
     * prints license number and car status with two input based options: 1 unfiltered and 2 filtered
     * input: in array list of class shuki.vehicle
     * output: prints to stdout license list with car status
     * @param howToFilter stores weather to filter or not
     */
    public void showLicenseList(int howToFilter, int howToSort) {

        if (1 == howToFilter) {
            for (Map.Entry<String, Vehicle> mapElement : vehicle.entrySet()) {
                System.out.println(mapElement.getKey() + " " + vehicle.get(mapElement.getKey()).getCarStatus());
            }

            System.out.println();
        } else if (2 == howToFilter) {
            for (Map.Entry<String, Vehicle> mapElement : vehicle.entrySet()) {
                if (vehicle.get(mapElement.getKey()).getCarStatus().equals("fixing") && 1 == howToSort ) {
                    System.out.println(mapElement.getKey() + " " + vehicle.get(mapElement.getKey()).getCarStatus());
                }
                if (vehicle.get(mapElement.getKey()).getCarStatus().equals("payed") && 2 == howToSort) {
                    System.out.println(mapElement.getKey() + " " + vehicle.get(mapElement.getKey()).getCarStatus());
                }
                if (vehicle.get(mapElement.getKey()).getCarStatus().equals("fixed") && 3 == howToSort) {
                    System.out.println(mapElement.getKey() + " " + vehicle.get(mapElement.getKey()).getCarStatus());
                }
            }
        }
    }

    /**
     * changes the car status to new status
     * input: in array list of class shuki.vehicle, the license number that needs to be changed, the new status
     * output: void
     * @param licenseNumber license plate number
     * @param newStatus stores the new status of the shuki.vehicle
     */
    public void changeCarStatus(String licenseNumber, String newStatus) {
        try {
            vehicle.get(licenseNumber).setCarStatus(newStatus);
        } catch (NullPointerException e) {
            System.out.println("the license number is not in the pool and will not be changed - try again");
        }
    }

    /**
     * changes the air pressure in the wheels to max
     * input: in array list of class shuki.vehicle, the license number that needs to be changed
     * @param licenseNumber license plate number
     * @param whichWheel indicates on which wheel to inflate
     */
    public void setsAirPressureMax(String licenseNumber, int whichWheel) {
        try {
            float maxIs = vehicle.get(licenseNumber).myWheels.get(whichWheel).getMaxAirPressure();
            vehicle.get(licenseNumber).myWheels.get(whichWheel).setCurrentAirPressure(
                    vehicle.get(licenseNumber).myWheels.get(whichWheel).addedAirPressure(maxIs));
            System.out.println("the new air pressure is " + vehicle.get(licenseNumber).myWheels.get(whichWheel).getCurrentAirPressure());
        } catch (NullPointerException e){
            System.out.println("the license number is not in the pool and will not be changed - try again");
        }
    }

    /**
     * prints the car spec of a specific license number
     * input: in array list of class shuki.vehicle, the license number that needs to be changed
     * output: void
     * @param licenseNumber license plate number
     */
    public void printsCarSpec(String licenseNumber) {
        try {
            if (!vehicle.get(licenseNumber).equals(licenseNumber)){
                System.out.println(vehicle.get(licenseNumber));
            }
        } catch (NullPointerException e){
            System.out.println("the license number is not in the garage - try again");
        }
    }

    /**
     * check to see if a license plate is inside the vehicle list
     * @param licenseNumber license plate number
     * @return -1 if the car is already in the garage or if not the index to which it needs to be inserted
     */
    public boolean validationOfLicenseNumber(String licenseNumber) {

        if (vehicle.containsKey(licenseNumber)) {
            System.out.println("the vehicle is already at the garage");
            vehicle.get(licenseNumber).setCarStatus("fixing");
            return false;
        } else {
            return true;
        }
    }

    /**
     * sends the parameters to fuelengine class to check computability of type of fuel and fill gas with howmuch
     * @param licenseNumber receive a license number to match
     * @param howMuch receive the input of how much to fuel
     */
    public void fuelingOfCar(String licenseNumber, float howMuch) {

        //TODO: why do you create a new engine instead of fuel engine of existing car


        try {

/*
            Engine engine = new FuelEngine(vehicle.get(licenseNumber).myEngine.getCurrentAmount(),
                    vehicle.get(licenseNumber).myEngine.getMaxAmount(),
                    vehicle.get(licenseNumber).myEngine.getTypeOfFuel());*/

            if (vehicle.containsKey(licenseNumber)) {
                Engine engine = vehicle.get(licenseNumber).getEngine();
                vehicle.get(licenseNumber).myEngine.setCurrentAmount(engine.chargingFueling(howMuch));

                System.out.println("the vehicle type of fuel is: " + vehicle.get(licenseNumber).myEngine.getTypeOfFuel());
                System.out.println("the new amount left is " + vehicle.get(licenseNumber).myEngine.getCurrentAmount());
                System.out.println();
            }
        }catch (NullPointerException e){
            System.out.println("the license number is not in the garage - try again");
        }


    }

    /**
     * sends the parameters to fuelengine class to fill gas with howmuch
     * @param licenseNumber receive a license number to match
     * @param howMuch receive the input of how much to fuel
     */
    public void chargingOfCar(String licenseNumber, float howMuch) {

        //TODO: why do you create a new engine instead of fuel engine of existing car

        try {


/*            Engine engine = new ElectricEngine(vehicle.get(licenseNumber).myEngine.getCurrentAmount(),
                    vehicle.get(licenseNumber).myEngine.getMaxAmount(),
                    vehicle.get(licenseNumber).myEngine.getTypeOfFuel());*/

            if (vehicle.containsKey(licenseNumber)) {
                Engine engine = vehicle.get(licenseNumber).getEngine();
                vehicle.get(licenseNumber).myEngine.setCurrentAmount(engine.chargingFueling(howMuch));
                System.out.println("the new amount left is " + vehicle.get(licenseNumber).myEngine.getCurrentAmount());
                System.out.println();
            }
        }catch (NullPointerException e){
            System.out.println("the license number is not in the garage - try again");
        }

    }
}

