package be.technifutur.gestion;

import java.util.concurrent.Callable;

public class ActivityController implements Callable
{
    //attributs
    ListActivityType liste;
    ActivityView vue;

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
        boolean inputInvalide = false;
        //objets
        String name;
        String tempRegistration;

        do
        {
             name = this.vue.activityName();

             if(name.isEmpty())
             {
                 inputInvalide = true;
                 this.vue.setError("entrez quelque chose");
             }else if(this.liste.get(name.toUpperCase()) != null)
             {
                 this.vue.setError("cette activite existe deja");
                 inputInvalide = true;
             }
             else
                 inputInvalide = false;

        }while(inputInvalide);

        this.vue.setError(null);

        do
        {
            tempRegistration = this.vue.activityRegistration();

            if(tempRegistration.isEmpty())
            {
                inputInvalide = true;
                this.vue.setError("entrez quelque chose");
            }
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

        this.vue.displayActivity(this.liste.addActivityType(name, registration));

        return null;
    }
}
