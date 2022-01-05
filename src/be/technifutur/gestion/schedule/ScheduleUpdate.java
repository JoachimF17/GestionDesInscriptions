package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityRead;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime start;
        LocalDateTime end;
        String oldName;
        String newName;
        String regex = "([4-9]|[1-2][0-9]?|3[0-1]?|0[1-9])/([2-9]|1[0-2]?|0[1-9])/([1-9][0-9]{3}) ([0-1][0-9]|2[0-3]):([0-5][0-9])";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
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

        /*while(inputInvalide)
        {
            activityRead.call();
            input = vue.getUpdateNewActivityType();

            if(listActivityType.get(input) == null)
        }

        vue.setError(null);
        inputInvalide = true;*/

        while(inputInvalide)
        {
            input = vue.updateDateTimeDebut();

            if(input.isEmpty() || input.matches(regex))
                inputInvalide = false;
            else
                vue.setError("format invalide, merci de respecter le format specifie (format : J/M/AAAA HH:MM)");
        }

        vue.setError(null);
        inputInvalide = true;

        if(input.isEmpty())
            start = liste.getActivity(oldName).getStartTime();
        else
            start = LocalDateTime.parse(input, formatter);

        while(inputInvalide)
        {
            input = vue.updateDateTimeFin();

            if(input.isEmpty() || input.matches(regex))
                inputInvalide = false;
            else
                vue.setError("format invalide, merci de respecter le format specifie (format : J/M/AAAA HH:MM)");
        }

        vue.setError(null);

        if(input.isEmpty())
            start = liste.getActivity(oldName).getEndTime();
        else
            start = LocalDateTime.parse(input, formatter);

        return null;
    }
}
