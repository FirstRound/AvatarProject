/**
 * Created by pisatel on 05.03.16.
 * For web interaction. All requests should be done over the WebProvider class.
 */
public class WebProvider {
    
    private WebProvider() {

    }

    private static WebProvider _provider;

    public static WebProvider getInstance() {
        if(_provider == null)
            _provider = new WebProvider();
        return _provider;
    }

    public void sendMessageToUserByTelegram(String message) {
    }
}
