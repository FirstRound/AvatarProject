/**
 * Created by pisatel on 05.03.16.
 */
public class AvatarProject {
    public static void main(String[] args) {
        GlobalController gc = new GlobalController();
        try {
            gc.mainLoop();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }
}
