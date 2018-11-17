package ai_game;

import static ai_game.Game.HEIGHT;
import static ai_game.Game.WIDTH;
import java.awt.*;
import java.security.SecureRandom;

public class Trapdoor extends GameObject {
  
  private Handler handler;
  private SecureRandom r;
  private int count;
  Color color = new Color(255, 150, 0);
  
  public Trapdoor(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;
  }
  
  // for collision detection
  public Rectangle getBounds() {
    return new Rectangle((int) x + 4, (int) y + 4, 40, 40);
  }  

  public void collision() {
    r = new SecureRandom();
    for (int i = 0; i < handler.object.size(); i++) {
      GameObject tempObject = handler.object.get(i);
      if (tempObject.getId() == ID.Player) { // tempObject is now Player
        if (getBounds().intersects(tempObject.getBounds())) {
          count++;
          // collision action:
//          handler.removeObject(tempObject); // remove agent
          if(count % 2 == 0) {
//            tempObject.setX(this.getX());
//            tempObject.setY(this.getY());
//            handler.addObject(new Player(this.getX(), this.getY(), ID.Player, handler));
            this.setX(r.nextInt(WIDTH/2) - 40);
            this.setY(r.nextInt((WIDTH / 12 * 9) - 64));
//            tempObject2.tick();
            tempObject.tick();
//            handler.addObject(new Trapdoor(r.nextInt((WIDTH/2) - 64), r.nextInt((WIDTH / 12 * 9) - 64), ID.Trapdoor, handler));
//            handler.removeObject(this);
//          handler.removeObject(handler.object.get(1)); // remove smartenemy
//            handler.addObject(new Player(r.nextInt((WIDTH/2) - 64) + (WIDTH/2), r.nextInt((WIDTH / 12 * 9) - 64), ID.Player, handler));
//          for (int j = 0; j < 2; j++)
//            handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
            System.out.println("right = true");
          } else {
//            tempObject.setX(this.getX());
//            tempObject.setY(this.getY());
//            handler.addObject(new Player(this.getX(), this.getY(), ID.Player, handler));
            this.setX(r.nextInt(WIDTH/2) - 40 + (WIDTH/2));
            this.setY(r.nextInt((WIDTH / 12 * 9) - 64));
//            tempObject2.tick();
            tempObject.tick();
//            handler.addObject(new Trapdoor(r.nextInt((WIDTH/2) - 64) + (WIDTH/2), r.nextInt((WIDTH / 12 * 9) - 64), ID.Trapdoor, handler));
//            handler.removeObject(this);
//            handler.addObject(new Player(r.nextInt((WIDTH/2) - 64), r.nextInt((WIDTH / 12 * 9) - 64), ID.Player, handler));
//          handler.removeObject(handler.object.get(1)); // remove smartenemy
//            handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
            System.out.println("right = false"); // <<<
          }
          System.out.println(count);
        }
      }
    }  
  }
  
  @Override
  public void tick() {
    collision();
  }

  @Override
  public void render(Graphics g) {
// show bounding box for collision detection:
//    Graphics2D g2d = (Graphics2D) g;
//    g.setColor(Color.white);
//    g2d.draw(getBounds());    
    
    g.setColor(color);
    g.fillOval((int)x, (int)y, 48, 48);
//    g.fillRect((int)x, (int)y, 48, 48);
  }
}
