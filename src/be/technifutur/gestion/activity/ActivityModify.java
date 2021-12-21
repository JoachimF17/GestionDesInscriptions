package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityModify implements Callable
{
    //attributs
    private ListActivityType liste;
    private ActivityView vue;

    //methodes
    @Override public Object call()
    {
        //variables
        boolean replace = true;
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

        if(replace)
        {

        }

        return null;
    }
}
