package Command;

import Command.Commands.EchoCommand;

import static Util.Util.append;

public class CommandRegister {
    public Command[] commands = {};
    public void registerCommands(){
        register(new EchoCommand());
    }
    public void register(Command c){
        commands = (Command[])append(commands,c);
    }
}
