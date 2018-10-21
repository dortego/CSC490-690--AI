package ai_game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
  
  Random r = new Random();
  Handler handler;
  
  public Player(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;
  }
  
  public Rectangle getBounds() {
    return new Rectangle((int) x, (int) y, 32, 32);
  }  
  
  public void tick() {
    x += velX;
    y += velY;
    
    x = Game.clamp(x, 0, Game.WIDTH - 32);
    y = Game.clamp(y, 0, Game.HEIGHT - 55);
    
    // trails:
    handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 32, 32, 0.08f, handler));
    
//    collision();
  }
  
//  public void collision() {
//    for (int i = 0; i < handler.object.size(); i++) {
//      GameObject tempObject = handler.object.get(i);
//      if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.SmartEnemy) { // tempObject is now BasicEnemy
//        if (getBounds().intersects(tempObject.getBounds())) {
//          // collision code:
//          HeadsUpDisplay.HEALTH -= 2;
//        }
//      }
//    }
//  }
  
  public void render(Graphics g) {
    // show bounding box for collision detection:
//    Graphics2D g2d = (Graphics2D) g;
//    g.setColor(Color.blue);
//    g2d.draw(getBounds());
    
    g.setColor(Color.cyan);
    g.fillRect((int) x,(int) y, 32, 32);
  }
}
