package snakegame;


import java.io.*;
/**
 *
 * @author Паша
 */
public class HighscoreManager {
    boolean changed = false;
    int highscore;
    public void writeHighscore() throws IOException{
        File file = new File("highscores.snh");
        try (FileWriter fw = new FileWriter(file)) {
            fw.flush();
            String s;
            s = Integer.toString(highscore);
            fw.write(s);
            fw.close();
        }
    }
    
    public void loadHighscore() throws FileNotFoundException, IOException{
        String s;
        File file = new File("highscores.snh");
        
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            s = br.readLine();
            highscore = Integer.parseInt(s);
        }
    }
}