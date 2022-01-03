package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityDelete implements Callable
{
    //attributs
    private ListActivityType liste;
    private ActivityView vue;

    //methodes
    //constructeur
    public ActivityDelete(ListActivityType liste, ActivityView vue)
    {
        this.liste = liste;
        this.vue = vue;
    }

    @Override
    public Object call()
    {
        //variables
        boolean inputInvalide = true;
        //objets
        String nomActiviteASupprimer;
        String confirmation;

        nomActiviteASupprimer = this.vue.getDeleteActivityName();

        do
        {
            confirmation = this.vue.confirmDeleteActivity(this.liste.get(nomActiviteASupprimer));

            if(confirmation.isEmpty())
                this.vue.setError("entrez quelque chose");
            else if(confirmation.toLowerCase().charAt(0) == 'o')
            {
                this.vue.deleteActivityDisplay(this.liste.remove(nomActiviteASupprimer));
                inputInvalide = false;
            }
            else if(confirmation.toLowerCase().charAt(0) == 'n')
            {
                this.vue.cancelDeleteActivity();
                inputInvalide = false;
            }else
                this.vue.setError("entrez (o) ou (n)");
        }while(inputInvalide);

        this.vue.setError(null);

        return null;
    }
}
