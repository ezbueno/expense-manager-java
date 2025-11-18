package developer.ezandro.ui;

import module java.base;
import developer.ezandro.util.MessageProvider;

public class SubMenuHandler {
    public int validateSubMenuOption(Scanner scanner) {
        while (true) {
            try {
                String inputOption = scanner.nextLine().trim();
                int choice = Integer.parseInt(inputOption);

                if (choice >= 1 && choice <= 4) {
                    return choice;
                }

                IO.println(MessageProvider.INVALID_OPTION_MESSAGE);
                IO.print(MessageProvider.CHOOSE_OPTION_MESSAGE);

            } catch (NumberFormatException _) {
                IO.println(MessageProvider.INVALID_OPTION_MESSAGE);
                IO.print(MessageProvider.CHOOSE_OPTION_MESSAGE);
            }
        }
    }
}