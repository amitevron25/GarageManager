package shuki.vehicle;

public class VehicleWheel {

    //region Private Members
    private final String manufactureName;
    private float currentAirPressure;
    private final float maxAirPressure;
    private final int numberOfWheels;
    //endregion

    //region constructor
    public VehicleWheel(String manufactureName, float currentAirPressure, float maxAirPressure, int numberOfWheels) {
        this.manufactureName = manufactureName;
        this.currentAirPressure = currentAirPressure;
        this.maxAirPressure = maxAirPressure;
        this.numberOfWheels = numberOfWheels;
    }
    //endregion

    //region getter setter
    /**
     * @return the current air pressure in the shuki.vehicle
     */
    protected float getCurrentAirPressure(){
        return currentAirPressure;
    }

    /**
     * @return the max air pressure possible in the shuki.vehicle
     */
    protected float getMaxAirPressure(){
        return maxAirPressure;
    }

    /**
     * @param currentAirPressure the current air pressure in the wheels
     */
    public void setCurrentAirPressure(float currentAirPressure) {
        this.currentAirPressure = currentAirPressure;
    }

    /**
     * @param aAddedAirPressure new air pressure in the shuki.vehicle
     */
    protected float addedAirPressure(float aAddedAirPressure){
        return Math.min(maxAirPressure, aAddedAirPressure + currentAirPressure);
    }

    /**
     *
     * @return the manufacture name of the wheel
     */
    public String getManufactureName() {
        return manufactureName;
    }

    /**
     * @return the number of wheels in the shuki.vehicle
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    //endregion

    /** Display wheel properties
     * @return the string builder
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("manufacture name: ");
        sb.append(manufactureName);
        sb.append(", current air pressure: ");
        sb.append(currentAirPressure);
        sb.append(", max Air Pressure: ");
        sb.append(maxAirPressure);
        sb.append(", number Of Wheels: ");
        sb.append(numberOfWheels);
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }
}
