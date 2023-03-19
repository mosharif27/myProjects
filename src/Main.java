import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner keyscan = new Scanner(System.in);

        System.out.println(Ccol.RED + "BingoBangoBongo" + Ccol.RESET);

        ArrayList<Character> monsterList = new ArrayList<Character>();
        Hero Player = new Hero("Lee", 150, 35, 15, 3);

        // TODO please change the constructors to better reflect what we we need
        monsterList.add(new Goblin("Clive", 100, 10, 55));
        monsterList.add(new Orc("Weavle", 100, 10, 55));
        monsterList.add(new Dragon("Praug", 100, 10, 55));

        System.out.printf("%n%n********** %s Begins the Arena Challenge **********%n%n", Player.name);
        System.out.printf("...Can %s defeat the %d monsters that await?%n%n", Player.name, monsterList.size());

        // Go through all the monsters and battle them
        for(int i  = 0; i < monsterList.size(); i++)
        {
            // welcome the monster to the arena
            monsterList.get(i).EntranceSpeech();

            if(i == monsterList.size() -1)
            {
                System.out.printf("%n*** %s faces the final monster! ***%n%n", Player.getName());
            }

            do
            {
                Player.Attack(monsterList.get(i));
                if (monsterList.get(i).isAlive())
                {
                    monsterList.get(i).Attack(Player);
                }

                Player.ShowHealth();
                monsterList.get(i).ShowHealth();

                System.out.println(Ccol.YELLOW + "\n*** Next Round ***\n" + Ccol.RESET);

            } while (Player.isAlive() && monsterList.get(i).isAlive());

            if(Player.isDead())
            {
                break;
            }

            System.out.println("Press enter key to continue");
            keyscan.nextLine();

            Player.DisplayInfo();
            monsterList.get(i).DisplayInfo();


            System.out.println( Ccol.RED_BOLD + "------   A Battle Ends   -------" + Ccol.RESET);

            // If the player is at half their health then quaff a potion
            Player.NeedsHeal();

        }

        if(Player.isAlive())
        {
            // TODO get the Player to display a winning image - maybe fireworks?
            Player.ShowVictoryPic();
            System.out.printf(Ccol.CYAN_BOLD + "%s is crowned Champion of the Arena! %n", Player.getName() + Ccol.RESET);
        }
        System.out.println("Game Over");

    }
}