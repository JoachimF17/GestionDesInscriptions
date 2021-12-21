package be.technifutur.gestion.activity;

import java.util.concurrent.Callable;

public class ActivityCreate implements Callable
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

    @Override public ActivityType call()
    {
        //variables
        boolean registration = false;
        boolean inputInvalide;
        //objets
        String name;
        String tempRegistration;

        do
        {
             name = this.vue.createActivityName();

             if(name.isEmpty())
             {
                 inputInvalide = true;
                 this.vue.setError("entrez quelque chose");
             }else if(this.liste.get(name) != null)
             {
                 this.vue.setError("cette activite existe deja");
                 inputInvalide = true;
             }
             else
                 inputInvalide = false;

        }while(inputInvalide);

        this.vue.setError(null);
        inputInvalide = true;

        do
        {
            tempRegistration = this.vue.createActivityRegistration();

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

        this.vue.createActivityDisplay(this.liste.addActivityType(name, registration));

        return null;
    }
}
