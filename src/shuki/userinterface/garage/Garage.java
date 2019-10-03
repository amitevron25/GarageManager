package shuki.userinterface.garage;
import shuki.engine.engine.Engine;
import shuki.typeofvehicles.car.Car;
import shuki.typeofvehicles.motorcycle.Motorcycle;
import shuki.typeofvehicles.truck.Truck;
import shuki.vehicle.GarageManager;
import shuki.vehicle.VehicleObjectBuilder;
import shuki.vehicle.VehicleWheel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Garage {

    public static void main(String[] args) {

        GarageManager management = GarageManager.INSTANCE;
/*do {

}while (int checkCases != -1)*/
        int checkCases = 0;
        System.out.println("this will keep going until you enter -1");
        while (checkCases != -1) {
            System.out.println("1: add new vehicle to Garage");
            System.out.println("2: print license numbers of vehicles in Garage");
            System.out.println("3: change car status of a vehicle in Garage");
            System.out.println("4: inflate air pressure in wheel to Max");
            System.out.println("5: fuel vehicle run by gas");
            System.out.println("6: charge electric vehicle");
            System.out.println("7: print full spec of vehicle");

            Scanner input = new Scanner(System.in);
            checkCases = input.nextInt();

            switch (checkCases) {
                case 1:
                    decidingWhatVehicle(management);
                    break;
                //region print license numbers
                case 2:
                    try {
                        int howToSort = 0;
                        System.out.println("please enter 1 for unfiltered by car status and 2 for filtered");
                        int howToFilter = input.nextInt();
                        if (2 == howToFilter){
                            System.out.println("how to sort?");
                            System.out.println("1: fixing");
                            System.out.println("2: payed");
                            System.out.println("3: fixed");
                            howToSort = input.nextInt();
                        }
                        management.showLicenseList(howToFilter, howToSort);
                    }catch (InputMismatchException e){
                        System.out.println("not the correct input");
                    }
                    break;
                //endregion
                //region change car status
                case 3:
                    System.out.println("please enter license number");
                    String searchLicenseNumber = input.next();
                    System.out.println("please enter new car status");
                    String newCarStatus = input.next();

                    management.changeCarStatus(searchLicenseNumber, newCarStatus);
                    break;
                //endregion
                //region max air pressure
                case 4:
                    System.out.println("please enter license number to put max air pressure in");
                    String searchLicenseNumber2 = input.next();
                    System.out.println("please enter which wheel to change");
                    int whichWheel = input.nextInt();

                    management.setsAirPressureMax(searchLicenseNumber2, whichWheel);
                    break;
                //endregion
                //region fuel vehicle
                case 5:
                    System.out.println("please enter license number to fuel vehicle");
                    String searchLicenseNumber4 = input.next();
                    System.out.println("please enter how many liters to add");
                    float howMuch = input.nextFloat();

                    management.fuelingOfCar(searchLicenseNumber4, howMuch);
                    break;
                //endregion
                //region charge vehicle
                case 6:
                    System.out.println("please enter license number to charge vehicle");
                    String searchLicenseNumber5 = input.next();
                    System.out.println("please enter how many hours to add");
                    float howMuch2 = input.nextFloat();

                    management.chargingOfCar(searchLicenseNumber5, howMuch2);
                    break;
                //endregion
                //region spec for vehicle
                case 7:
                    System.out.println("please enter license number to get spec for");
                    String searchLicenseNumber3 = input.next();

                    management.printsCarSpec(searchLicenseNumber3);
                    break;
                //endregion
            }
        }
    }

    /**
     * input: receive an object of type garage manager and a type of vehicle:
     * 1 - regular motorcycle 2 - electric motorcycle 3- regular car 4- electric car 5- truck
     * receive inputs from the user of license number, owner name, owner phone, model name, manufacture of wheels,
     * energy left, current air pressure in wheels, current amount of energy in vehicle
     * output: sends the parameters to function that creates a new shuki.vehicle
     * @param management an object of type garage manager
     * @param typeOfVehicle different types of vehicles like motorcycle fuel/electric, car fuel/electric and truck
     */
    private static void loadingNewVehicle (GarageManager management,int typeOfVehicle){

        Scanner in = new Scanner(System.in);
        System.out.println("please enter license number");
        String licenseNumber = in.next();

        if (management.validationOfLicenseNumber(licenseNumber)){
            System.out.println("please enter owner name");
            String ownerName = in.next();
            System.out.println("please enter owner phone");
            String ownerPhone = in.next();
            System.out.println("please enter model name");
            String modelName = in.next();

            System.out.println("please enter manufacture name of wheels");
            String manufactureName = in.next();

            System.out.println("please enter energy left");
            float energyLeft = in.nextFloat();

            System.out.println("please enter current air pressure in wheels");
            float currentAirPressure = in.nextFloat();

            System.out.println("please enter current amount of energy in vehicle");
            float currentAmount = in.nextFloat();

            VehicleObjectBuilder objectBuilder = new VehicleObjectBuilder();

            management.createVehicle(typeOfVehicle, objectBuilder, licenseNumber, ownerName, ownerPhone, modelName,
                    manufactureName, energyLeft, currentAirPressure, currentAmount);
        }
    }

    /**
     *
     * @param management preforms garage manager actions
     */
    private static void decidingWhatVehicle (GarageManager management){
        Scanner input2 = new Scanner(System.in);
        System.out.println("please decide what vehicle to build:");
        System.out.println("1: build fuel motorcycle");
        System.out.println("2: build electric motorcycle");
        System.out.println("3: build fuel car");
        System.out.println("4: build electric car");
        System.out.println("5: build fuel truck");

        int whichVehicleToBuild = input2.nextInt();

        switch (whichVehicleToBuild){
            case 1:
                loadingNewVehicle(management, 1);
                break;
            case 2:
                loadingNewVehicle(management, 2);
                break;
            case 3:
                loadingNewVehicle(management, 3);
                break;
            case 4:
                loadingNewVehicle(management, 4);
                break;
            case 5:
                loadingNewVehicle(management, 5);
                break;
        }
    }
}