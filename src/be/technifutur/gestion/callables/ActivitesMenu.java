package be.technifutur.gestion.callables;

import java.util.concurrent.Callable;

public class ActivitesMenu implements Callable
{

    @Override public Object call() throws Exception
    {
        System.out.println("Gestion des activites");
        System.out.println("---------------------");
        System.out.println("1. Creer activite");
        System.out.println("9. Retour menu principal");
        return null;
    }
}
