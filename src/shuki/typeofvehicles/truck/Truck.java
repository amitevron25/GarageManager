package shuki.typeofvehicles.truck;
import shuki.engine.engine.Engine;
import shuki.vehicle.Vehicle;
import shuki.vehicle.VehicleWheel;

import java.util.ArrayList;


public class Truck extends Vehicle {
    //region Private Members
    private final int isDangerous;
    private final int maxPayload;
    //endregion

    //region constructor
    public Truck(String ownerName, String ownerPhone, String modelName, String licenseNumber,
                 float energyLeft, ArrayList<VehicleWheel> myWheels, Engine myEngine, int isDangerous, int maxPayload) {
        super(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, myWheels, myEngine);
        this.isDangerous = isDangerous;
        this.maxPayload = maxPayload;
    }
    //endregion

    //region getter setter
    /**
     * @return the max payload of a truck
     */
    public int getMaxPayload() {
        return maxPayload;
    }

    /**
     * @return the dangerous status of a truck
     */
    public int getIsDangerous() {
        return isDangerous;
    }
    //endregion

    /** Display Vehicle properties
     * @return the string builder
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("max payload: ");
        sb.append(maxPayload);
        sb.append(", ");
        sb.append("is dangerous: ");
        sb.append(isDangerous);

        return (sb.toString());
    }
}