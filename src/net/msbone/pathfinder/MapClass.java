package net.msbone.pathfinder;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MapClass {
	
	public int mapSize = 16;
	public String[][] map = new String[mapSize][mapSize];
	
	private Image grass;
	private Image dirt;
	private Image stone;
	
	private  Random generator = new Random();
	
	public void generateMap() {
		try {
			grass = new Image("res/grass.png");
			dirt = new Image("res/dirt.png");
			stone = new Image("res/stone.png");
		} catch (SlickException e) {
			System.out.print("Error");
		}
		
		for(int x = 1; x < mapSize; x = x+1) {
			for(int y = 1; y < mapSize; y = y+1) {
				if(x == 1 && y == 1) {
					map[x][y] = "G";
				}
				else {
				int type = generator.nextInt(4);
				if(type == 0) {
					map[x][y] = "G";	
				}
				else if(type == 1) {
					map[x][y] = "D";	
				}
				else if(type == 2) {
					map[x][y] = "S";	
				}
				else if(type == 3) {
					map[x][y] = "G";	
				}
		      }	   		
	      }	
		}
	}
	
	public void renderMap(Graphics g) {
		for(int x = 1; x < mapSize; x = x+1) {
			for(int y = 1; y < mapSize; y = y+1) {
		        if(map[x][y] == "G") {
		        	grass.draw(x*mapSize*3, y*mapSize*3 , 3);
		        }
		        else if(map[x][y] == "D") {
		        	dirt.draw(x*mapSize*3, y*mapSize*3 , 3);
		        }
		        else if(map[x][y] == "S") {
		        	stone.draw(x*mapSize*3, y*mapSize*3 , 3);
		        }
		      }	   		
	      }	
	}
	
}
