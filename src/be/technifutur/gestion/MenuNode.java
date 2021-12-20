package be.technifutur.gestion;

import java.util.concurrent.Callable;

public interface MenuNode
{
    String getName();
    Callable getCallable();
}
