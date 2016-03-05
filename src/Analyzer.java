/**
 * Created by pisatel on 05.03.16.
 * For analysis all data from DeviceController
 * Can make analysis by time and by current data.
 *
 * Get devices controller to analyse consumption
 */
public class Analyzer {

    private final int LOW_BOUND = 100;
    private final int HIGHT_BOUND = 200;

    private int _current_consumption = 0;
    private DevicesController _devices_controller = new DevicesController();

    public Analyzer(DevicesController dc) {
        _devices_controller = dc;
    }

    //TODO: make grading
    public ConsumptionState getCurrentState() {
        _current_consumption = _devices_controller.getCurrentConsumption();
        ConsumptionState state;
        if (_current_consumption <= LOW_BOUND)
            state = ConsumptionState.LOW;
        else if (_current_consumption <= HIGHT_BOUND && _current_consumption > LOW_BOUND)
            state = ConsumptionState.HIGHT;
        else
            state = ConsumptionState.HIGHT;
        return state;
    }
}
