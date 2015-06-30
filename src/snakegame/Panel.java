
package snakegame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Panel extends JPanel{
    HighscoreManager hm = new HighscoreManager();
    byte direction;
    boolean snakeLive=true;
    Snake snake;
    static int size;
    static int sizeX, sizeY;
    public Panel(int x, int y, int s) throws IOException{
        hm.loadHighscore();
        snake = new Snake(x-1,y-1);
        sizeX = x;
        sizeY = y;
        size = s;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        int x1 = 0, x2 = size*sizeX, y1 = 0, y2 = size*sizeY;
        g.setColor(Color.white);
        g.fillRect(x1,y1,x2,y2);
        g.setColor(Color.darkGray);
        y1 = size*sizeY;
        y2 = size*sizeY+100;
        g.fillRect(x1,y1,x2,y2);
        for(int x = 0; x<sizeX; x++){
            for(int y = 0; y<sizeY; y++){
                switch(Snake.Field[x][y]){
                    case ' ':{
                        g.setColor(Color.white);
                        g.fillRect(x*size, y*size,size, size);
                        break;
                    }
                    case 'S':{
                        g.setColor(Color.green);
                        g.fillRect(x*size, y*size,size, size);
                        break;
                    }
                    case 'W':{
                        g.setColor(Color.black);
                        g.fillRect(x*size, y*size,size, size);
                        break;
                    }
                    case 'A':{
                        g.setColor(Color.red);
                        g.fillRect(x*size+3, y*size+3, 14, 14);
                        break;
                    }
                    case 'G':{
                        g.setColor(Color.blue);
                        g.fillRect(x*size, y*size, size, size);
                        break;
                    }
                    case '>':{
                        g.setColor(Color.green);
                        x1 = x*size;
                        y1 = y*size+5;
                        x2 = 20;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+6;
                        y1 = y*size+3;
                        x2 = 14;
                        y2 = 14;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case '<':{
                        g.setColor(Color.green);
                        x1 = x*size;
                        y1 = y*size+5;
                        x2 = 20;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size;
                        y1 = y*size+3;
                        x2 = 14;
                        y2 = 14;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case '^':{
                        g.setColor(Color.green);
                        x1 = x*size+5;
                        y1 = y*size;
                        x2 = 10;
                        y2 = 20;
                        g.fillRect(x1,y1,x2,y2);
                        
                        x1 = x*size+3;
                        y1 = y*size;
                        x2 = 14;
                        y2 = 14;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case 'V':{
                        g.setColor(Color.green);
                        x1 = x*size+5;
                        y1 = y*size;
                        x2 = 10;
                        y2 = 20;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+3;
                        y1 = y*size+6;
                        x2 = 14;
                        y2 = 14;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case '|':{
                        g.setColor(Color.green);
                        x1 = x*size+5;
                        y1 = y*size;
                        x2 = 10;
                        y2 = 20;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case '-':{
                        g.setColor(Color.green);
                        x1 = x*size;
                        y1 = y*size+5;
                        x2 = 20;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case 'z':{
                        g.setColor(Color.green);
                        x1 = x*size+5;
                        y1 = y*size+5;
                        x2 = 15;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+5;
                        y1 = y*size;
                        x2 = 10;
                        y2 = 15;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case 'x':{
                        g.setColor(Color.green);
                        x1 = x*size;
                        y1 = y*size+5;
                        x2 = 15;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+5;
                        y1 = y*size;
                        x2 = 10;
                        y2 = 15;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case 'c':{
                        g.setColor(Color.green);
                        x1 = x*size;
                        y1 = y*size+5;
                        x2 = 15;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+5;
                        y1 = y*size+5;
                        x2 = 10;
                        y2 = 15;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                    case 'd':{
                        g.setColor(Color.green);
                        x1 = x*size+5;
                        y1 = y*size+5;
                        x2 = 15;
                        y2 = 10;
                        g.fillRect(x1,y1,x2,y2);
                        x1 = x*size+5;
                        y1 = y*size+5;
                        x2 = 10;
                        y2 = 15;
                        g.fillRect(x1,y1,x2,y2);
                        break;
                    }
                }
            }
            String s;
            if (Snake.scores>hm.highscore){
                hm.highscore = Snake.scores;
                hm.changed = true;
            }
            g.setColor(Color.white);
            s = "Highscore: " + Integer.toString(hm.highscore);
            g.drawString(s, 50, size*sizeY+66);
            s = "Scores: " + Integer.toString(Snake.scores);
            g.drawString(s, 50, size*sizeY+46);
            s = "WASD to control your snake";
            g.drawString(s, size*sizeX-280, size*sizeY+46);
            s = "T to restart your game";
            g.drawString(s, size*sizeX-280, size*sizeY+66);
        }
        for(int x = 0; x<sizeX; x++){
            for(int y =0; y<sizeY; y++){
                if (Snake.apple[x][y] == true){
                    g.setColor(Color.green);
                    x1 = x*size+4;
                    y1 = y*size+4;
                    x2 = 12;
                    y2 = 12;
                    g.fillRect(x1,y1,x2,y2);
                }
            }
        }
        g.setColor(Color.black);
        if (!Snake.live){
            int x, y;
            x = Snake.headX;
            y = Snake.headY;
            switch(Snake.direction){
                case 1:{
                    g.setColor(Color.green);
                    x1 = x*size;
                    y1 = y*size+5;
                    x2 = 20;
                    y2 = 10;
                    g.fillRect(x1,y1,x2,y2);
                    x1 = x*size+6;
                    y1 = y*size+3;
                    x2 = 14;
                    y2 = 14;
                    g.fillRect(x1,y1,x2,y2);
                    break;
                }
                case 2:{
                    g.setColor(Color.green);
                    x1 = x*size+5;
                    y1 = y*size;
                    x2 = 10;
                    y2 = 20;
                    g.fillRect(x1,y1,x2,y2);
                    x1 = x*size+3;
                    y1 = y*size;
                    x2 = 14;
                    y2 = 14;
                    g.fillRect(x1,y1,x2,y2);
                    break;
                }
                case 3:{
                    g.setColor(Color.green);
                    x1 = x*size;
                    y1 = y*size+5;
                    x2 = 20;
                    y2 = 10;
                    g.fillRect(x1,y1,x2,y2);
                    x1 = x*size;
                    y1 = y*size+3;
                    x2 = 14;
                    y2 = 14;
                    g.fillRect(x1,y1,x2,y2);
                    break;
                }
                case 4:{
                    g.setColor(Color.green);
                    x1 = x*size+5;
                    y1 = y*size;
                    x2 = 10;
                    y2 = 20;
                    g.fillRect(x1,y1,x2,y2);
                    x1 = x*size+3;
                    y1 = y*size+6;
                    x2 = 14;
                    y2 = 14;
                    g.fillRect(x1,y1,x2,y2);
                    break;
                }
            }
        }
    }
    
    public void restart(int x, int y, boolean[][] level) throws IOException{
        hm.loadHighscore();
        snake.highscore = hm.highscore;
        snake.loadLevel(x, y, level);
        snake.restart();
        snakeLive = true;
    }
    

    public void draw(byte dir) throws IOException{
        if (Snake.live){
            snake.doTurn(dir);
            repaint();
        }
        else{
            snakeLive = false;
            if (Snake.scores>hm.highscore){
                hm.highscore = Snake.scores;
            }
            hm.writeHighscore();
        }
    }
}
