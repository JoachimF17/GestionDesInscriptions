package be.technifutur.gestion.schedule;

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
        //variables
        boolean inputInvalide = true;
        //objets
        LocalDateTime start;
        LocalDateTime end;
        String name;
        String input = "";
        String regex = "([4-9]|[1-2][0-9]?|3[0-1]?|0[1-9])/([2-9]|1[0-2]?|0[1-9])/([1-9][0-9]{3}) ([0-1][0-9]|2[0-3]):([0-5][0-9])";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");

        while(inputInvalide)
        {
            input = vue.createDateTimeDebut();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(input.matches(regex))
                inputInvalide = false;
            else
                vue.setError("format invalide, merci de respecter le format specifie (format : J/M/AAAA HH:MM)");
        }

        vue.setError(null);
        inputInvalide = true;
        start = LocalDateTime.parse(input, formatter);

        while(inputInvalide)
        {
            input = vue.createDateTimeFin();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(input.matches(regex))
                inputInvalide = false;
            else
                vue.setError("format invalide, merci de respecter le format specifie (format : J/M/AAAA HH:MM)");
        }

        vue.setError(null);
        inputInvalide = true;
        end = LocalDateTime.parse(input, formatter);

        while(inputInvalide)
        {
            input = vue.createName();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(liste.activities.get(input.toUpperCase()) != null)
                vue.setError("cette activite existe deja");
            else
                inputInvalide = false;
        }

        vue.setError(null);
        inputInvalide = true;
        name = input;

        while(inputInvalide)
        {
            input = vue.createActivityType();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(listActivityType.get(input) == null)
                vue.setError("ce type d'activite n'existe pas");
            else
                inputInvalide = false;
        }

        vue.setError(null);

        System.out.println(liste.addActivity(start, end, name, listActivityType.get(input)));

        return null;
    }
}
