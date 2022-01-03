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

    //methodes
    //constructeur
    public ScheduleCreate(Schedule liste, ScheduleView vue)
    {
        this.liste = liste;
        this.vue = vue;
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

        System.out.println(start);

        return null;
    }
}
