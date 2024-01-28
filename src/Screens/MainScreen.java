package Screens;

import Command.CommandRegister;
import Console.Console;
import Input.ReadKeyboard;
import Util.Util;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import static Console.ConsoleData.logo;

public class MainScreen extends Screen{
    public String[] commandHistory = {};
    @Override
    public void update(){
        Console.background(' ');
        Console.scaledLine(0,0.2f,1,0.2f,'#');
        Console.image(logo, (Console.heightChars/10)-5, (Console.heightChars/10)-5);
        Console.text(Console.user+"> "+ ReadKeyboard.textBuffer,0,Console.heightChars-1);
        renderCommandHistory();
    }

    void renderCommandHistory(){
        for (int i = 0; i < commandHistory.length; i++) {
            Console.text(commandHistory[i],0,Console.heightChars-1-i);
        }
    }

    @Override
    public void onCommand(String cmd){
        commandHistory = (String[]) Util.append(commandHistory, CommandRegister.executeCommand(cmd));
        commandHistory = (String[]) Util.append(commandHistory,Console.user+"> "+cmd);
        commandHistory = (String[]) Util.append(commandHistory,"");                               //just a newline
    }
}
