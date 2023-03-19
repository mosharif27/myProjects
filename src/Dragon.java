import java.util.Random;

public class Dragon extends Character
{

    String type = "Dragon";

    public Dragon(String name, int health, int maxDamage, int armour)
    {
        super(name, health, maxDamage, armour );

        Random rnd = new Random();
        int chance = rnd.nextInt(30);
        this.health = 90 + chance;

    }

    @Override
    public void DeathSpeech()
    {
        System.out.println(name + "'s last words are. ");

        String speech = "";

        Random rnd = new Random();
        int chance = rnd.nextInt(10);

        switch(chance)
        {
            case 0:
            case 1:
            case 2:
            case 3:
                speech = "*cough* *Splutter* That's it... I'm done for!";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                speech = "I'll be back ----------------";
                break;
            case 9:
                speech = "Enough!";
                break;
            default:
                speech = "-------- We should never see this --------";

        }

        System.out.println(speech);


    }

    @Override
    public void VictorySpeech()
    {
        System.out.println(name + " is victorious and screams...");
        System.out.println("Is there no one good enough to defeat me!\n");
    }

    @Override
    public void AttackSpeech(String target, int damage)
    {
        System.out.printf("%s attacks %s for %d damage %n", this.name, target, damage );

    }
}