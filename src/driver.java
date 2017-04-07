/**
 * Created by taylor hudson on 4/5/2017.
 */
public class driver {
    //static int count = 0;
    static int sleeptime = 15; /// Time in seconds
    static final int number = 999;
    static final int numLoginBox = 1;

    public static void main(String[] args0) {

        LoginBox lb[];
        lb = new LoginBox[numLoginBox];
        for (int i = 0; i < numLoginBox; i++)
            lb[i] = new LoginBox();

        submit scoreSlaughter[] = new submit[number];
        if (numLoginBox > 1)
            for (int i = 0; i < number; i++)
                while (!lb[number].access()) {
                    try {
                        Thread.sleep(19);
                    } catch (Exception e) {

                    }
                }
        else {
            while (!lb[0].access()) {
                try {
                    Thread.sleep(19);
                } catch (Exception e) {

                }

            }
            if (numLoginBox < 2) {
                for (int i = 0; i < number; i++)
                    scoreSlaughter[i] = new submit(lb[0].getUsername(), lb[0].getPassword());
                for (int i = 0; i < number; i++)
                    new Thread(scoreSlaughter[i]).start();
            } else {
                for (int i = 0; i < number; i++)
                    scoreSlaughter[i] = new submit(lb[number].getUsername(), lb[number].getPassword());
                for (int i = 0; i < number; i++)
                    new Thread(scoreSlaughter[0]).start();

            }
        }
    }
}
