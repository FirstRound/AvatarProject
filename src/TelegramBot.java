/**
 * Created by pisatel on 05.03.16.
 */
public class TelegramBot {

    private User _user;
    private String _token;
    private WebProvider _provider = WebProvider.getInstance();

    public TelegramBot(User user) {
        _user = user;
    }

    public void sendCurrentStateMessage(ConsumptionState current_state) {
        String message = "Your current consumption state is " + current_state.toString();
        message += ".\n It is "+ current_state.ordinal() + " level";
        _provider.sendMessageToUserByTelegram(message, _user);
    }

    public void setToken(String token) {
        _token = token;
    }
}
