package be.technifutur.gestion.activity;

import be.technifutur.gestion.abstraites.Views;

public class ActivityView extends Views
{
    //methodes
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

        return sc.nextLine().trim();
    }

    public String createActivityRegistration()
    {
        errorMessage();
        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine().trim();
    }

    public void createActivityDisplay(ActivityType activite)
    {
        System.out.printf("Nouvelle activite ajoutee !%n%s%n", displayActivity(activite));
    }
    //fin creer activite

    //afficher activites
    public void readActivityHeader()
    {
        System.out.println("Liste des types d'activite encodes : ");
    }

    public void readEachActivity(ActivityType activite)
    {
        System.out.println(activite);
    }
    //fin afficher activites

    //modifier activite
    public String getActivityName()
    {
        System.out.print("Entrez le nom de l'activite que vous souhaitez modifier : ");

        return sc.nextLine().trim();
    }

    public String updateActivityName()
    {
        errorMessage();
        System.out.print("Entrez un nouveau nom (appuyer sur ENTREE directement pour conserver le nom) : ");

        return sc.nextLine().trim();
    }

    public String updateActivityRegistration(ActivityType activite)
    {
        errorMessage();
        if (activite != null && this.error == null)
            System.out.printf("Vous modifiez l'activite suivante : %s%n", displayActivity(activite));

        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine().trim();
    }

    public void updateActivityDisplay(ActivityType activite)
    {
        System.out.printf("Vous avez modifie l'activite avec succes !%n%s%n", displayActivity(activite));
    }
    //fin modifier activite

    //supprimer activite
    public String getDeleteActivityName()
    {
        System.out.print("Entrez le nom de l'activite a supprimer : ");

        return sc.nextLine().trim();
    }

    public String confirmDeleteActivity(ActivityType activite)
    {
        errorMessage();
        if (activite != null && this.error == null)
            System.out.printf("Activite selectionnee : %s%n", displayActivity(activite));

        System.out.print("Souhaitez-vous vraiment la supprimer ? (o/n) : ");

        return sc.nextLine().trim();
    }

    public void cancelDeleteActivity()
    {
        System.out.println("L'activite n'a pas ete supprimee !");
    }

    public void deleteActivityDisplay(ActivityType activite)
    {
        System.out.printf("Activite supprimee avec succes !%n%s%n", displayActivity(activite));
    }

    public void scheduledActivityType(ActivityType activite)
    {
        System.out.printf("L'activite %s est utilisee dans l'horaire et ne peut donc pas etre supprimee !%n", displayActivity(activite));
    }
    //fin supprimer activite

    //retourne le toString de l'activite pour affichage
    public String displayActivity(ActivityType activite)
    {
        return activite.toString();
    }
}
