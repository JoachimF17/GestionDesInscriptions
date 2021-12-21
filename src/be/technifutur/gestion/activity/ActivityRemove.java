package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityRemove implements Callable
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


    @Override
    public Object call()
    {
        //objets
        String nomActiviteASupprimer;
        String confirmation;

        nomActiviteASupprimer = this.vue.getRemoveActivityName();

        confirmation = this.vue.confirmRemoveActivity(this.liste.get(nomActiviteASupprimer));

        if(confirmation.toLowerCase().charAt(0) == 'o')
            this.vue.removeActivityDisplay(this.liste.remove(nomActiviteASupprimer));

        return null;
    }
}
