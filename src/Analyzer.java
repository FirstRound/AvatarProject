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
    private double _avg_consumption;
    private DevicesController _devices_controller = new DevicesController();

    public Analyzer(DevicesController dc) {
        _devices_controller = dc;
    }

    public void setAvgConsumption(double avg) {
        _avg_consumption = avg;
    }

    public ConsumptionState getAvgConsumptionState() {
        return gradeState((int)_avg_consumption);
    }

    public ConsumptionState getCurrentState() {
        _current_consumption = _devices_controller.getCurrentConsumption();
        _avg_consumption = (_avg_consumption + _current_consumption) / 2.0;
        return gradeState(_current_consumption);
    }

    //TODO: make grading
    private ConsumptionState gradeState(int value) {
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
