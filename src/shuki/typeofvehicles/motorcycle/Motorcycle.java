package shuki.typeofvehicles.motorcycle;
import shuki.engine.engine.Engine;
import shuki.vehicle.Vehicle;
import shuki.vehicle.VehicleWheel;

import java.util.ArrayList;

public class Motorcycle extends Vehicle {
    //region Private Members
    private final String licenseType;
    private final int motorVolume;
    //endregion

    //region constructor
    public Motorcycle(String ownerName, String ownerPhone, String modelName, String licenseNumber, float energyLeft,
                      ArrayList<VehicleWheel> myWheels, Engine myEngine, String licenseType, int motorVolume) {
        super(ownerName, ownerPhone, modelName, licenseNumber, energyLeft, myWheels, myEngine);
        this.licenseType = licenseType;
        this.motorVolume = motorVolume;
    }
    //endregion

    //region getter setter
    /**
     * @return the license type of shuki.vehicle:
     * A1, A3, B1 or C
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * @return the volume of a motor
     */
    public int getMotorVolume() {
        return motorVolume;
    }
    //endregion

    /** Display Vehicle properties
     * @return the string builder
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("license type: ");
        sb.append(licenseType);
        sb.append(", ");
        sb.append("motor volume: ");
        sb.append(motorVolume);
        return sb.toString();
    }
}
