import java.util.ArrayList;

/**
 * Created by pisatel on 05.03.16.
 */
public class GlobalController implements Runnable {

    private final int MAGIC_USER = 42; // just magic, don't touch this

    private ConsumptionState _current_state;
    private Analyzer _analyzer;
    private Viewer _viewer = new Viewer();
    private TelegramBot _bot;
    private User _user = new User();
    private DevicesController _devices_controller = new DevicesController();

    private Thread _viewer_thread;

    public void init() { //init all values before using
        _viewer_thread = new Thread(_viewer);
        _viewer_thread.start(); // run viewer in another thread
        _user.setUserId(MAGIC_USER); // telegram user
        _bot = new TelegramBot(_user); // init bot and link it with user
        _analyzer = new Analyzer(_devices_controller); // send dc to analyzer. For speed-up
        addDevices(); // DELETE THIS
    }

    //BEGIN DIKII PIZDETS
    public void addDevices() { // we should get devices smwhr (???)
        //TODO: DELETE THIS CODE
        ArrayList<Device> lst = new ArrayList<>();
        for (int i = 0; i < 10 ;i++) {
            lst.add(new Device());
        }
        _devices_controller.addDevices(lst);
    }
    //END DIKII PIZDETS

    public void run(){
        init();

        try {
            mainLoop();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }

    private void mainLoop() throws Exception{
        while(true) {
            _current_state = _analyzer.getCurrentState();
            _viewer.showCurrentState(_current_state);
            _bot.sendCurrentStateMessage(_current_state);
            Thread.sleep(1000); // sleep 1 sec

        }

    }
}
