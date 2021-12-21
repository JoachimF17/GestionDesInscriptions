package be.technifutur.gestion;

import be.technifutur.gestion.activity.ActivityAdd;
import be.technifutur.gestion.activity.ActivityModify;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

public class Main
{
    public static void main(String[] args)
    {
        int i;
        ListActivityType liste = new ListActivityType();
        ActivityAdd add = new ActivityAdd();
        ActivityModify mod = new ActivityModify();

        add.setListe(liste);
        add.setVue(new ActivityView());
        mod.setListe(liste);
        mod.setVue(new ActivityView());

        //for(i = 0; i < 10; i++)
        add.call();
        mod.call();
    }
}
