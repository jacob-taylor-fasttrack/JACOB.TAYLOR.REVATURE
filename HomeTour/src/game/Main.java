package game;
import game.RoomManager;
import java.util.Scanner;

import fixtures.Fixture;
import fixtures.Room;

public class Main {
private static RoomManager manager = new RoomManager(6);
	
	// Boolean used to control when our game is running. We set it to true initially
	private static boolean running = true;
	
	
	public static void main(String[] args) {
		manager.init();	
		
		Player player = new Player();
		//Room move2=manager.getExit();
		// The player should start in the 'starting room'
		player.setCurrentRoom(manager.getCurrentRoom());
				
				while (running) {
					 Main.printRoom(player);
					String[] input = Main.collectInput();
					Main.parse(input, player);
				}
				if (!running) {
					System.out.println("Thanks for playing");
				}

	}
	/*printRoom(Player) method will print a prompt to the console for the player's current room,
	 *  similar to the above image	*/
	private static  void printRoom (Player player) {
		System.out.println("This is the HOME TOUR");
		System.out.println("---CURRENT ROOM---");
		System.out.println("Name: "+player.getCurrentRoom().getName());
		System.out.println("Short Description: "+player.getCurrentRoom().getshortDescription());
		System.out.println("Long Description: "+player.getCurrentRoom().getlongDescription());
		System.out.println("The home is set up with the foyer in the center");
		System.out.println("To the North is the Bedroom and to the South is the Garage");
		System.out.println("To the East is the Dining Room and to the West is the Bathroom ");

	}
/*collectInput() method will use a Scanner object to collect console input from the user,
 *  and then will divide that input into multiple parts.
 *  Generally those parts will look like this:

An action
The target of an action (if any)*/
	private static String[] collectInput() {
		Scanner scanner= new Scanner(System.in);
		String input=scanner.nextLine();
		
		String[] phrase=input.split(" ");
		return phrase;
	}
	/*parse(String[], Player) method will take the output of the above collectInput() method
	 *  and a player object, and will resolve that command. This can actually be simpler than it 
	 *  sounds - the first index of the passed-in String[] should be the action, 
	 *  so you can switch on that and handle the target differently for each case. 
	 *  The Player object is there so you can modify it if needed (like changing the Player's 
	 *  currentRoom based on the direction moved)*/	
	private static void parse(String[] command, Player player) {
		String action=command[0].toUpperCase().intern();
		String option=null;
		
		if(command.length>1) {
			option=command[1].toUpperCase().intern();
		}
		
		if(action=="GO"|action=="HEAD") {
			System.out.println("You want to move:"+option);
			Room move=  player.getCurrentRoom().getExit(option);
			//Room move2=player.getExit(option);
			
			
			
			player.setCurrentRoom(move);
			
		}else if (action=="Quit"){
			running=false;
		}

	
}}
