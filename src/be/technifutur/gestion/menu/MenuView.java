package be.technifutur.gestion.menu;

import be.technifutur.gestion.menu.MenuModel;

import java.util.Scanner;

public class MenuView
{
    //attributs
    private Scanner input = new Scanner(System.in);
    private String error = null;

    //methodes
    public String menuPrincipal(MenuModel model)
    {
        //variables
        int i;
        //objets
        String afficheMenu = "-";

        //affichage
        System.out.println(model.getName());
        System.out.println(afficheMenu.repeat(model.getName().length()));

        //boucle qui renvoie le name de chaque node
        for(i = 0; i < model.getSize(); i++)
            System.out.println((i+1)+". "+model.getNode(i).getName());

        if(this.error != null)
            System.out.println("Erreur : "+error);

        //on demande l'input a l'utilisateur
        System.out.print("Entrez le nombre correspondant : ");

        //on renvoie l'input, la verif se fera dans le controller et pas dans la vue
        return this.input.nextLine();
    }

    public void setError(String error)
    {
        this.error = error;
    }
}
