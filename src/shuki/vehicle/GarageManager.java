package shuki.vehicle;
import shuki.engine.engine.Engine;

import java.util.*;

public enum GarageManager {

    INSTANCE;

    enum CarStatus{
        NONE,
        FIXING,
        PAYED,
        FIXED
    }

    HashMap<String, Vehicle> vehicles = new HashMap<>();

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
                              float currentAirPressure, float currentAmount, String licenseType, int motorVolume,
                              String carColour, int numberOfDoors, int isDangerous, int maxPayload) {

        switch (typeOfVehicle) {
            case 1:
                vehicles.put(licenseNumber, objectBuilder.createFuelMotorcycle(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount, licenseType, motorVolume));
                break;
            case 2:
                vehicles.put(licenseNumber, objectBuilder.createElectricMotorcycle(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount, licenseType, motorVolume));
                break;
            case 3:
                vehicles.put(licenseNumber, objectBuilder.createFuelCar(licenseNumber, ownerName, ownerPhone, modelName,
                            manufactureName, energyLeft, currentAirPressure, currentAmount, carColour, numberOfDoors));
                break;
            case 4:
                vehicles.put(licenseNumber, objectBuilder.createElectricCar(licenseNumber, ownerName, ownerPhone,
                            modelName, manufactureName, energyLeft, currentAirPressure, currentAmount, carColour, numberOfDoors));
                break;
            case 5:
                vehicles.put(licenseNumber, objectBuilder.createTruck(licenseNumber, ownerName, ownerPhone, modelName,
                            manufactureName, energyLeft, currentAirPressure, currentAmount, isDangerous, maxPayload));
                break;
        }
    }

    /**
     * prints license number and car status with two input based options: 1 unfiltered and 2 filtered
     * input: in array list of class shuki.vehicle
     * output: prints to stdout license list with car status
     * @param howToFilter stores weather to filter or not
     */
    public void showLicenseList(int howToFilter) {

        for (Map.Entry<String, Vehicle> mapElement : vehicles.entrySet()) {
            String key = vehicles.get(mapElement.getKey()).getCarStatus();

            if (howToFilter == 0){
                System.out.println(mapElement.getKey() + " " + vehicles.get(mapElement.getKey()).getCarStatus());
            }
            CarStatus status = CarStatus.valueOf(key.toUpperCase());
            if (status.ordinal() == howToFilter){
                System.out.println(mapElement.getKey() + " " + vehicles.get(mapElement.getKey()).getCarStatus());
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

        Vehicle vehicleObj = vehicles.get(licenseNumber);
        if (vehicleObj == null) {
            System.out.println("the license number is not in the pool and will not be changed - try again");
        } else {
            vehicleObj.setCarStatus(newStatus);
        }
    }

    /**
     * changes the air pressure in the wheels to max
     * input: in array list of class shuki.vehicle, the license number that needs to be changed
     * @param licenseNumber license plate number
     */
    public void setsAirPressureMax(String licenseNumber) {

        Vehicle vehicleObj = vehicles.get(licenseNumber);
        if (vehicleObj == null) {
            System.out.println("the license number is not in the pool and will not be changed - try again");
            return;
        }

        for (VehicleWheel wheel : vehicleObj.myWheels) {
            wheel.addedAirPressure(wheel.getMaxAirPressure());
            System.out.println("the new air pressure is " + wheel.getCurrentAirPressure());
        }
    }

    /**
     * prints the car spec of a specific license number
     * input: in array list of class shuki.vehicle, the license number that needs to be changed
     * output: void
     * @param licenseNumber license plate number
     */
    public void printsCarSpec(String licenseNumber) {

        Vehicle vehicleObj = vehicles.get(licenseNumber);
        if (vehicleObj == null) {
            System.out.println("the license number is not in the garage - try again");
            return;
        }

        System.out.println(vehicles.get(licenseNumber));
    }

    /**
     * check to see if a license plate is inside the vehicle list
     * @param licenseNumber license plate number
     * @return -1 if the car is already in the garage or if not the index to which it needs to be inserted
     */
    public boolean validationOfLicenseNumber(String licenseNumber) {

        if (vehicles.containsKey(licenseNumber)) {
            System.out.println("the vehicle is already at the garage");
            vehicles.get(licenseNumber).setCarStatus("fixing");
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

        try {
            if (vehicles.containsKey(licenseNumber)) {
                Engine engine = vehicles.get(licenseNumber).getMyEngine();
                engine.chargingFueling(howMuch);

                System.out.println("the vehicle type of fuel is: " + vehicles.get(licenseNumber).myEngine.getTypeOfFuel());
                System.out.println("the new amount left is " + vehicles.get(licenseNumber).myEngine.getCurrentAmount());
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

        try {
            if (vehicles.containsKey(licenseNumber)) {
                Engine engine = vehicles.get(licenseNumber).getMyEngine();
                engine.chargingFueling(howMuch);
                System.out.println("the new amount left is " + vehicles.get(licenseNumber).myEngine.getCurrentAmount());
                System.out.println();
            }
        }catch (NullPointerException e){
            System.out.println("the license number is not in the garage - try again");
        }
    }
}

