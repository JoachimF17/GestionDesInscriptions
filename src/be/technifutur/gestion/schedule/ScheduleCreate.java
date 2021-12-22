package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

import java.util.concurrent.Callable;

public class ScheduleCreate implements Callable
{
    //attributs
    private Schedule liste;
    private ScheduleView vue;

    //methodes
    //setters
    public void setListe(Schedule liste)
    {
        this.liste = liste;
    }

    public void setVue(ScheduleView vue)
    {
        this.vue = vue;
    }
    //fin setters

    @Override public Object call()
    {
        return null;
    }
}
