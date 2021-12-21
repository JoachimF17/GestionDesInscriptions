package be.technifutur.gestion.menu;

import be.technifutur.gestion.activity.ActivityAdd;
import be.technifutur.gestion.activity.ActivityModify;
import be.technifutur.gestion.activity.ActivityRemove;

public class MenuFactory
{
    private MenuController createMenu(MenuModel model)
    {
        return new MenuController(new MenuView(), model);
    }

    private Item getItemQuitter()
    {
        return new Item("Quitter", null);
    }

    private Item getItemActivityAdd()
    {
        return new Item("Creer type d'activite", new ActivityAdd());
    }

    private Item getItemActivityModify()
    {
        return new Item("Modifier l'activite", new ActivityModify());
    }

    private Item getItemActivityRemove()
    {
        return new Item("Supprimer l'activite", new ActivityRemove());
    }

    //menus
    private MenuModel getMenuPrincipal()
    {
        MenuModel model = new MenuModel("Menu principal");

        model.addNode(createMenu(getMenuActivites()));

        model.addNode(getItemQuitter());

        return model;
    }

    private MenuModel getMenuActivites()
    {
        MenuModel model = new MenuModel("Gestion des activites");

        model.addNode(getItemActivityAdd());
        model.addNode(getItemActivityModify());
        model.addNode(getItemActivityRemove());

        model.addNode(getItemQuitter());

        return model;
    }

    public MenuController getMenu()
    {
        return createMenu(getMenuPrincipal());
    }
}
