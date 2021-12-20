package be.technifutur.gestion;

import java.util.Scanner;

public class MenuView
{
    //attributs
    private Scanner input = new Scanner(System.in);

    //methodes
    public String menuPrincipal()
    {
        System.out.println("Menu principal");
        System.out.println("--------------");
        System.out.println("1. Gerer activite");
        System.out.println("9. Quitter");
        System.out.print("Entrez votre choix : ");

        return this.input.nextLine();
    }
}
