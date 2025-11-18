package developer.ezandro.app;

import developer.ezandro.ui.MenuHandler;

public class ExpenseManagerApp {
    private ExpenseManagerApp() {
    }

    static void main() {
        new MenuHandler().displayMenu();
    }
}