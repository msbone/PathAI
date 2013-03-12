package net.msbone.pathfinder;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bot {

	public int posX = 1;
	public int posY = 1;
	
	public String lastWay = "none";
	
	private Image player;
	
	public void init() {
		try {
			player = new Image("res/player.png");
		} catch (SlickException e) {
			System.out.print("Error");
		}
		
	}
	
	public void Render() {
		player.draw(posX*48, posY*48, 3);
	}
	
	public void Update(){
		
		
	}
	
	public void canIgoTo(int moveX, int moveY, String[][] kart) {
		//Check if it is posiable to walk to the destinaded positon
		
		if(moveX == posX && moveY == posY) {
			System.out.println("I am here master");
			return;
		}
		
		//Start by see if the block around me is posiable to walk, then see if we get any closer to the final destination
		int frontX = posX;
		int frontY = posY+1;
		
		int backX = posX;
		int backY = posY-1;
		
		int leftX = posX+1;
		int leftY = posY;
		
		int rightX = posX-1;
		int rightY = posY;
		
		int beforeDistance = distance(posX, posY, moveX, moveY);
		System.out.println("Old distance is "+beforeDistance);
		
		int bestDistance = 1000;
		String bestWay = "none";
		
		if(isWalkeable(frontX, frontY, kart)) {
			int newdistance = distance(frontX, frontY, moveX, moveY);
			System.out.println("Can go down, with a distance of " + newdistance);
			if(bestDistance > newdistance && lastWay != "up") {
				bestDistance =  newdistance;
				bestWay = "down";
			}
		}
		if(isWalkeable(backX, backY, kart)) {
			int newdistance = distance(backX, backY, moveX, moveY);
			System.out.println("Can go up, with a distance of " + newdistance);
			if(bestDistance > newdistance && lastWay != "down") {
				bestDistance =  newdistance;
				bestWay = "up";
			}
		}
		if(isWalkeable(leftX, leftY, kart)) {
			int newdistance = distance(leftX, leftY, moveX, moveY);
			System.out.println("Can go left, with a distance of " + newdistance);
			if(bestDistance > newdistance && lastWay != "right") {
				bestDistance =  newdistance;
				bestWay = "left";
			}
		}
		if(isWalkeable(rightX, rightY, kart)) {
			int newdistance = distance(rightX, rightY, moveX, moveY);
			System.out.println("Can go right, with a distance of " + newdistance);
			if(bestDistance > newdistance && lastWay != "left") {
				bestDistance =  newdistance;
				bestWay = "right";
			}
		}
		
		//Find the best way to go
		System.out.println(bestWay);
		lastWay = bestWay;
		if(bestWay == "down") {
			//Move down
			posY ++;
		}
		if(bestWay == "up") {
			//Move up
			posY --;
		}
		if(bestWay == "left") {
			//Move left
			posX ++;
		}
		if(bestWay == "right") {
			//Move right
			posX --;
		}
		
	}
	
	public int distance(int x, int y, int movex, int movey) {
		int distanceX = x - movex;
		int distanceY = y - movey;
		//Convert if negative
		if(distanceX < 0) {
			//Convert to +
			distanceX = distanceX + (2*(-1*distanceX));
		}
		if(distanceY < 0) {
			//Convert to +
			distanceY = distanceY + (2*(-1*distanceY));
		}
		
		int totalDistance = distanceX+distanceY;
		
		return totalDistance;
	}
	
	public boolean isWalkeable(int x, int y, String[][] kart) {
		if(x > 15) {
			return false;
		}
		else if(y > 15) {
			return false;
		}
		
		else if(kart[x][y] == "G") {
			return true;
		}
		else if(kart[x][y] == "D") {
			return true;
		}
		return false;
	}
	
}
