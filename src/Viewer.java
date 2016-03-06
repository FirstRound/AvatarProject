import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by pisatel on 05.03.16.
 */
public class Viewer implements Runnable{

    private volatile ConsumptionState _state;
    private JFrame _frame;
    private ArrayList<Component> _labels = new ArrayList<>();
    private Logger _logger = Logger.getInstance();

    public Viewer() {
        _state = ConsumptionState.LOW;
    }

    public void showCurrentState(ConsumptionState current_state) {
        _state = current_state;
        _logger.writeToLog(current_state.toString());
    }

    private void initFrame() {
        _frame = new JFrame("Avatar");

        ImageIcon image1 = new ImageIcon("./img/Luk.jpg");
        _labels.add(new JLabel(image1));

        ImageIcon image2 = new ImageIcon("./img/Vader.jpeg");
        _labels.add(new JLabel(image2));

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.getContentPane().add(_labels.get(1), BorderLayout.CENTER);
        _frame.setSize(200, 300);
        _frame.setVisible(true);
    }

    public void run() {
        initFrame();

        while(true) {
            System.out.print(_state.toString() + "\n");
            _frame.getContentPane().removeAll();
            _frame.getContentPane().add(_labels.get(_state.ordinal()/3), BorderLayout.CENTER);
            _frame.repaint();

            try {
                Thread.sleep(1000);
            }
            catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }
    }
}
