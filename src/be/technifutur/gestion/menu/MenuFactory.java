package be.technifutur.gestion.menu;

import be.technifutur.gestion.activity.*;
import be.technifutur.gestion.schedule.Schedule;
import be.technifutur.gestion.schedule.ScheduleCreate;
import be.technifutur.gestion.schedule.ScheduleView;

public class MenuFactory
{
    //attributs
    private ListActivityType listActivityType;
    private Schedule horaire;

    //methodes
    //constructeur
    public MenuFactory(ListActivityType listActivityType)
    {
        this.listActivityType = listActivityType;
    }

    private MenuController createMenu(MenuModel model)
    {
        return new MenuController(new MenuView(), model);
    }

    private Item getItemQuitter()
    {
        return new Item("Quitter", null);
    }

    private Item getItemActivityCreate()
    {
        return new Item("Creer type d'activite", new ActivityCreate(this.listActivityType, new ActivityView()));
    }

    private Item getItemActivityRead()
    {
        return new Item("Afficher les types d'activites", new ActivityRead(this.listActivityType, new ActivityView()));
    }

    private Item getItemActivityUpdate()
    {
        return new Item("Modifier le type d'activite", new ActivityUpdate(this.listActivityType, new ActivityView()));
    }

    private Item getItemActivityDelete()
    {
        return new Item("Supprimer le type d'activite", new ActivityDelete(this.listActivityType, new ActivityView()));
    }

    private Item getItemScheduleCreate()
    {
        return new Item("Ajouter une activite", new ScheduleCreate(horaire, new ScheduleView(), listActivityType));
    }

    //menus
    private MenuModel getMenuPrincipal()
    {
        MenuModel model = new MenuModel("Menu principal");

        model.addNode(createMenu(getMenuActivites()));
        model.addNode(createMenu(getMenuHoraire()));

        model.addNode(getItemQuitter());

        return model;
    }

    private MenuModel getMenuActivites()
    {
        MenuModel model = new MenuModel("Gestion des activites");

        model.addNode(getItemActivityCreate());
        model.addNode(getItemActivityRead());
        model.addNode(getItemActivityUpdate());
        model.addNode(getItemActivityDelete());

        model.addNode(getItemQuitter());

        return model;
    }

    private MenuModel getMenuHoraire()
    {
        MenuModel model = new MenuModel("Gestion des horaires");

        model.addNode(getItemScheduleCreate());

        model.addNode(getItemQuitter());

        return model;
    }

    public MenuController getMenu()
    {
        return createMenu(getMenuPrincipal());
    }
}
