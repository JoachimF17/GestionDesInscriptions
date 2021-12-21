package be.technifutur.gestion.activity;

import java.util.Scanner;

public class ActivityView
{
    //attributs
    private Scanner sc = new Scanner(System.in);
    private String error;

    //methodes
    //setters
    public void setError(String error)
    {
        this.error = error;
    }
    //fin setters

    //creer activite
    public String createActivityName()
    {

        if (this.error == null)
        {
            System.out.println("Creer une activite");
            System.out.println("------------------");
        } else
            System.out.println("Erreur : " + this.error);

        System.out.print("Entrez le nom de l'activite : ");

        return sc.nextLine();
    }

    public String createActivityRegistration()
    {
        if (this.error != null)
            System.out.println("Erreur : " + this.error);

        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }

    public void createActivityDisplay(ActivityType activite)
    {
        System.out.printf("Nouvelle activite ajoutee !%n%s", displayActivity(activite));
    }
    //fin creer activite

    //modifier activite
    public String getActivityName()
    {
        System.out.print("Entrez le nom de l'activite que vous souhaitez modifier : ");

        return sc.nextLine();
    }

    public String modifyActivityName()
    {
        System.out.print("Entrez un nouveau nom (appuyer sur ENTREE directement pour conserver le nom) : ");

        return sc.nextLine();
    }

    public String modifyActivityRegistration(ActivityType activite)
    {
        System.out.printf("Vous modifiez l'activite suivante : %s%n", displayActivity(activite));
        System.out.println("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }
    //fin modifier activite

    //retourne le toString de l'activite pour affichage
    public String displayActivity(ActivityType activite)
    {
        return activite.toString();
    }
}
