package be.technifutur.gestion.schedule;

import java.util.Scanner;

public class ScheduleView
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
    //fin create

    //affichage du message d'erreur
    private void errorMessage()
    {
        if (this.error != null)
            System.out.printf("Erreur : %s%n", this.error);
    }
}
