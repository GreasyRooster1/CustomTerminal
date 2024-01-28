package Command;

import Command.Commands.EchoCommand;

import java.util.Arrays;

import static Util.Util.append;

public class CommandRegister {
    public static Command[] commands = {};
    public static void registerCommands(){
        register(new EchoCommand());
    }
    public static void register(Command c){
        commands = (Command[])append(commands,c);
    }
    public static String executeCommand(String command){
        String[] blocks = command.split(" ");
        for (Command c:commands) {
            if(c.identifier.equals(blocks[0])){
                return c.task(Arrays.copyOfRange(blocks, 1, blocks.length));
            }
        }
        return "Invalid command";
    }
}
