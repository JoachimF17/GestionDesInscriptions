package be.technifutur.gestion.activity;

import java.util.Map;
import java.util.concurrent.Callable;

public class ActivityRead implements Callable
{
    //attributs
    private ListActivityType liste;
    private ActivityView vue;

    //methodes
    //constructeur
    public ActivityRead(ListActivityType liste, ActivityView vue)
    {
        this.liste = liste;
        this.vue = vue;
    }

    @Override public Object call()
    {
        this.vue.readActivityHeader();

        for(Map.Entry<String, ActivityType> entry : liste.listeActivites.entrySet())
            this.vue.readEachActivity(entry.getValue());

        return null;
    }
}
