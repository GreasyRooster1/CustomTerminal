import Console.Console;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.Map;

public class ReadKeyboard {
    static boolean run = true;
    static String textBuffer = "";
    public static void setup(){
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");

        for (Map.Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
        }

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {

            @Override
            public void keyPressed(GlobalKeyEvent event) {
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                    run = false;
                    return;
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_RETURN) {
                    Console.run(textBuffer);
                    textBuffer = "";
                    return;
                }
                textBuffer+=event.getKeyChar();

            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                return;
            }
        });

        try {
            while(run) {
                Console.update();
                Thread.sleep(100);
            }
        } catch(InterruptedException e) {
            //Do nothing
        } finally {
            keyboardHook.shutdownHook();
        }
    }
}
