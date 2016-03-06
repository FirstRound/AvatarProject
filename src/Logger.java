import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by pisatel on 06.03.16.
 */
public class Logger {
    private static Logger _logger;
    private static String _filename = "avatar.log";
    private PrintWriter _writer;

    private Logger() {
        try {
            _writer = new PrintWriter(new FileOutputStream(new File("./avatar.log"),true));
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }


    public static Logger getInstance() {
        if(_logger == null)
            _logger = new Logger();
        return _logger;
    }

    public void writeToLog(String messasge) {
        _writer.println(messasge);
        _writer.flush();
    }
}
