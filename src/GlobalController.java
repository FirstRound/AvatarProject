import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by pisatel on 05.03.16.
 */
public class GlobalController implements Runnable {

    private final int ADMIN_USER = 1; // just magic, don't touch this

    private ConsumptionState _current_state;
    private Analyzer _analyzer;
    private Viewer _viewer = new Viewer();
    private TelegramBot _bot;
    private User _user = new User();
    private String _filename = "./config.ini";
    private DevicesController _devices_controller = new DevicesController();

    private Thread _viewer_thread;

    public void init() { //init all values before using
        _viewer_thread = new Thread(_viewer);
        _viewer_thread.start(); // run viewer in another thread
        _user.setUserId(ADMIN_USER); // telegram user
        _bot = new TelegramBot(_user); // init bot and link it with user
        _analyzer = new Analyzer(_devices_controller); // send dc to analyzer. For speed-up

        configSystem();
    }

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

    //get devices from config file
    private void configSystem() {
        ArrayList<Device> lst = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(_filename))) {
            line = br.readLine();
            int count = Integer.parseInt(line);
            for(int i = 0; i < count; i++) {
                line = br.readLine();
                String[] tmp = line.split(";");
                lst.add(new Device(Integer.parseInt(tmp[0]), tmp[1]));
            }
            line = br.readLine();
            String[] tmp = line.split(":");
            _analyzer.setAvgConsumption(Integer.parseInt(tmp[1]));
            line = br.readLine();
            tmp = line.split(":");
            _bot.setToken(tmp[1]+":"+tmp[2]);
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        _devices_controller.addDevices(lst);
    }

}
