package ai_game;

import java.awt.*;

public class Player extends GameObject {
  
//  Random r = new Random();
  Handler handler;
  GameObject trapdoor; // = new Trapdoor();
  GameObject ricochet;
//  Ricochet ricochet;
  GameObject smartenemy;
  Color color = new Color(75, 0, 130);
  
  public Player(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;
    
    // to id trapdoor:
    for (int i = 0; i < handler.object.size(); i++) {
      if (handler.object.get(i).getId() == ID.Trapdoor)
        trapdoor = handler.object.get(i);
    }
    
    // to id ricochet:
    for (int i = 0; i < handler.object.size(); i++) {
      if (handler.object.get(i).getId() == ID.Ricochet)
        ricochet = handler.object.get(i);
    }
    
//    // to id smartenemy:
//    for (int i = 0; i < handler.object.size(); i++) {
//      if (handler.object.get(i).getId() == ID.SmartEnemy)
//        smartenemy = handler.object.get(i);
//    }
  }
  
  // for collision detection of trapdoor
  public Rectangle getBounds() {
    return new Rectangle((int) x, (int) y, 48, 48);
//    return new Rectangle((int)x - 16, (int)y - 16, 200, 200);
  }  
  
  // for collision detection of enemies
  public Rectangle getTooCloseBounds() {
//    return new Rectangle((int) x, (int) y, 48, 48);
    return new Rectangle((int)x - 75, (int)y - 80, 200, 200);
  }  
  
  public void tick() {
    x += velX;
    y += velY;
    
    // **** agent trapdoor AI:
    float diffX = x - trapdoor.getX() - 0.5f;
    float diffY = y - trapdoor.getY() - 0.5f;
    float distance = (float) Math.sqrt((x - trapdoor.getX()) * (x - trapdoor.getX()) 
                                     + (y - trapdoor.getY()) * (y - trapdoor.getY()));
    
    velX = ((-1 / distance) * diffX);
    velY = ((-1 / distance) * diffY);
    // ****
    
//    x = Game.clamp(x, 0, Game.WIDTH - 32);
//    y = Game.clamp(y, 0, Game.HEIGHT - 55);

    x = Game.clamp(x, 0, Game.WIDTH - 48);
    y = Game.clamp(y, 0, Game.HEIGHT - 70);

    // trails:
//    handler.addObject(new Trail(x, y, ID.Trail, color, 48, 48, 0.04f, handler));
    
    tooClose();
  }
  
  // agent avoid enemy AI:
  public void tooClose() {
    
    x += velX;
    y += velY;
    
    ricochet = handler.object.get(2);
    if (getTooCloseBounds().intersects(ricochet.getBounds())) {
      // too close action:
      float diffX = x - ricochet.getX() - 1f;
      float diffY = y - ricochet.getY() - 1f;
      float distance = (float) Math.sqrt((x - ricochet.getX()) * (x - ricochet.getX()) 
                                       + (y - ricochet.getY()) * (y - ricochet.getY()));

      velX = ((1 / distance) * diffX);
      velY = ((1 / distance) * diffY);
    }
    
//    smartenemy = handler.object.get(1);
//    if (getBounds().intersects(smartenemy.getBounds())) {
//      // too close action:
//      float diffX = x - smartenemy.getX() - 0.5f;
//      float diffY = y - smartenemy.getY() - 0.5f;
//      float distance = (float) Math.sqrt((x - smartenemy.getX()) * (x - smartenemy.getX()) 
//                                       + (y - smartenemy.getY()) * (y - smartenemy.getY()));
//
//      velX = ((1 / distance) * diffX);
//      velY = ((1 / distance) * diffY);
//    }
      
//    for (int i = 0; i < handler.object.size(); i++) {
//      GameObject tempObject = handler.object.get(i);
//      if (tempObject.getId() == ID.Ricochet) { // tempObject is now Ricochet
//        if (getBounds().intersects(tempObject.getBounds())) {
//          // too close action:
//          float diffX = x - ricochet.getX() - 0.5f;
//          float diffY = y - ricochet.getY() - 0.5f;
//          float distance = (float) Math.sqrt((x - ricochet.getX()) * (x - ricochet.getX()) 
//                                           + (y - ricochet.getY()) * (y - ricochet.getY()));
//    
//          velX = ((1 / distance) * diffX);
//          velY = ((1 / distance) * diffY);
//        }
//      }
//    } // end Ricochet reaction

//    for (int i = 0; i < handler.object.size(); i++) {
//      GameObject tempObject = handler.object.get(i);
//      if (tempObject.getId() == ID.SmartEnemy) { // tempObject is now SmartEnemy
//        if (getBounds().intersects(tempObject.getBounds())) {
//          // too close action:
//          float diffX = x - smartenemy.getX() - 0.5f;
//          float diffY = y - smartenemy.getY() - 0.5f;
//          float distance = (float) Math.sqrt((x - smartenemy.getX()) * (x - smartenemy.getX()) 
//                                           + (y - smartenemy.getY()) * (y - smartenemy.getY()));
//    
//          velX = ((1 / distance) * diffX);
//          velY = ((1 / distance) * diffY);
//        }
//      }
//    } // end SmartEnemy reaction 
  }
  
//  public void collision() {
//    for (int i = 0; i < handler.object.size(); i++) {
//      GameObject tempObject = handler.object.get(i);
//      if (tempObject.getId() == ID.Trapdoor) { // tempObject is now BasicEnemy
//        if (getBounds().intersects(tempObject.getBounds())) {
//          // collision code:
////          HeadsUpDisplay.HEALTH -= 2;
//          handler.removeObject(tempObject);
////          handler.addObject(new Player(this.getX(), this.getY(), ID.Player, handler));
//        }
//      }
//    }
//  }
  
  public void render(Graphics g) {
    // show bounding box for collision detection:
//    Graphics2D g2d = (Graphics2D) g;
//    g.setColor(Color.yellow);
//    g2d.draw(getTooCloseBounds());
    
    g.setColor(color);
    g.fillOval((int) x,(int) y, 48, 48);
//    g.fillRect((int) x,(int) y, 48, 48);
  }
}
