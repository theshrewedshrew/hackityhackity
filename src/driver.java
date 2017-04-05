/**
 * Created by taylor hudson on 4/5/2017.
 */
public class driver {
    //static int count = 0;
    public static void main(String [] args0){
        LoginBox lb = new LoginBox();
        submit scoreSlaughter[] = new submit[16];
        while(!lb.access()){
            try{
                Thread.sleep(19);
            }
            catch(Exception e){

            }
        }
        for(int i = 0; i < 16; i++)
            scoreSlaughter[i] = new submit(lb.getUsername(), lb.getPassword());
        for(int i = 0; i < 16; i ++)
            new Thread(scoreSlaughter[i]).start();
    }
}
