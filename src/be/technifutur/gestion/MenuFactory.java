package be.technifutur.gestion;

import be.technifutur.gestion.callables.ActivitesMenu;

import java.util.concurrent.Callable;

public class MenuFactory
{
    private Item createItem(String name, Callable action)
    {
        return new Item(name, action);
    }

    private MenuController createMenu(MenuModel model)
    {
        return new MenuController(new MenuView(), model);
    }

    private Item getItemQuitter()
    {
        return new Item("Quitter", null);
    }

    private Item getItemActivites()
    {
        return new Item("Gestion des activites", new ActivitesMenu());
    }

    //menus
    private MenuModel getMenuPrincipal()
    {
        MenuModel model = new MenuModel("Menu principal");

        model.addNode(getItemActivites());

        model.addNode(getItemQuitter());

        return model;
    }

    private MenuModel getMenuActivites()
    {
        
    }

    public MenuController getMenu()
    {
        return createMenu(getMenuPrincipal());
    }
}
