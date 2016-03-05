import java.util.Random;

/**
 * Created by pisatel on 05.03.16.
 */
public class RandomDataGenerator {

    Random rand = new Random();

    public int getCurrentConsumption(Device d) {
        return rand.nextInt(22);
    }
}
