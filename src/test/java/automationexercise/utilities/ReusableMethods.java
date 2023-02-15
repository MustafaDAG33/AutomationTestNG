package automationexercise.utilities;

public class ReusableMethods {

    public static void waitFor(int saniye){

        try{
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
