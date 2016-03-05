/**
 * Created by pisatel on 05.03.16.
 */
public class GlobalController {

    private ConsumptionState _current_state;
    private Analyzer _analyzer = new Analyzer();
    private Viewer _viewer = new Viewer();
    private TelegramBot _bot = new TelegramBot();

    public void mainLoop() throws Exception{
        while(true) {
            _current_state = _analyzer.getCurrentState();
            _viewer.sendCurrentState(_current_state);
            _bot.sendCurrentStateMessage(_current_state);
            Thread.sleep(1000); // sleep 1 sec

        }

    }
}
