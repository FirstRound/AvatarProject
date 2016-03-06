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
    private JPanel _panel = new JPanel();
    private JPanel _image_panel = new JPanel();
    private JPanel _button_panel = new JPanel();
    private Logger _logger = Logger.getInstance();

    public Viewer() {
        _state = ConsumptionState.LOW;
    }

    public void showCurrentState(ConsumptionState current_state) {
        _state = current_state;
        _logger.writeToLog(current_state.toString());
    }

    private void initFrame() {

        initResources();

        _frame = new JFrame("Avatar");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setSize(400, 300);
        _frame.add(_panel);

        _panel.setLayout(new BorderLayout());
        _panel.add(_image_panel, BorderLayout.CENTER);
        _panel.add(_button_panel, BorderLayout.NORTH);
        _button_panel.add(new JButton("Change"));
        _frame.setVisible(true);
    }

    private void initResources() {
        ImageIcon image1 = new ImageIcon("./img/Luk.jpg");
        _labels.add(new JLabel(image1));

        ImageIcon image2 = new ImageIcon("./img/Vader.jpeg");
        _labels.add(new JLabel(image2));
    }

    private void panelControl(int panel) {
        //TODO: Implement
    }

    public void run() {

        initFrame();

        while(true) {
            _image_panel.removeAll();
            System.out.print(_state.toString() + "\n");
            _image_panel.add(_labels.get(_state.ordinal()/3), BorderLayout.CENTER);
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
