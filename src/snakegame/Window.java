/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakegame;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Window extends JFrame{
    FlowLayout layout = new FlowLayout();
    JLabel l1, l2;
    byte direction = 1;
    Panel panel;
    int tileSize;
    @SuppressWarnings("empty-statement")
    public Window(int s, String path) throws IOException{
        super("Snake");
        layout.setAlignment(FlowLayout.LEADING);
        final LevelLoader loader = new LevelLoader(path);
        final int y = loader.sizeY;
        final int x = loader.sizeX;
        tileSize = s;
        panel = new Panel(x,y,tileSize);
        panel.snake.loadLevel(x, y, loader.levelField);
        panel.snake.restart();
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_D:{
                        direction = 1;
                        break;
                    }
                    case KeyEvent.VK_W:{
                        direction = 2;
                        break;
                    }
                    case KeyEvent.VK_A:{
                        direction = 3;
                        break;
                    }
                    case KeyEvent.VK_S:{
                        direction = 4;
                        break;
                    }
                    case KeyEvent.VK_T:{
                        try {
                            direction = 1;
                            panel.restart(x, y, loader.levelField);
                        } catch (IOException ex) {
                            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20, 20, x*s+9, (y+2)*s+100);
        this.add(panel);
        String s1, s2;
        while(true){
            try{
                if(panel.snakeLive){
                    panel.draw(direction);
                }
                Thread.sleep(250);
            }
            catch(InterruptedException e){};
        }
    }
}
