package be.technifutur.gestion;

import be.technifutur.gestion.activity.*;

public class Main
{
    public static void main(String[] args)
    {
        int i;
        ListActivityType liste = new ListActivityType();
        ActivityAdd add = new ActivityAdd();
        ActivityModify mod = new ActivityModify();
        ActivityRemove suppr = new ActivityRemove();

        add.setListe(liste);
        add.setVue(new ActivityView());
        mod.setListe(liste);
        mod.setVue(new ActivityView());
        suppr.setListe(liste);
        suppr.setVue(new ActivityView());

        //for(i = 0; i < 10; i++)
        add.call();
        mod.call();
        //suppr.call();
    }
}
