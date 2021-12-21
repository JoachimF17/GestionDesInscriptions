package be.technifutur.gestion;

import be.technifutur.gestion.activity.*;
import be.technifutur.gestion.data.DataStore;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        //variables
        int i;
        //objets
        ListActivityType activityList;
        ActivityView vue = new ActivityView();
        ActivityAdd add = new ActivityAdd();
        ActivityModify mod = new ActivityModify();
        ActivityRemove suppr = new ActivityRemove();
        DataStore<ListActivityType> activityFile = new DataStore<>("test.ser", ListActivityType::new);

        activityList = activityFile.getData();

        add.setListe(activityList);
        add.setVue(vue);
        mod.setListe(activityList);
        mod.setVue(vue);
        suppr.setListe(activityList);
        suppr.setVue(vue);

        //for(i = 0; i < 10; i++)
        //add.call();
        mod.call();
        //suppr.call();

        activityFile.save();
    }
}
