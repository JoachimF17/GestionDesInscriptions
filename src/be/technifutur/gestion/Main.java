package be.technifutur.gestion;

import be.technifutur.gestion.activity.*;
import be.technifutur.gestion.data.DataStore;
import be.technifutur.gestion.menu.MenuController;
import be.technifutur.gestion.menu.MenuFactory;

import java.util.concurrent.Callable;

public class Main
{
    public static void main(String[] args)
    {
        //variables
        int i;
        //objets
        DataStore<ListActivityType> activityFile = new DataStore<>("test.ser", ListActivityType::new);
        ListActivityType listActivityType = activityFile.getData();
        MenuFactory factory = new MenuFactory(listActivityType);
        MenuController menu = factory.getMenu();
        Callable callable;

        callable = menu.getCallable();

        try
        {
            if(callable != null)
                callable.call();
            else
                System.out.println("Au revoir !");
        }catch(Exception e)
        {
            System.out.println("Erreur");
        }

        activityFile.save();
    }
}
