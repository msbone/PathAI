package net.msbone.pathfinder;

import org.newdawn.slick.*;

public class Game extends BasicGame
{
 
	private MapClass kart = new MapClass();
	private Bot bot = new Bot();
	
  public Game()
  {
     super("My path World");
  }
 
  @Override
  public void init(GameContainer gc) throws SlickException
  {
 kart.generateMap();
 bot.init();
  }
 
  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {
	  
  }
  
@Override
public void mousePressed(int button, int x, int y) {
	if(y > 800 && y < 850 && x > 10 && x < 160) {
	System.out.println("New World?");
		kart.generateMap();
	}
	
	else if(y > 800 && y < 850 && x > 170 && x < 320) {
	System.out.println("Reset player");
		bot.posX = 1;
		bot.posY = 1;
		bot.lastWay = "none";
	}
	
	else if(x/48 > 15 || y/48 > 15) {
			System.out.println("You pressed outside the box :P");
		}
		else {
		bot.canIgoTo(x/48, y/48, kart.map);
		}
	}
  
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
	kart.renderMap(g);
	bot.Render();
	g.drawRect(10, 800, 150, 50);
	g.drawString("New World", 15, 810);
	g.drawRect(170, 800, 150, 50);
	g.drawString("Reset player", 175, 810);
  }
 
  public static void main(String[] args) throws SlickException
  {
     AppGameContainer app = new AppGameContainer(new Game());
 
     app.setDisplayMode(800, 900, false);
     app.start();
  }
}