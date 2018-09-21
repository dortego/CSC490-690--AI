/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author davidortego
 */
public class Trapdoor extends JLabel {
  
  ImageIcon trapdoor = new ImageIcon(getClass().getResource("Trap_Door_open.png"));  
  JLabel trapdoorLabel = new JLabel(trapdoor, JLabel.CENTER).setLocation(350, 350);
  
  public Trapdoor() {
    
  }
  
}
