package be.technifutur.gestion.schedule;

import be.technifutur.gestion.abstraites.Views;

public class ScheduleView extends Views
{
    //methodes
    //general
    public String nonExistentActivityType()
    {
        System.out.print("Le type d'activite que vous venez d'entrer n'existe pas. Souhaitez-vous le creer ? (o/n) : ");

        return sc.nextLine().trim();
    }
    //create
    public String createDateTimeDebut()
    {
        if(this.error == null)
        {
            System.out.println("Ajout d'une activite");
            System.out.println("--------------------");
        }else
            errorMessage();

        System.out.print("Entrez l'horaire du debut de l'activite (format : J/M/AAAA HH:MM) : ");
        return sc.nextLine().trim();
    }

    public String createDateTimeFin()
    {
        errorMessage();
        System.out.print("Entrez l'horaire de fin de l'activite (format : J/M/AAAA HH:MM) : ");
        return sc.nextLine().trim();
    }

    public String createName()
    {
        errorMessage();
        System.out.print("Entrez le nom de l'activite (celui-ci doit etre unique) : ");
        return sc.nextLine().trim();
    }

    public String createActivityType()
    {
        errorMessage();
        System.out.print("Entrez le nom du type d'activite : ");
        return sc.nextLine().trim();
    }

    public void createActivityDisplay(Activity activite)
    {
        System.out.println("Activite bien cree dans l'horaire");
        System.out.println(activite);
    }
    //fin create
    //update
    public String getUpdateActivityName()
    {
        System.out.print("Entrez le nom de l'activite a modifier : ");
        return sc.nextLine().trim();
    }

    public String getUpdateNewName()
    {
        errorMessage();
        System.out.print("Entrez le nouveau nom (ou ENTREE directement pour conserver) : ");
        return sc.nextLine().trim();
    }

    public String getUpdateNewActivityType()
    {
        errorMessage();
        System.out.print("Entrez le nouveau type d'activite (ou ENTREE directement pour conserver) : ");
        return sc.nextLine().trim();
    }
    //fin update
}
