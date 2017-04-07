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

            int sizeX = (int) (Math.random() * 100000) + 5;
            if(user.equals("qq")){ sizeX = 25; }
            int sizeY = sizeX;//(int) (Math.random() * 96) + 5;
            int fifty = (int) (Math.random() * 5000000)*10+10;
            double time = (double) (fifty) / 1000;
            URL url;
            try {
                    url = new URL("http://westonreed.com/picross/addscore.php?username=" + user + "&password=" + pass + "&time=" + time + "&size=" + sizeX + "x" + sizeY + "&version=" + VERSION);

                    url.openStream();
                    //System.out.println(driver.count++);
                } catch (Exception ex) {
                }

            try{
                if(fifty > 50000 && !user.equals("qq"))
                    Thread.sleep((int)time);
                else
                    Thread.sleep((int)(Math.random()*98768) + 124132);
            }catch(Exception e){

            }
        }
    }
}
