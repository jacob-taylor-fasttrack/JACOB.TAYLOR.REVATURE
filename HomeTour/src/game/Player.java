package game;

import fixtures.Room;

public class Player {
//Room currentRoom : the room the player is currently in.
	public Room currentRoom;
	public Room move2;
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom, Room move2) {
		this.currentRoom=currentRoom;
		this.move2=move2;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom=currentRoom;
	}
	}
