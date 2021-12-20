package be.technifutur.gestion;

import java.util.Scanner;

public class ActivityView
{
    //attributs
    Scanner sc = new Scanner(System.in);

    //methodes
    public String activityName()
    {
        System.out.println("Creer une activite");
        System.out.println("------------------");
        System.out.print("Entrez le nom de l'activite : ");
        return sc.nextLine();
    }

    public String activityRegistration()
    {
        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n) : ");
        return sc.nextLine();
    }
}
