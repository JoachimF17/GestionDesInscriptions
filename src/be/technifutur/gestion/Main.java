package be.technifutur.gestion;

import be.technifutur.gestion.activity.ActivityAdd;
import be.technifutur.gestion.activity.ActivityView;
import be.technifutur.gestion.activity.ListActivityType;

public class Main
{
    public static void main(String[] args)
    {
        int i;
        ActivityAdd add = new ActivityAdd();
        add.setListe(new ListActivityType());
        add.setVue(new ActivityView());

        //for(i = 0; i < 10; i++)
        add.call();
    }
}
