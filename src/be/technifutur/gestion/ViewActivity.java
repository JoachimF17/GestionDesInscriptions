package be.technifutur.gestion;

import java.util.Scanner;

public class ViewActivity
{
    //attributs
    Scanner input = new Scanner(System.in);

    //methodes
    public String menuActivite()
    {
        System.out.println("Gestion des activites");
        System.out.println("---------------------");
        System.out.println("1. Creer activite");
        System.out.println("2. Afficher activites");

        return this.input.nextLine();
    }
}
