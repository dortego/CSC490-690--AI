/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author davidortego
 */
public class GamePanel extends JPanel {
  
  ImageIcon bg = new ImageIcon(getClass().getResource("80sBGcropped.png"));  
  JLabel bgLabel = new JLabel(bg, JLabel.CENTER);  
  Trapdoor trapdoorLabel = new Trapdoor();
//  ImageIcon trapdoor = new ImageIcon(getClass().getResource("Trap_Door_open.png"));  
//  JLabel trapdoorLabel = new JLabel(trapdoor, JLabel.CENTER).setLocation(350, 350);
//  trapdoorLabel.setBounds(350, 350, 50, 50);

  
  public GamePanel() {
//    this.setLayout(new GridLayout(10, 10));
    this.add(bgLabel);
  }
}
