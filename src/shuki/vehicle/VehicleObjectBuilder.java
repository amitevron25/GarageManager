package shuki.vehicle;

import shuki.engine.engine.Engine;
import shuki.typeofvehicles.car.Car;
import shuki.typeofvehicles.motorcycle.Motorcycle;
import shuki.typeofvehicles.truck.Truck;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleObjectBuilder {


    public Motorcycle createFuelMotorcycle(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                           String manufactureName, float energyLeft, float currentAirPressure, float currentAmount) {
        ArrayList<VehicleWheel> wheels = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("please enter license type");
        String licenseType = input.next();
        System.out.println("please enter motor volume");
        int motorVolume = input.nextInt();

        Engine engine = new Engine(currentAmount, 7.2f, "Octan95") {
            @Override
            public float chargingFueling(float howMuch) {
                System.out.println("change");

                return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
            }
        };
        Motorcycle motorFuel = new Motorcycle(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels,
                                              engine, licenseType, motorVolume);
        for (int i = 0; i < 2; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 33f, 2));
        }
        motorFuel.myEngine.setCurrentAmount(currentAmount);

        return motorFuel;
    }

    public Motorcycle createElectricMotorcycle(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                               String manufactureName, float energyLeft, float currentAirPressure, float currentAmount) {
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter license type");
        String licenseType = input.next();
        System.out.println("please enter motor volume");
        int motorVolume = input.nextInt();

        Engine engine = new Engine(currentAmount, 2.4f, "electric car") {
            @Override
            public float chargingFueling(float howMuch) {
                return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
            }
        };
        Motorcycle motorElectric = new Motorcycle(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels,
                                                  engine, licenseType, motorVolume);
        for (int i = 0; i < 2; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 33f, 2));
        }
        motorElectric.myEngine.setCurrentAmount(currentAmount);

        return motorElectric;
    }

    public Car createFuelCar(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                             String manufactureName, float energyLeft, float currentAirPressure, float currentAmount) {
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter colour of car");
        String carColour = input.next();
        System.out.println("please enter number of doors");
        int numberOfDoors = input.nextInt();

        Engine engine = new Engine(currentAmount, 44f, "Octan98") {
            @Override
            public float chargingFueling(float howMuch) {

                return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
            }
        };
        Car carFuel = new Car(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, carColour, numberOfDoors);
        for (int i = 0; i < 4; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 27f, 4));
        }
        carFuel.myEngine.setCurrentAmount(currentAmount);

        return carFuel;
    }

    public Car createElectricCar(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                                 String manufactureName, float energyLeft, float currentAirPressure, float currentAmount) {
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter colour of car");
        String carColour = input.next();
        System.out.println("please enter number of doors");
        int numberOfDoors = input.nextInt();

        Engine engine = new Engine(currentAmount, 3.2f, "electric car") {
            @Override
            public float chargingFueling(float howMuch) {

                return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
            }
        };
        Car carElectric = new Car(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, carColour, numberOfDoors);
        for (int i = 0; i < 4; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 27f, 4));
        }
        carElectric.myEngine.setCurrentAmount(currentAmount);

        return carElectric;
    }

    public Truck createTruck(String licenseNumber, String ownerName, String ownerPhone, String modelName,
                             String manufactureName, float energyLeft, float currentAirPressure, float currentAmount) {
        ArrayList<VehicleWheel> wheels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter if truck is dangerous");
        int isDangerous = input.nextInt();
        System.out.println("please enter the max payload");
        int maxPayload = input.nextInt();

        Engine engine = new Engine(currentAmount, 180f, "Solar") {
            @Override
            public float chargingFueling(float howMuch) {

                return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
            }
        };
        Truck truck = new Truck(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, wheels, engine, isDangerous, maxPayload);
        for (int i = 0; i < 14; i++) {
            wheels.add(new VehicleWheel(manufactureName, currentAirPressure, 23f, 14));
        }
        truck.myEngine.setCurrentAmount(currentAmount);

        return truck;
    }
}


