package be.technifutur.gestion;

public class ControllerActivity
{
    //attributs
    ViewActivity vue;

    //methodes
    public void saisirMenu()
    {
        //variables
        int input = 0;
        boolean inputInvalide = true;
        //objets

        while(inputInvalide)
        {
            try
            {
                input = Integer.parseInt(this.vue.menuActivite());

                inputInvalide = false;
            }catch(NumberFormatException e)
            {
                System.out.println("Pas un nombre");
            }
        }
    }
}
