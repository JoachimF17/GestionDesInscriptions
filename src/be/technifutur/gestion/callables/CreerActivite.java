package be.technifutur.gestion.callables;

import be.technifutur.gestion.ActivityType;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class CreerActivite implements Callable
{
    @Override public Object call() throws Exception
    {
        //variables
        boolean registration = false;
        //objets
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println("Creer une activite");
        System.out.println("------------------");
        System.out.print("Entrez le nom de l'activite : ");
        name = sc.nextLine();
        System.out.print("Est-ce qu'une inscription est obligatoire ? (o/n)");

        if(sc.nextLine().toLowerCase().charAt(0) == 'o')
            registration = true;

        return null;
    }
}
