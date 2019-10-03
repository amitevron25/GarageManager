package shuki.engine.fuelengine;
import shuki.engine.engine.Engine;

public class FuelEngine extends Engine {

    //region constructor
    public FuelEngine(float currentAmount, float maxAmount, String typeOfFuel) {
        super(currentAmount, maxAmount, typeOfFuel);
    }
    //endregion

    /**
     * input: a specific vehicle and how many hours you want to charge it and an input of which type of fuel to fuel
     * output: updates the current amount, if it accedes the max amount than the current amount is the max allowed,
     * in case the type of fuel does not match than the right kind of fuel will be the right one
     * @param howMuch indication of how much to fill
     */
    public float chargingFueling(float howMuch) {

        return Math.min((howMuch + getCurrentAmount()), getMaxAmount());
    }
}