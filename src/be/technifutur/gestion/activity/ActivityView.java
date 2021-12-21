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
            errorMessage();

        System.out.print("Entrez le nom de l'activite : ");

        return sc.nextLine();
    }

    public String createActivityRegistration()
    {
        errorMessage();
        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }

    public void createActivityDisplay(ActivityType activite)
    {
        System.out.printf("Nouvelle activite ajoutee !%n%s%n", displayActivity(activite));
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
        errorMessage();
        System.out.print("Entrez un nouveau nom (appuyer sur ENTREE directement pour conserver le nom) : ");

        return sc.nextLine();
    }

    public String modifyActivityRegistration(ActivityType activite)
    {
        errorMessage();
        if (activite != null && this.error == null)
            System.out.printf("Vous modifiez l'activite suivante : %s%n", displayActivity(activite));

        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }

    public void modifyActivityDisplay(ActivityType activite)
    {
        System.out.printf("Vous avez modifie l'activite avec succes !%n%s%n", displayActivity(activite));
    }
    //fin modifier activite

    //supprimer activite
    public String getRemoveActivityName()
    {
        System.out.print("Entrez le nom de l'activite a supprimer : ");

        return sc.nextLine();
    }

    public String confirmRemoveActivity(ActivityType activite)
    {
        errorMessage();
        if (activite != null && this.error == null)
            System.out.printf("Activite selectionnee : %s%n", displayActivity(activite));

        System.out.print("Souhaitez-vous vraiment la supprimer ? (o/n) : ");

        return sc.nextLine();
    }

    public void cancelRemoveActivity()
    {
        System.out.println("L'activite n'a pas ete supprimee !");
    }

    public void removeActivityDisplay(ActivityType activite)
    {
        System.out.printf("Activite supprimee avec succes !%n%s%n", displayActivity(activite));
    }
    //fin supprimer activite

    //retourne le toString de l'activite pour affichage
    public String displayActivity(ActivityType activite)
    {
        return activite.toString();
    }

    //affichage du message d'erreur
    private void errorMessage()
    {
        if (this.error != null)
            System.out.printf("Erreur : %s%n", this.error);
    }
}
