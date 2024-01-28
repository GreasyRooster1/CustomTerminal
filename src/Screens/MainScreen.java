package Screens;

import Console.Console;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import static Console.ConsoleData.logo;

public class MainScreen {
    public static void update(){
        Console.background(' ');
        Console.scaledLine(0,0.2f,1,0.2f,'#');
        Console.image(logo, (Console.heightChars/10)-5, (Console.heightChars/10)-5);
    }
}
