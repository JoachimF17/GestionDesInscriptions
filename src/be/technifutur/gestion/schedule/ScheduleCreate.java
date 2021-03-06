package be.technifutur.gestion.schedule;

import be.technifutur.gestion.activity.ActivityRead;
import be.technifutur.gestion.activity.ActivityType;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.Callable;

public class ScheduleCreate implements Callable
{
    //attributs
    private Schedule horaire;
    private ScheduleView vue;
    private ListActivityType listActivityType;

    //methodes
    //constructeur
    public ScheduleCreate(Schedule liste, ScheduleView vue, ListActivityType listActivityType)
    {
        this.horaire = liste;
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
        String activityTypeName;
        String input = "";
        String regex = "([4-9]|[1-2][0-9]?|3[0-1]?|0[1-9])/([2-9]|1[0-2]?|0[1-9])/([1-9][0-9]{3}) ([0-1][0-9]|2[0-3]):([0-5][0-9])";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
        ActivityRead activityRead = new ActivityRead(listActivityType, new ActivityView());

        while(inputInvalide)
        {
            input = vue.createName();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(horaire.activities.get(input.toUpperCase()) != null)
                vue.setError("cette activite existe deja");
            else
                inputInvalide = false;
        }

        vue.setError(null);
        inputInvalide = true;
        name = input;

        while(inputInvalide)
        {
            activityRead.call();
            input = vue.createActivityType();

            if(input.isEmpty())
                vue.setError("entrez quelque chose");
            else if(listActivityType.get(input) != null)
                inputInvalide = false;
            else
            {
                String confirmation;
                boolean inputActiviteInvalide = true;

                while(inputActiviteInvalide)
                {
                    confirmation = vue.nonExistentActivityType().toLowerCase();

                    if (confirmation.isEmpty() || confirmation.charAt(0) == 'n')
                        inputActiviteInvalide = false;
                    else if (confirmation.charAt(0) == 'o')
                    {
                        boolean inputInscriptionInvalide = true;
                        String tempRegistration = "";
                        ActivityView activityView = new ActivityView();

                        while(inputInscriptionInvalide)
                        {
                            tempRegistration = activityView.createActivityRegistration();

                            if(tempRegistration.isEmpty() || tempRegistration.toLowerCase().charAt(0) == 'n')
                            {
                                inputInscriptionInvalide = false;
                                listActivityType.addActivityType(input, false);
                            }
                            else if(tempRegistration.toLowerCase().charAt(0) == 'o')
                            {
                                inputInscriptionInvalide = false;
                                listActivityType.addActivityType(input, true);
                            }else
                                this.vue.setError("entrez (o) ou (n)");
                        }

                        inputInvalide = false;
                        inputActiviteInvalide = false;
                    } else
                        vue.setError("entrez (o) ou (n)");
                }
            }
        }

        vue.setError(null);
        inputInvalide = true;
        activityTypeName = input;

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
        end = LocalDateTime.parse(input, formatter);

        vue.createActivityDisplay(horaire.addActivity(start, end, name, listActivityType.get(activityTypeName)));

        return null;
    }
}
