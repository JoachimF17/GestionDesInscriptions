package be.technifutur.gestion;

import java.util.ArrayList;

public class MenuModel
{
    //attributs
    ArrayList<MenuNode> liste = new ArrayList<>();
    String name;

    //methodes
    //getters
    public String getName()
    {
        return this.name;
    }
    //fin getters

    //constructeur
    MenuModel(String name)
    {
        this.name = name;
    }

    public void addNode(MenuNode node)
    {
        if(node != null)
            this.liste.add(node);
    }

    public MenuNode getNode(int i)
    {
        if(i > getSize() || i < 0)
            return null;
        else
            return this.liste.get(i);
    }

    public int getSize()
    {
        return this.liste.size();
    }
}
