package ai_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Trapdoor extends GameObject {
  
  private Handler handler;
  
  public Trapdoor(float x, float y, ID id, Handler handler) {
    super(x, y, id);
    this.handler = handler;
  }

  @Override
  public void tick() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.gray);
    g.fillRect((int)x, (int)y, 16, 16);
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle((int)x, (int)y, 16, 16);
  }
  
  
}
