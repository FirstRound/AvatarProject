/**
 * Created by pisatel on 05.03.16.
 */
public class GlobalController {
    private ConsumptionState current_state;
    private Analyzer analyzer = new Analyzer();
    private Viewer viewer = new Viewer();
    private TelegramBot bot = new TelegramBot();

    public void mainLoop() throws Exception{
        //TODO: make main loop: analyseData/showResults/sendToTelegram
        while(true) {
            current_state = analyzer.getCurrentState();
            viewer.showCurrentState(current_state);
            bot.sendCurrentStateMessage(current_state);
            Thread.sleep(1000); // sleep 1 sec

        }

    }
}
