package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityRead;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

import java.util.concurrent.Callable;

public class ScheduleUpdate implements Callable
{
    //attributs
    private Schedule liste;
    private ScheduleView vue;
    private ListActivityType listActivityType;

    //methodes
    //constructeur
    public ScheduleUpdate(Schedule liste, ScheduleView vue, ListActivityType listActivityType)
    {
        this.liste = liste;
        this.vue = vue;
        this.listActivityType = listActivityType;
    }

    @Override public Object call()
    {
        boolean inputInvalide = true;
        String input = "";
        String oldName;
        String newName;
        ActivityRead activityRead = new ActivityRead(listActivityType, new ActivityView());

        oldName = vue.getUpdateActivityName();

        while(inputInvalide)
        {
            input = vue.getUpdateNewName();

            if(liste.getActivity(input) == null || liste.getActivity(input).equals(liste.getActivity(oldName)))
                inputInvalide = false;
            else
                vue.setError("ce nom existe deja pour une autre activite");
        }

        if(input.isEmpty())
            newName = oldName;
        else
            newName = input;

        vue.setError(null);
        inputInvalide = true;

        while(inputInvalide)
        {
            input = vue.getUpdateNewActivityType();
        }

        return null;
    }
}
