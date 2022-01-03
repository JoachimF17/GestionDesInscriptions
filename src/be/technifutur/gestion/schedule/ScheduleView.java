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
        System.out.print("Entrez l'horaire du debut de l'activite (format : JJ/MM/AAAA H:M) : ");
        return sc.nextLine().trim();
    }

    public String createDateTimeFin()
    {
        System.out.print("Entrez l'horaire de fin de l'activite (format : JJ/MM/AAAA H:M) : ");
        return sc.nextLine().trim();
    }

    public String createName()
    {
        System.out.print("Entrez le nom de l'activite : ");
        return sc.nextLine().trim();
    }

    public String createActivityType()
    {
        System.out.println("Entrez le nom du type d'activite : ");
        return sc.nextLine().trim();
    }
    //fin create
}
