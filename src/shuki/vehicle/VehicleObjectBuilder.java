package shuki.vehicle;

import shuki.engine.electricengine.ElectricEngine;
import shuki.engine.engine.Engine;
import shuki.engine.fuelengine.FuelEngine;
import shuki.typeofvehicles.car.Car;
import shuki.typeofvehicles.motorcycle.Motorcycle;
import shuki.typeofvehicles.truck.Truck;

import java.util.ArrayList;

public class VehicleObjectBuilder {

    public Motorcycle createFuelMotorcycle(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                           String manufactureName, float energyLeft, float currentAirPressure, float currentAmount,
                                           String licenseType, int motorVolume) {
        Engine engine = new FuelEngine(currentAmount, 7.2f, "Octan95");
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 33f, 2));
        }

        return new Motorcycle(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, licenseType, motorVolume);
    }

    public Motorcycle createElectricMotorcycle(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                               String manufactureName, float energyLeft, float currentAirPressure, float currentAmount,
                                               String licenseType, int motorVolume) {
        Engine engine = new ElectricEngine(currentAmount ,2.4f, "");
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 33f, 2));
        }

        return new Motorcycle(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, licenseType, motorVolume);
    }

    public Car createFuelCar(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                             String manufactureName, float energyLeft, float currentAirPressure, float currentAmount,
                             String carColour, int numberOfDoors) {
        Engine engine = new FuelEngine(currentAmount, 44f, "Octan98");
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 27f, 4));
        }

        return new Car(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, carColour, numberOfDoors);
    }

    public Car createElectricCar(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                 String manufactureName, float energyLeft, float currentAirPressure, float currentAmount,
                                 String carColour, int numberOfDoors) {
        Engine engine = new ElectricEngine(currentAmount, 3.2f, "");
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 27f, 4));
        }

        return new Car(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, carColour, numberOfDoors);
    }

    public Truck createTruck(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                             String manufactureName, float energyLeft, float currentAirPressure, float currentAmount,
                             int isDangerous, int maxPayload) {
        Engine engine = new FuelEngine(currentAmount, 180f, "Solar");
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 23f, 14));
        }

        return new Truck(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, isDangerous, maxPayload);
    }
}


