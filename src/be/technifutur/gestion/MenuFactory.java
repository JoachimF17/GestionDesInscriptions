package be.technifutur.gestion;

import be.technifutur.gestion.callables.CreerActivite;

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

    private Item getItemRetourMenuPrincipal()
    {
        return new Item("Retour menu principal", null);
    }

    private Item getItemCreerActivite()
    {
        return new Item("Creer une activite", new CreerActivite());
    }

    private Item getItemListeActivites()
    {
        return new Item("Afficher les activites", null);
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

        model.addNode(getItemCreerActivite());
        model.addNode(getItemListeActivites());

        model.addNode(getItemRetourMenuPrincipal());

        return model;
    }

    public MenuController getMenu()
    {
        return createMenu(getMenuPrincipal());
    }
}
