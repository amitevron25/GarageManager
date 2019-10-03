package shuki.typeofvehicles.car;
import shuki.engine.engine.Engine;
import shuki.vehicle.*;

import java.util.ArrayList;

public class Car extends Vehicle {
    //region Private Members
    private final String carColour;
    private final int numberOfDoors;
    //endregion

    //region constructor
    public Car(String ownerName, String ownerPhone, String modelName, String licenseNumber,
               float energyLeft, ArrayList<VehicleWheel> myWheels, Engine myEngine, String carColour, int numberOfDoors) {
        super(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, myWheels, myEngine);
        this.carColour = carColour;
        this.numberOfDoors = numberOfDoors;
    }
    //endregion

    //region getter setter
    /**
     * @return the colour of the car
     */
    public String getCarColour() {
        return carColour;
    }

    /**
     * @return the number of doors in the car
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    //endregion

    /** Display Vehicle properties
     * @return the string builder
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("car colour: ");
        sb.append(carColour);
        sb.append(", ");
        sb.append("number of doors: ");
        sb.append(numberOfDoors);

        return (sb.toString());
    }
}