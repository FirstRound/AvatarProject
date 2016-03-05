import java.util.ArrayList;

/**
 * Created by pisatel on 05.03.16.
 */
public class DevicesController {

    private ArrayList<Device> devices = new ArrayList<>();
    private DataSource _data_source = new RandomDataGenerator();

    public void addDevices(ArrayList<Device> list) {
        devices.addAll(list);
    }

    public int getCurrentConsumption() {
        int sum = 0;
        for (Device d : devices) {
            sum += _data_source.getCurrentConsumption(d);
        }
        return sum;
    }
}
