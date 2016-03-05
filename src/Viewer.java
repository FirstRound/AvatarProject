import javax.swing.*;
import java.awt.*;

/**
 * Created by pisatel on 05.03.16.
 */
public class Viewer implements Runnable{

    private volatile ConsumptionState _state;
    private JFrame _frame;

    public Viewer() {
        _state = ConsumptionState.LOW;
    }

    public void showCurrentState(ConsumptionState current_state) {
        _state = current_state;
    }

    public void run() {
        _frame = new JFrame("Avatar");

        ImageIcon image1 = new ImageIcon("./img/Luk.jpg");
        JLabel imageLabel1 = new JLabel(image1);

        ImageIcon image2 = new ImageIcon("./img/Vader.jpeg");
        JLabel imageLabel2 = new JLabel(image2);

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.getContentPane().add(imageLabel2, BorderLayout.CENTER);
        _frame.setSize(200, 300);
        _frame.setVisible(true);

        while(true) {
            System.out.print(_state.toString() + "\n");
            _frame.getContentPane().removeAll();
            _frame.repaint();
            if (_state == ConsumptionState.LOW)
                _frame.getContentPane().add(imageLabel1, BorderLayout.CENTER);
            else
                _frame.getContentPane().add(imageLabel2, BorderLayout.CENTER);
            try {
                Thread.sleep(1000);
            }
            catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        }
    }
}
