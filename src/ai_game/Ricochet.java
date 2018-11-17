package ai_game;

import java.awt.*;

public class Ricochet extends GameObject{
  
  private Handler handler;
  public int counter;
  
  public Ricochet(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    
    this.handler = handler;
    
    velX = 3f;
    velY = 3f;
  }
  
  @Override
  // larger bounds than appearance to insure agent won't touch it
  public Rectangle getBounds() {
    return new Rectangle((int)x-95, (int)y-100, 200, 200);
//    return new Rectangle((int)x-45, (int)y-45, 100, 100);
  } 

  @Override
  public void tick() {
    x += velX;
    y += velY;
    
    if (x <= 0 || x >= Game.WIDTH - 32)
      velX = -velX;
    if (y <= 0 || y >= Game.HEIGHT - 32)
      velY = -velY;
    
    handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.07f, handler));
  }

  @Override
  public void render(Graphics g) {
    // show bounding box for collision detection:
//    Graphics2D g2d = (Graphics2D) g;
//    g.setColor(Color.blue);
//    g2d.draw(getBounds());
    
    
    g.setColor(Color.RED);
    g.fillOval((int)x, (int)y, 16, 16);
//    g.fillRect((int)x, (int)y, 16, 16);
  }
}
