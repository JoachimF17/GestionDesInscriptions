package be.technifutur.gestion;

import java.io.Serializable;
import java.util.TreeMap;

public class ListActivityType implements Serializable
{
    //attributes
    TreeMap<String, ActivityType> listeActivites = new TreeMap<>();

    //methodes
    public ActivityType addActivityType(String name, boolean registration)
    {
        ActivityType activite = new ActivityType(name, registration);
        listeActivites.put(name.toUpperCase(), activite);
        return activite;
    }

    public ActivityType get(String name)
    {
        return listeActivites.get(name.toUpperCase());
    }

    public ActivityType remove(String name)
    {
        listeActivites.remove(name.toUpperCase());
        return get(name);
    }
}
