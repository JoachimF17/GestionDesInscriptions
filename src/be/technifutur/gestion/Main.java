package be.technifutur.gestion;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class Main
{
    public static void main(String[] args)
    {
        MenuFactory mf = new MenuFactory();
        MenuController controller = mf.getMenu();
        ListActivityType listeActivites = new ListActivityType();

        Callable call = controller.getCallable();

        try
        {
            ActivityType activite = (ActivityType) call.call();
            listeActivites.addActivityType(activite.getName(), activite.isRegistrationRequired());
        }catch(Exception e)
        {
            System.out.println("test");
        }
    }
}
