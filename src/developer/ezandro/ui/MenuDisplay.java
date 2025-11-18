package developer.ezandro.ui;

import developer.ezandro.util.MessageProvider;

public class MenuDisplay {
    public void printMenuOptions() {
        IO.print(MessageProvider.WELCOME_MESSAGE);
    }

    public void exitProgram() {
        IO.println(MessageProvider.EXIT_PROGRAM_MESSAGE);
    }
}