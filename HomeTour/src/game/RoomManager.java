package game;

import fixtures.Room;

public class RoomManager {
	
	private static  Room foyer;
	private static   Room diningRoom ;
	private static  Room garage;
	private static  Room bathroom;
	public static   Room bedroom;
	public Room currentRoom;
	public Room[] rooms= {foyer, bathroom, garage, diningRoom,bedroom};
	
	
	public RoomManager(int roomCount) {
		super();
		rooms=new Room[roomCount];
	}

	public void init() {
	    Room foyer = new Room(
			"The Foyer",
			"a small foyer",
			"The center of the house with the entrance in the southeast corner\n To the north is the Bedroom and to the South is the garage of the house\n To the east is the dining room, and to the west you can find the fully furnished bathroom.");
			this.rooms[0] = foyer;
	        this.currentRoom = foyer;
	        
	        
	        Room bathroom = new Room(
	    			"The Bathroom",
	    			"a calm, peaceful Bathroom",
	    			"A fully furnished bathroom with jacuzzi style tub and a shower with\n sprinkler system coming from the top and the sides\n Head east to go back to the foyer when ready.");
	    			this.rooms[1] = bathroom;
	    	        
	    			 Room garage = new Room(
	    						"The Garage",
	    						"a spacious, loaded garage",
	    						"The garage can be found south of the foyer.\n The garage has all the tools for everyday housework\n and has two colorful Lamborghinis. ");
	    						this.rooms[2] = garage;
	    				        
	    			 Room diningRoom = new Room(
	    									"The Dining Room/Kitchen",
	    									"a tiled kitchen with full sized dining room",
	    									"The Dining room and kitchen can be found to the east of the foyer\n The kitchen comes with everything one would need to make a delicious meal\n The Dining room has a beautiful black chandelier over the dining table");
	    									this.rooms[3] = diningRoom;
	    							        
	    			
	    			Room bedroom = new Room(
	    						"The Bedroom",
	    						"a comfortable, isolated bedroom",
	    						"The bedroom can be found north of the foyer\n It comes equipped with a king size bed with silk sheets\nand all the things to occupy your time.");
	    						this.rooms[4] = bedroom;
	    						
	    						
	    	Room[] foyerExits= {bathroom, garage, diningRoom, bedroom,foyer};
	    	foyer.setExits(foyerExits);
	    	
	    	bathroom.setExits(foyer, 1);
	    	garage.setExits(foyer,2);
	    	diningRoom.setExits(foyer,3);
	    	bedroom.setExits(foyer,4);
	    				      }
	public   Room getExit(String roomName) { 
		//for (int i = 0; i <= 4; i++){
		roomName=roomName.toUpperCase();
	int	index =0;
		switch(roomName) {	
	
		case "BEDROOM":
			//return rooms[4];
			index=0;
			break;
		case "DINING ROOM":
		//return	rooms[3];
			index=1;
			break;
		case "GARAGE":
			//return rooms[2];
			index=2;
			break;
		case "BATHROOM":
		//return	rooms[1];
			index=3;
			break;
		case "FOYER":
		//return	rooms[0];
			index=4;
			break;
		
			}//return currentRoom;
		return rooms[index];
		}
		
	//}
	
	/*
	 * Method used to retrieve a single room based on it's
	 * name...
	 */
	
	// getters and setters
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public Room getRoom(int index,String roomName){
		return rooms[index];
	}
	
}
