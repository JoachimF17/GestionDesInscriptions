package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityModify implements Callable
{
    //attributs
    private ListActivityType liste;
    private ActivityView vue;

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
    @Override public Object call()
    {
        //variables
        boolean replace = true;
        boolean registration = false;
        //objets
        String oldName;
        String newName;
        String newRegistration;

        oldName = this.vue.getActivityName();
        newName = this.vue.modifyActivityName();

        if(newName.isEmpty())
        {
            newName = oldName;
            replace = false;
        }

        newRegistration = this.vue.modifyActivityRegistration(this.liste.get(newName));

        if(newRegistration.toLowerCase().charAt(0) == 'o')
        {
            registration = true;
        }

        if(replace)
            this.liste.remove(oldName);

        this.vue.modifyActivityDisplay(this.liste.addActivityType(newName, registration));

        return null;
    }
}
