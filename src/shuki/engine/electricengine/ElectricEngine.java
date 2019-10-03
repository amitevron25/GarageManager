package shuki.engine.electricengine;
import shuki.engine.engine.Engine;

public class ElectricEngine extends Engine {

    //region constructor
    public ElectricEngine(float currentAmount, float maxAmount, String typeOfFuel) {
        super(currentAmount, maxAmount, typeOfFuel);
    }
    //endregion

    /**
     * input: a specific vehicle and how many hours you want to charge it
     * (type of fuel is not needed)
     * output: updates the current amount, if it accedes the max amount than the current amount is the max allowed
     * @param howMuch indication of how much to fill
     */
    public float chargingFueling(float howMuch) {
        return Math.min(howMuch + getCurrentAmount(), getMaxAmount());
    }
}
