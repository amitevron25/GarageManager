package shuki.engine.engine;

abstract public class Engine {
    //region Private Members
    protected float currentAmount;
    private final float maxAmount;
    private final String typeOfFuel;
    //endregion

    //region constructor
    protected Engine(float currentAmount, float maxAmount, String typeOfFuel) {
        this.maxAmount = maxAmount;
        this.typeOfFuel = typeOfFuel;
        this.currentAmount = currentAmount;
    }
    //endregion

    /**
     * input: a specific vehicle and how many hours you want to charge it and an input of which type of fuel to fuel
     * output: updates the current amount, if it accedes the max amount than the current amount is the max allowed,
     * in case the type of fuel does not match than the right kind of fuel will be the right one
     * @param howMuch indication of how much to fill
     */
    public abstract void chargingFueling(float howMuch);

    //region getters setters
    /**
     * @return the current amount of energy currently in the vehicle
     */
    public float getCurrentAmount() {
        return currentAmount;
    }

    /**
     * @return the max amount of energy possible in the vehicle
     */
    public float getMaxAmount() {
        return maxAmount;
    }

    /**
     * @return the type of fuel in the vehicle
     */
    public String getTypeOfFuel() {
        return (typeOfFuel);
    }
    //endregion

    /** Display Engine properties
     * @return the string builder
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("current amount: ");
        sb.append(currentAmount);
        sb.append(", ");
        sb.append("max amount: ");
        sb.append(maxAmount);
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }
}



