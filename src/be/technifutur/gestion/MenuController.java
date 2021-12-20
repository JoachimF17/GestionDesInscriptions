package be.technifutur.gestion;

import java.util.concurrent.Callable;

public class MenuController implements MenuNode
{
    //attributs
    private MenuView vue;
    private MenuModel model;

    //methodes
    //constructeur

    MenuController(MenuView vue, MenuModel model)
    {
        this.vue = vue;
        this.model = model;
    }

    //setters
    public void setView(MenuView vue)
    {
        this.vue = vue;
    }

    public void setModel(MenuModel model)
    {
        this.model = model;
    }
    //fin setters

    @Override public String getName()
    {
        return model.getName();
    }

    @Override public Callable getCallable()
    {
        //variables
        boolean inputInvalide = true;
        int input = 0;
        //objets
        MenuNode node;

        while(inputInvalide)
        {
            try
            {
                input = Integer.parseInt(this.vue.menuPrincipal(this.model));

                if(input >= 0 && input < model.getSize())
                    inputInvalide = false;
                else
                    this.vue.setError("nombre invalide");
            }catch(NumberFormatException e)
            {
                System.out.println("entrez bien un nombre !");
            }
        }

        node = this.model.getNode(input-1);

        this.vue.setError(null);

        //si l'utilisateur rentre un input invalide, la fonction getItem() renvoie 'null' par protecion
        if(node != null) //si l'input renvoie un item non 'null', on renvoie son runnableh
            return node.getCallable();
        else //sinon on renvoie null par protection
            return null;
    }
}
