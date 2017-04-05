import java.io.IOException;
import java.net.URL;

/**
 * Created by taylor hudson on 4/5/2017.
 */
public class submit implements Runnable {
    String user = "d";
    String pass = "d";
    String VERSION = "1.5";
    public submit(String username, String password){
        user = username;
        pass = password;
    }
    @Override
    public void run() {
        while (true) {
            int fifty = (int) (Math.random() * 50000)*10;
            int sizeX = (int) (Math.random() * 21) + 5;
            int sizeY = sizeX;
            double time = (double) (fifty) / 1000;
            URL url;
            try {
                    url = new URL("http://westonreed.com/picross/addscore.php?username=" + user + "&password=" + pass + "&time=" + time + "&size=" + sizeX + "x" + sizeY + "&version=" + VERSION);
                    url.openStream();
                    //System.out.println(driver.count++);
                } catch (Exception ex) {
                }

            try{
                Thread.sleep(1500);
            }catch(Exception e){

            }
        }
    }
}
