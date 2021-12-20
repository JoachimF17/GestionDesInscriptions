package be.technifutur.gestion;

import java.util.concurrent.Callable;

public class Item implements MenuNode
{
    //attributs
    private String name;
    private Callable callable;

    //methodes
    //getters
    @Override public String getName()
    {
        return name;
    }

    @Override public Callable getCallable()
    {
        return callable;
    }
    //fin getters

    //setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setCallable(Callable callable)
    {
        this.callable = callable;
    }
    //fin setters
}
