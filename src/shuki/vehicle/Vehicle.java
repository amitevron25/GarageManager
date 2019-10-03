package shuki.vehicle;
import shuki.engine.engine.Engine;
import java.util.ArrayList;
abstract public class Vehicle {

    //region Private Members
    private final String ownerName;
    private final String ownerPhone;
    private       String carStatus;
    private final String modelName;
    private final String licenseNumber;
    private final float energyLeft;

    protected final ArrayList<VehicleWheel> myWheels;
    public final Engine myEngine;
    //endregion

    //region Constructors
    protected Vehicle(String ownerName, String ownerPhone, String modelName, String licenseNumber,
                      float energyLeft, ArrayList<VehicleWheel> myWheels, Engine myEngine) {

        this.ownerName      = ownerName;
        this.ownerPhone     = ownerPhone;
        this.carStatus      = "fixing";
        this.modelName      = modelName;
        this.licenseNumber  = licenseNumber;
        this.energyLeft     = energyLeft;
        this.myWheels       = myWheels;
        this.myEngine       = myEngine;
    }
    //endregion

    //region Getters & Setters
    /**
     * fixing(the default), payed or paying
     * @return the car status of the shuki.vehicle
     */
    public String getCarStatus() {
        return carStatus;
    }

    /**
     * the function changes the status of the shuki.vehicle: fixing(default), fixed, payed
     * @param newStatus holds the new status of the shuki.vehicle
     */
    public void setCarStatus(String newStatus) {
        this.carStatus = newStatus;
    }

    /**
     * @return the owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @return the owner phone
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @return the license number
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @return the energy left
     */
    public float getEnergyLeft() {
        return energyLeft;
    }

    public Engine getEngine(){
        System.out.println("change");

        return myEngine;
    }
    //endregion

    /*
        //region Builder
    public static class VehicleBuilder {

            private String ownerName;
            private String ownerPhone;
            private String carStatus;
            private String modelName;
            private String licenseNumber;
            private float energyLeft;

            protected ArrayList<VehicleWheel> myWheels;
            public Engine myEngine;


            public VehicleBuilder addOwnerName(String ownerName){
                this.ownerName = ownerName;
                return this;
            }

            public VehicleBuilder addOwnerPhone(String ownerPhone){
                this.ownerPhone = ownerPhone;
                return this;
            }

            public VehicleBuilder addCarStatus(String carStatus){
                this.carStatus = carStatus;
                return this;
            }

            public VehicleBuilder addModelName(String modelName){
                this.modelName = modelName;
                return this;
            }

            public VehicleBuilder addLicenseNumber(String licenseNumber){
                this.licenseNumber = licenseNumber;
                return this;
            }

            public VehicleBuilder addEnergyLeft(float energyLeft){
                this.energyLeft = energyLeft;
                return this;
            }

            public VehicleBuilder addMyWheels(ArrayList<VehicleWheel> myWheels){
                this.myWheels = myWheels;
                return this;
            }

            public VehicleBuilder addMyEngine(Engine myEngine){
                this.myEngine = myEngine;
                return this;
            }

            public VehicleBuilder build(){

                return new VehicleBuilder();
            }

        }
        //endregion
    */

    /** Display Vehicle properties
     * @return the string builder
     */
    public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append("license num: ");
            sb.append(licenseNumber);
            sb.append(", ");
            sb.append("model name: ");
            sb.append(modelName);
            sb.append(", ");
            sb.append("owner name: ");
            sb.append(ownerName);
            sb.append(", ");
            sb.append("car status: ");
            sb.append(carStatus);
            sb.append(System.getProperty("line.separator"));
            sb.append(myWheels);
            sb.append(System.getProperty("line.separator"));
            sb.append(myEngine);

            return (sb.toString());
        }
    }


