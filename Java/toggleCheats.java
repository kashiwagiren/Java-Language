import jline.ConsoleReader;
import jline.TerminalFactory;

public class toggleCheats {
    public static void toggleCheats() {
        if (!cheatsEnabled) {
            try {
                ConsoleReader reader = new ConsoleReader();
                reader.setExpandEvents(false);
                String correctPassword = "JavaQuizGame";
                System.out.print("\n          Enter the password to enable cheats: ");
                char[] passwordArray = reader.readLine('*', new Character('*')).toCharArray();
                String password = new String(passwordArray);
    
                if (password.equals(correctPassword)) {
                    cheatsEnabled = !cheatsEnabled;
                    System.out.println("\n          Cheats have been enabled!");
                } else {
                    System.out.println("\n          \u001B[91mIncorrect password.\u001B[0m");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            cheatsEnabled = !cheatsEnabled;
            System.out.println("\n          Cheats have been disabled!");
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
