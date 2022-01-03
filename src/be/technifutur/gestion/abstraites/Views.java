package be.technifutur.gestion.abstraites;

import java.util.Scanner;

public class Views
{

    //attributs
    protected Scanner sc = new Scanner(System.in);
    protected String error;

    //methodes
    //setters
    public void setError(String error)
    {
        this.error = error;
    }
    //fin setters

    //affichage du message d'erreur
    protected void errorMessage()
    {
        if (this.error != null)
            System.out.printf("Erreur : %s%n", this.error);
    }
}
