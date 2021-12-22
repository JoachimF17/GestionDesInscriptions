package be.technifutur.gestion.schedule;

import java.util.concurrent.Callable;

public class ScheduleUpdate implements Callable
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
