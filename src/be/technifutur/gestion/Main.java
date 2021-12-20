package be.technifutur.gestion;

import java.util.concurrent.Callable;

public class Main
{
    public static void main(String[] args)
    {
        MenuFactory mf = new MenuFactory();
        MenuController controller = mf.getMenu();

        Callable test = controller.getCallable();

        try
        {
            test.call();
        }catch(Exception e)
        {
            System.out.println("zzz");
        }
    }
}
