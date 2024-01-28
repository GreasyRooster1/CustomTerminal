package Console;

import Screens.MainScreen;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static java.lang.Math.abs;


public class Console {
    public static double widthScreen,heightScreen;
    public static int heightChars, widthChars;
    public static char[][] display = {};
    public static String user = "ADMIN";
    public static void startup(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        widthScreen = screenSize.getWidth();
        heightScreen = screenSize.getHeight();
        heightChars = (int) (heightScreen/16);
        widthChars = (int) (widthScreen/8);
        display = new char[heightChars][widthChars];
        for(int i=0;i<heightChars;i++){
            for(int j=0;j<widthChars;j++){
                display[i][j] = ' ';
            }
        }
    }
    public static void update(){
        updateDisplay();
        refreshScreen();
    }
    public static void run(String cmd){
        if(cmd.equals("quit")){
            clearConsole();
            System.out.print("Thank you for choosing to use Magma Console V1");
            System.exit(0);
        }
    }
    public static void updateDisplay(){
        MainScreen.update();
    }
    public static void refreshScreen(){
        clearConsole();
        for (char[] line:display) {
            System.out.print(line);
        }
    }

    public static void scaledLine(float x0,float y0,float x1,float y1,char col){
        line((int) (x0*widthChars), (int) (y0*heightChars), (int) (x1*widthChars), (int) (y1*heightChars),col);
    }
    public static void line(int x0,int y0,int x1,int y1,char col){
        //Bresenham's line algorithm
        int dx = abs(x1 - x0);
        int sx = x0 < x1 ? 1 : -1;
        int dy = -abs(y1 - y0);
        int sy = y0 < y1 ? 1 : -1;
        float error = dx + dy;

        while(true) {
            pset(x0, y0,col);
            if(x0 == x1 && y0 == y1){
                break;
            }
            float e2 =2 * error;
            if(e2 >= dy) {
                if (x0 == x1) {
                    break;
                }
                error = error + dy;
                x0 = x0 + sx;
            }
            if(e2 <= dx){
                if(y0 == y1) {
                    break;
                }
                error =error + dx;
                y0 = y0 + sy;
            }
        }
    }
    public static void pset(int x,int y,char col){
        if(x<0||x>=widthChars||y<0||y>=heightChars){
            return;
        }
        display[y][x]=col;
    }
    public static void background(char bg){
        for(int i=0;i<heightChars;i++){
            for(int j=0;j<widthChars;j++){
                display[i][j] = bg;
            }
        }
    }
    public static void image(String img,int x,int y){
        String[] lines = img.split("\n");
        int lineCount = 0;
        for(String line :lines){
            int count = 0;
            for (char c: line.toCharArray()) {
                pset(x+count,y+lineCount,c);
                count++;
            }
            lineCount++;
        }
    }
    public static void text(String text,int x,int y){
        int count = 0;
        for (char c: text.toCharArray()) {
            pset(x+count,y,c);
            count++;
        }
    }
    public static void clearConsole(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (final Exception e){
            e.printStackTrace();
        }
    }
}
