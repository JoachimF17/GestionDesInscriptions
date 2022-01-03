package be.technifutur.gestion;

import be.technifutur.gestion.activity.*;
import be.technifutur.gestion.data.DataStore;
import be.technifutur.gestion.menu.MenuController;
import be.technifutur.gestion.menu.MenuFactory;
import be.technifutur.gestion.schedule.Schedule;
import be.technifutur.gestion.schedule.ScheduleCreate;
import be.technifutur.gestion.schedule.ScheduleView;

import java.util.concurrent.Callable;

public class Main
{
    public static void main(String[] args)
    {
        //objets
        DataStore<ListActivityType> activityFile = new DataStore<>("test.ser", ListActivityType::new);
        DataStore<Schedule> scheduleFile = new DataStore<>("testSchedule.ser", Schedule::new);
        ListActivityType listActivityType = activityFile.getData();
        Schedule horaire = scheduleFile.getData();
        MenuFactory factory = new MenuFactory(listActivityType);
        MenuController menu = factory.getMenu();
        Callable callable;

        /*callable = menu.getCallable();

        try
        {
            if(callable != null)
                callable.call();
            else
                System.out.println("Au revoir !");
        }catch(Exception e)
        {
            System.out.println("Erreur");
        }*/

        ScheduleCreate create = new ScheduleCreate(horaire, new ScheduleView(), listActivityType);

        create.call();

        activityFile.save();
        scheduleFile.save();
    }
}
