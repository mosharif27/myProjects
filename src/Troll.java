public class Troll extends Character
{

    private String type = "Troll";

    public Troll(String name, int health, int maxDamage, int armour)
    {

        super(name, health, maxDamage, armour);



    }

    public void DeathSpeech()
    {
        System.out.println(name + "'s lasts words are.  ");
        System.out.println("*coughs* i have been defeated...");



    }

    public void VictorySpeech(){

        System.out.println(name + " is Victorious");
        System.out.println("You was no match for me ");

    }

    public void AttackSpeech(String target, int damage)
    {
        System.out.printf("%s the %s attacks %s for %d damage %n", this.name, this.type, target, damage);

    }
}
