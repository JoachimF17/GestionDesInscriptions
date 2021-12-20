package be.technifutur.gestion.callables;

import java.util.concurrent.Callable;

public class CreerActivite implements Callable
{
    @Override public Object call() throws Exception
    {
        System.out.println("Creer une activite");

        return null;
    }
}
