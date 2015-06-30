/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakegame;

import java.io.IOException;
import java.util.Random;

public class Snake{
    Random random = new Random();
    static int scores, highscore;
    static int maxX, maxY, tailLong;
    static char[][] Field;
    static boolean live=true;
    static byte direction, olddirection;
    static int[][] tailLive;
    static boolean[][] solid;
    static boolean[][] apple;
    static int headX, headY;
    static int appleValue = 5;
    static byte direction2;
    public Snake(int x, int y){
        live=true;
        appleValue = 5;
        maxX = x;
        maxY = y;
        Field = new char[maxX+2][maxY+2];
        tailLive = new int[maxX+2][maxY+2];
        solid = new boolean[maxX+2][maxY+2];
        apple = new boolean[maxX+2][maxY+2];
        headX = 5;
        headY = y/2;
        tailLong = 4;
        initialize();
        for(int a = 1; a<=appleValue; a++){
            generateApple();
        }
    }
    
    public void restart() throws IOException{
        scores = 0;
        direction = 1;
        live=true;
        appleValue = 5;
        headX = 5;
        headY = maxY/2;
        tailLong = 4;
        refreshTail();
        refreshSolid();
        refreshApple();
        for(int a = 1; a<=appleValue; a++){
            generateApple();
        }
    }
    
    private void refreshSolid(){
        for(int x=0; x<maxX; x++){
            for(int y=0; y<maxY; y++){
                if (Field[x][y] != 'W'){
                    solid[x][y] = false;
                }
            }
        }
    }
    
    private void refreshApple(){
        for(int x=0; x<maxX; x++){
            for(int y=0; y<maxY; y++){
                apple[x][y] = false;
            }
        }
    }
    
    private void refreshScreen(){
        for(int x=0; x<maxX; x++){
            for(int y=0; y<maxY; y++){
                Field[x][y] = ' ';
            }
        }
    }
    
    private void refreshTail(){
        for(int x=0; x<maxX; x++){
            for(int y=0; y<maxY; y++){
                tailLive[x][y] = 0;
            }
        }
    }
    
    private void generateApple(){
        boolean notGenerated = true;
        int x = 1,y = 1;
        while(notGenerated){
            x = random.nextInt(maxX);
            y = random.nextInt(maxY);
            if (Field[x][y] == ' '){
                notGenerated = false;
            }
        }
        Field[x][y] = 'A';
    }
    
    private void moveSnakeRight(){
        solid[headX][headY] = true;
        drawPreviousTile();
        tailLive[headX][headY] = tailLong;
        if (headX == maxX-1){
            headX = 0;
        }
        else{
            headX++;
        }
        if (Field[headX][headY] == 'A'){
            scores++;
            tailLong++;
            generateApple();
            Field[headX][headY] = '>';
            apple[headX][headY] = true;
        }
        else if (solid[headX][headY]){
            live = false;
        }
        else{
            Field[headX][headY] = '>';
        }
    }
    
    private void moveSnakeUp(){
        solid[headX][headY] = true;
        drawPreviousTile();
        tailLive[headX][headY] = tailLong;
        if (headY == 0){
            headY = maxY-1;
        }
        else{
            headY--;
        }
        if (Field[headX][headY] == 'A'){
            scores++;
            tailLong++;
            generateApple();
            Field[headX][headY] = '^';
            apple[headX][headY] = true;
        }
        else if (solid[headX][headY]){
            live = false;
        }
        else{
            Field[headX][headY] = '^';
        }
    }
    
    private void moveSnakeLeft(){
        solid[headX][headY] = true;
        drawPreviousTile();
        tailLive[headX][headY] = tailLong;
        if (headX == 0){
            headX = maxX-1;
        }
        else{
            headX--;
        }
        if (Field[headX][headY] == 'A'){
            scores++;
            tailLong++;
            generateApple();
            Field[headX][headY] = '<';
            apple[headX][headY] = true;
        }
        else if (solid[headX][headY]){
            live = false;
        }
        else{
            Field[headX][headY] = '<';
        }
    }
    
    private void moveSnakeDown(){
        solid[headX][headY] = true;
        drawPreviousTile();
        tailLive[headX][headY] = tailLong;
        if (headY == maxY-1){
            headY = 0;
        }
        else{
            headY++;
        }
        if (Field[headX][headY] == 'A'){
            scores++;
            tailLong++;
            generateApple();
            Field[headX][headY] = 'V';
            apple[headX][headY] = true;
        }
        else if (solid[headX][headY]){
            live = false;
        }
        else{
            Field[headX][headY] = 'V';
        }
    }
    
    private void moveSnake(){
        switch(direction){
            case 1:{
                moveSnakeRight();
                break;
            }
            case 2:{
                moveSnakeUp();
                break;
            }
            case 3:{
                moveSnakeLeft();
                break;
            }
            case 4:{
                moveSnakeDown();
                break;
            }
        }
    }
    
    private void checkTail(){
        for(int x=0; x<maxX; x++){
            for(int y=0; y<maxY; y++){
                switch (tailLive[x][y]){
                    case 0:{
                        break;
                    }
                    case 1:{
                        Field[x][y] = ' ';
                        tailLive[x][y]--;
                        solid[x][y] = false;
                        break;
                    }
                    case 2:{
                        tailLive[x][y]--;
                        apple[x][y] = false;
                        break;
                    }
                    default:{
                        tailLive[x][y]--;
                        break;
                    }
                }
            }
        }
    }
    
    private void drawPreviousTile(){
        switch(direction){
            case 1:{
                switch(direction2){
                    case 1:{
                        Field[headX][headY] = '-';
                        break;
                    }
                    case 2:{
                        Field[headX][headY] = 'd';
                        break;
                    }
                    case 4:{
                        Field[headX][headY] = 'z';
                        break;
                    }
                }
                break;
            }
            case 2:{
                switch(direction2){
                    case 1:{
                        Field[headX][headY] = 'x';
                        break;
                    }
                    case 2:{
                        Field[headX][headY] = '|';
                        break;
                    }
                    case 3:{
                        Field[headX][headY] = 'z';
                        break;
                    }
                }
                break;
            }
            case 3:{
                switch(direction2){
                    case 2:{
                        Field[headX][headY] = 'c';
                        break;
                    }
                    case 3:{
                        Field[headX][headY] = '-';
                        break;
                    }
                    case 4:{
                        Field[headX][headY] = 'x';
                        break;
                    }
                }
                break;
            }
            case 4:{
                switch(direction2){
                    case 1:{
                        Field[headX][headY] = 'c';
                        break;
                    }
                    case 3:{
                        Field[headX][headY] = 'd';
                        break;
                    }
                    case 4:{
                        Field[headX][headY] = '|';
                        break;
                    }
                }
                break;
            }
        }
    }
    
    public void doTurn(byte dir){
        direction2 = direction;
        switch(dir){
            case 1:{
                if(direction!=3){
                    direction = 1;
                }
                break;
            }
            case 2:{
                if(direction!=4){
                    direction = 2;
                }
                break;
            }
            case 3:{
                if(direction!=1){
                    direction = 3;
                }
                break;
            }
            case 4:{
                if(direction!=2){
                    direction = 4;
                }
                break;
            }
        }
        checkTail();
        moveSnake();
    }
    
    private void initialize(){
        refreshSolid();
        refreshApple();
        refreshScreen();
        refreshTail();
    }
    
    public void loadLevel(int xM, int yM, boolean[][] level){
        refreshScreen();
        maxY = yM;
        maxX = xM;
        for(int x = 0; x<maxX; x++){
            for(int y = 0; y<maxY; y++){
                if(level[x][y]){
                    Field[x][y] = 'W';
                    solid[x][y] = true;
                }
            }
        }
    }
}