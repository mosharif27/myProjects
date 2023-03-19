import java.util.Random;


public class Character
{
    protected String name;
    protected int health;
    protected int maxDamage;
    protected int armour;


     Character(String name, int health, int maxDamage, int armour)
    {
        this.name = name;
        this.health = health;
        this.maxDamage = maxDamage;
        this.armour = armour;

    }

    public void EntersArena(){

        System.out.println("====================================");
        System.out.printf("%s Enters the Arena and says  %n");
        System.out.printf("I am here to win %n");
        System.out.println("///////////////////////////////////");

    }

    public void Attack(Character enemy)
    {

        Random rnd = new Random();
        int damage = rnd.nextInt(maxDamage) + 1;

        AttackSpeech(enemy.name, damage);

        enemy.receiveAttack(damage);

        if(enemy.isDead()){
            System.out.println("You have been defeated");
        }

    }
        // get random number between 1-100 if it is more than the armour allow the damage to happen

    public void receiveAttack(int damage)
    {
        Random rnd = new Random();
        int chance = rnd.nextInt(100) + 1;

        if(chance < armour){
            System.out.println("No damage has been negated from the armour");
        }
        else
        {
            health -= damage;
            health = health - armour;
        }
        System.out.println(name + " has blocked " + armour + " damage");

        if (health <= 0)
        {
            health = 0;
            System.out.println(name + " dies a horrible death!");
            DeathSpeech();


        }

    }

    //public void Armour(int damage){

       // health = health - armour;

        //System.out.println(name + " has blocked " + armour + "damage");

   // }

    public void DisplayInfo()
    {
        System.out.printf("%12s Health:[%3d] Max Damage: %2d Armour: %3d %n",
                name, health, maxDamage, armour);
    }

    public void ShowHealth()
    {
        System.out.printf("%s Health:[%3d] %n", name, health);

    }

    public boolean isDead()
    {
        if (health <= 0)
        {
            return true;
        }
        return false;
    }

    public boolean isAlive()
    {
        if (health > 0)
        {
            return true;
        }
        return false;
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
        System.out.printf("%s attacks %s for %d damage %n", this.name, target, damage);

    }

    public String getName(){

        return name;
    }
    public int getHealth(){

         return health;
    }




}


