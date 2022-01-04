package be.technifutur.gestion.schedule;

import java.util.concurrent.Callable;

public class ScheduleUpdate implements Callable
{
    //attributs
    private Schedule liste;
    private ScheduleView vue;

    //methodes
    //setters
    public void setListe(Schedule liste)
    {
        this.liste = liste;
    }

    public void setVue(ScheduleView vue)
    {
        this.vue = vue;
    }
    //fin setters

    @Override public Object call()
    {
        boolean inputInvalide = true;
        String input = "";
        String oldName;
        String newName;

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

        return null;
    }
}
