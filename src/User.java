/**
 * Created by pisatel on 05.03.16.
 */
public class User {

    private User() {

    }

    private static User _user;

    public static User getInstance() {
        if(_user == null)
            _user = new User();
        return _user;
    }
}
