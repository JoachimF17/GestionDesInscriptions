package be.technifutur.gestion.interfaces;

import java.util.concurrent.Callable;

public interface MenuNode
{
    String getName();
    Callable getCallable();
}
