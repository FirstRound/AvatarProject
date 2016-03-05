/**
 * Created by pisatel on 05.03.16.
 */
public class Device {
    private int _id;
    private String _name;

    public Device(int id, String name) {
        _id = id;
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }
}
