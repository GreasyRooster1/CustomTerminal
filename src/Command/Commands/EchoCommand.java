package Command.Commands;

import Command.Command;

import java.lang.reflect.Array;

public class EchoCommand extends Command {
    @Override
    public String task(String[] args) {
        return String.join(" ",args);
    }
}
