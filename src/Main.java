import Command.CommandRegister;
import Console.Console;
import Input.ReadKeyboard;

public class Main {
    public static void main(String[] args) {
        CommandRegister.registerCommands();
        Console.startup();
        ReadKeyboard.setup();
    }
}