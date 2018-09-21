/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

import javax.swing.*;

/**
 *
 * @author davidortego
 */
public class Driver {
  
  JFrame frame = new JFrame();
  JPanel panel = new GamePanel();
  int x, y = 0;
  
  public Driver() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    
    frame.add(panel);
    
    frame.setLocationRelativeTo(null);  
//    frame.pack();
    frame.setVisible(true); 
  }
  
  
  public static void main(String[] args) {
    new Driver();
  }
}
