package be.technifutur.gestion;

public class Main
{
    public static void main(String[] args)
    {
        MenuFactory mf = new MenuFactory();
        MenuController controller = mf.getMenu();

        controller.getCallable();
    }
}
