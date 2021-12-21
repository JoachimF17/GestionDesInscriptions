package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityUpdate implements Callable
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
        boolean inputInvalide = true;
        //objets
        String oldName;
        String newName;
        String tempRegistration;

        oldName = this.vue.getActivityName();

        do
        {
            newName = this.vue.updateActivityName();

            if(this.liste.get(newName) == null)
                inputInvalide = false;
            else
                this.vue.setError("cette activite est deja encodee");
        }while(inputInvalide);

        if(newName.isEmpty())
        {
            newName = oldName;
            replace = false;
        }

        this.vue.setError(null);
        inputInvalide = true;

        do
        {
            tempRegistration = this.vue.updateActivityRegistration(this.liste.get(oldName));

            if(tempRegistration.isEmpty())
                this.vue.setError("entrez quelque chose");
            else if(tempRegistration.toLowerCase().charAt(0) == 'o')
            {
                inputInvalide = false;
                registration = true;
            }else if(tempRegistration.toLowerCase().charAt(0) == 'n')
                inputInvalide = false;
            else
                this.vue.setError("entrez (o) ou (n)");

        }while(inputInvalide);

        this.vue.setError(null);

        if(replace)
            this.liste.remove(oldName);

        this.vue.updateActivityDisplay(this.liste.addActivityType(newName, registration));

        return null;
    }
}
