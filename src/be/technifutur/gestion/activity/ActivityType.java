package be.technifutur.gestion.activity;

import java.io.Serializable;

public class ActivityType implements Serializable
{
    //attributs
    private String name;
    private boolean registration;

    //methodes
    //construteur
    ActivityType(String name, boolean registration)
    {
        this.name = name;
        this.registration = registration;
    }

    //getters
    public String getName()
    {
        return this.name;
    }

    public boolean isRegistrationRequired()
    {
        return this.registration;
    }
    //fin getters

    //setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setRegistrationRequired(boolean registration)
    {
        this.registration = registration;
    }
    //fin setters


    @Override
    public String toString()
    {
        return "Type d'activite : '" + name + '\'' +
                ", inscription requise : " + (registration ? "oui" : "non");
    }
}
