package be.technifutur.gestion.menu;

import java.util.concurrent.Callable;

public interface MenuNode
{
    String getName();
    Callable getCallable();
}
