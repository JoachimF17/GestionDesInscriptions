package be.technifutur.gestion;

import java.util.Scanner;

public class ActivityView
{
    //attributs
    Scanner sc = new Scanner(System.in);
    String error;

    //methodes
    //setters
    public void setError(String error)
    {
        this.error = error;
    }
    //fin setters
    public String activityName()
    {
        System.out.println("Creer une activite");
        System.out.println("------------------");

        if(this.error != null)
            System.out.println("Erreur : "+this.error);

        System.out.print("Entrez le nom de l'activite : ");

        return sc.nextLine();
    }

    public String activityRegistration()
    {
        if(this.error != null)
            System.out.println("Erreur : "+this.error);

        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }

    public void displayActivity(ActivityType activite)
    {
        System.out.println(activite.toString());
    }
}
