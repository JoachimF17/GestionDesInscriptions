package be.technifutur.gestion;

public class ActivityType
{
    //attributs
    private String name;
    private boolean registration;

    //methodes
    //construteur
    public ActivityType(String name, boolean registration)
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
}
