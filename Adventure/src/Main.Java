import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		String[] enemies = { "skeleton", "zombie", "ghoul", "goblin" };
		int maxEnemyHealth = 100;
		int enemyAttackDamage = 25;

		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 5;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50;

		boolean running = true;

		System.out.println("You have entered the Dungeon!");

		GAME: while (running) {

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# A " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				System.out.println("\tYour HP is: " + health);
				System.out.println("\tThe " + enemy + "'s HP is: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do next?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink");
				System.out.println("\t3. Run");

				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					health -= damageTaken;

					System.out.println("\t> You hit the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You take " + damageTaken + " damage from the enemy.");

					if (health < 1) {
						System.out.println("\t> You have taken1 too much damage and collapse.");
						break;
					}
				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> You drink a health potion, healing yourself for "
								+ healthPotionHealAmount + "." + "\n\t> You now have " + health + "HP."
								+ "\n\t> You have " + numHealthPotions + " health potions left.\n");
					} else {
						System.out.println(
								"\t> You have no health potions left.  Kill an enemy for a chance to get one.");
					}
				} else if (input.equals("3")) {
					System.out.println("\tYou run away from the " + enemy + ".");
					continue GAME;

				} else {
					System.out.println("\tInvalid command");
				}
			}

			if (health < 1) {
				System.out.println("You are now a corpse.");
				break;
			}

			System.out.println(" # The " + enemy + " was killed. # ");
			System.out.println(" # You have " + health + " HP left. # ");
			if (rand.nextInt(100) > healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion. # ");
				System.out.println(" # You have " + numHealthPotions + " health potion(s). # ");
			}
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");

			String input = in.nextLine();

			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invlid command.");
				input = in.nextLine();
			}

			if (input.equals("1")) {
				System.out.println("You continue on your adventure.");
			} else if (input.equals("2")) {
				System.out.println("You exit the dungeon victorious.");
				break;
			}
		}

		System.out.println(" # THANKS FOR PLAYING # ");
	}
}
