package be.technifutur.gestion;

public class Main
{
    public static void main(String[] args)
    {
        int i;
        ActivityController ac = new ActivityController();
        ac.setListe(new ListActivityType());
        ac.setVue(new ActivityView());

        for(i = 0; i < 10; i++)
        try
        {
            ActivityType activite = ac.call();
            System.out.println(activite);
        }catch(Exception e)
        {
            System.out.println("test");
        }
    }
}
