package fixtures;



public class Room extends Fixture {
	public Room[] exits=new Room[6];
	

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[6]; // size is your choice
		
		
	}
		
	public Room[] getExits() {
		return this.exits;
	}
	public   Room getExit(String roomName) { 
		//for (int i = 0; i <= 5; i++){
		roomName=roomName.toUpperCase();
	int	index =0;
		switch(roomName) {	
	
		case "BEDROOM":
			//return rooms[4];
			index=3;
			break;
		case "BATHROOM":
		//return	rooms[3];
			index=0;
			break;
		case "GARAGE":
			//return rooms[2];
			index=1;
			break;
		case "DININGROOM":
		//return	rooms[1];
			index=2;
			break;
		case "FOYER":
		//return	rooms[0];
			index=4;
			break;
		
			}//return currentRoom;
		return exits[index];
		}
		
		

	
	// setter for exits
	public void setExits(Room[] exits) {
		this.exits = exits;
	}

	// Will allow us to set single exit based on index
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
		
	}

	public String getlongDescription() {
		
		return longDescription;
	}

	public String getshortDescription() {
		
		return shortDescription;
	}

	 
	
/*Room[] exits : the rooms adjacent to this one.
 *  You might decide that a room in a particular direction always uses a certain index,
 *   e.g. a north exit always goes in index 0, an east exit always goes in index 1, etc.
 *    If so, then the size of this array depends on how many directions you want to support*/
//create a getter not just for all the exits, but for a particular exit given a direction
}
