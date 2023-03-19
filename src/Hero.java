public class Hero extends Character
{

    private int potions;
    private int maxHealth;


    public Hero(String name, int health, int damage, int armour, int potions)
    {
        super(name, health, damage, armour);
        this.potions = potions;
        this.maxHealth = health;

        //Add the players health for a potion
    }

    public void usePotion()
    {

        if (potions > 0)
        {
            this.health += 20;
            this.potions--;
            System.out.println(this.name + " used a potion and gained 20 health");
        } else
        {
            System.out.println(this.name + " does not have any potions left.");
        }

    }

    public int getMaxHealth()
    {
        return maxHealth;
    }
}







