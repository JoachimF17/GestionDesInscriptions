package be.technifutur.gestion.activity;

import be.technifutur.gestion.schedule.Activity;
import be.technifutur.gestion.schedule.Schedule;

import java.util.Map;
import java.util.concurrent.Callable;

public class ActivityDelete implements Callable
{
    //attributs
    private ListActivityType liste;
    private ActivityView vue;
    private Schedule schedule;

    //methodes
    //constructeur
    public ActivityDelete(ListActivityType liste, ActivityView vue, Schedule schedule)
    {
        this.liste = liste;
        this.vue = vue;
        this.schedule = schedule;
    }

    @Override
    public Object call()
    {
        //variables
        boolean inputInvalide = true;
        boolean scheduledActivity = false;
        //objets
        String nomActiviteASupprimer;
        String confirmation;
        ActivityType delete;

        nomActiviteASupprimer = this.vue.getDeleteActivityName();
        delete = liste.get(nomActiviteASupprimer);

        for(Map.Entry<String, Activity> entry : schedule.activities.entrySet())
            if (entry.getValue().getActivityType().equals(delete))
            {
                scheduledActivity = true;
                break;
            }

        if(scheduledActivity)
        {
            do
            {
                confirmation = this.vue.confirmDeleteActivity(delete);

                if (confirmation.isEmpty())
                    this.vue.setError("entrez quelque chose");
                else if (confirmation.toLowerCase().charAt(0) == 'o')
                {
                    this.vue.deleteActivityDisplay(this.liste.remove(nomActiviteASupprimer));
                    inputInvalide = false;
                } else if (confirmation.toLowerCase().charAt(0) == 'n')
                {
                    this.vue.cancelDeleteActivity();
                    inputInvalide = false;
                } else
                    this.vue.setError("entrez (o) ou (n)");
            } while (inputInvalide);
        }else
            vue.scheduledActivityType(delete);

        this.vue.setError(null);

        return null;
    }
}
