/**
 * Created by pisatel on 05.03.16.
 */
public class Viewer implements Runnable{

    private volatile ConsumptionState _state;

    public Viewer() {
        _state = ConsumptionState.LOW;
    }

    public void showCurrentState(ConsumptionState current_state) {
        _state = current_state;
    }

    public void run() {
        while(true) {
            System.out.print(_state.toString() + "\n");
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex) {
                System.out.print(ex.getCause());
            }
        }
    }
}
