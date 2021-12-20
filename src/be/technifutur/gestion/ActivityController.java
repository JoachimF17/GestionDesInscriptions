package be.technifutur.gestion;

import java.util.concurrent.Callable;

public class ActivityController implements Callable
{
    //attributs
    ListActivityType liste;
    ActivityView vue;

    //methodes
    //setters
    public void setListe(ListActivityType liste)
    {
        this.liste = liste;
    }

    public void setVue(ActivityView vue)
    {
        this.vue = vue;
    }
    //fin setters

    @Override public ActivityType call()
    {
        String name = this.vue.activityName();
        boolean registration = this.vue.activityRegistration().charAt(0) == 'o';

        return new ActivityType(name, registration);
    }
}
