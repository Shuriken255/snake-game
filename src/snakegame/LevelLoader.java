/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakegame;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Паша
 */
public class LevelLoader {
    int sizeX,sizeY;
    boolean levelField[][];
    public LevelLoader(String fileName) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("level.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> charList = new ArrayList();
        String string;
        while((string = br.readLine()) != null){
            charList.add(string);
            sizeX = string.length();
        }
        sizeY = charList.size();
        string = charList.get(0);
        levelField = new boolean[string.length()][charList.size()];
        for(int j = 0; j<charList.size(); j++){
            string = charList.get(j);
            for(int i = 0; i<string.length(); i++){
                if(string.charAt(i) == '1'){
                    levelField[i][j] = true;
                }
            }
        }
    }
}
