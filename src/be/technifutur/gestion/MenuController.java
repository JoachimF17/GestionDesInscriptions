package be.technifutur.gestion;

public class MenuController
{
    //attributs
    private MenuView vue;

    //methodes
    //setters
    public void setView(MenuView vue)
    {
        this.vue = vue;
    }
    //fin setters

    public void afficheMenuPrincipal()
    {
        //variables
        boolean inputInvalide = true;
        int input = 0;
        //objets
        this.setView(new MenuView());



        while(inputInvalide)
        {
            try
            {
                input = Integer.parseInt(this.vue.menuPrincipal());

                inputInvalide = false;
            }catch(NumberFormatException e)
            {
                System.out.println("Erreur : entrez bien un nombre !");
            }
        }

        System.out.println("Vous avez entré : "+input);
    }
}
