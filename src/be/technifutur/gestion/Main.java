package be.technifutur.gestion;

import be.technifutur.gestion.activity.*;
import be.technifutur.gestion.data.DataStore;

public class Main
{
    public static void main(String[] args)
    {
        //variables
        int i;
        //objets
        DataStore<ListActivityType> activityFile = new DataStore<>("test.ser", ListActivityType::new);
        ListActivityType activityList = activityFile.getData();
        ActivityView vue = new ActivityView();
        ActivityCreate add = new ActivityCreate();
        ActivityUpdate mod = new ActivityUpdate();
        ActivityDelete suppr = new ActivityDelete();

        add.setListe(activityList);
        add.setVue(vue);
        mod.setListe(activityList);
        mod.setVue(vue);
        suppr.setListe(activityList);
        suppr.setVue(vue);

        //for(i = 0; i < 10; i++)
        //add.call();
        //mod.call();
        //suppr.call();

        activityFile.save();
    }
}
