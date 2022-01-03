package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityType;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class ScheduleCreate implements Callable
{
    //attributs
    private Schedule liste;
    private ScheduleView vue;
    private ListActivityType listActivityType;

    //methodes
    //constructeur
    public ScheduleCreate(Schedule liste, ScheduleView vue, ListActivityType listActivityType)
    {
        this.liste = liste;
        this.vue = vue;
        this.listActivityType = listActivityType;
    }

    @Override public Object call()
    {
        //objets
        LocalDateTime start;
        LocalDateTime end;
        String name;
        ActivityType type;
        String input;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");

        input = vue.createDateTimeDebut();
        start = LocalDateTime.parse(input, formatter);

        input = vue.createDateTimeFin();
        end = LocalDateTime.parse(input, formatter);

        input = vue.createName();
        name = input;

        input = vue.createActivityType();
        type = listActivityType.get(input);

        System.out.println(liste.addActivity(start, end, name, type));

        return null;
    }
}
