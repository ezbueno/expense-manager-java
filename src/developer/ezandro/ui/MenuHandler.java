package developer.ezandro.ui;

import module java.base;
import developer.ezandro.domain.Expense;
import developer.ezandro.service.ExpenseManager;
import developer.ezandro.util.ExpensePrinter;
import developer.ezandro.util.ExpenseFormatter;
import developer.ezandro.util.MessageProvider;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuDisplay menuDisplay = new MenuDisplay();
    private final SubMenuDisplay SubMenuDisplay = new SubMenuDisplay();
    private final ExpenseInput expenseInput = new ExpenseInput();
    private final ExpenseManager expenseManager = new ExpenseManager();
    private final SubMenuHandler subMenuHandler = new SubMenuHandler();

    public void displayMenu() {
        this.execute();
    }

    private void execute() {
        while (true) {
            try {
                this.menuDisplay.printMenuOptions();
                String inputOption = this.scanner.nextLine().trim();

                int choice = Integer.parseInt(inputOption);

                if (choice == 4) {
                    this.menuDisplay.exitProgram();
                    break;
                } else {
                    this.chosenMenuOption(choice);
                }

            } catch (NumberFormatException _) {
                IO.println(MessageProvider.INVALID_OPTION_MESSAGE);
            }
        }
    }

    private void chosenMenuOption(int choice) {
        switch (choice) {
            case 1 -> this.addExpense();
            case 2 -> this.listAllExpenses();
            case 3 -> this.getTotalAmount();
            default -> IO.println(MessageProvider.INVALID_OPTION_MESSAGE);
        }
    }

    private void addExpense() {
        Expense expense = this.expenseInput.readExpense(this.scanner);
        this.expenseManager.addExpense(expense);

        IO.println(ExpenseFormatter.format(expense));
        IO.println(MessageProvider.EXPENSE_ADDED_SUCCESS_MESSAGE);
    }

    private void listAllExpenses() {
        if (this.checkAndWarnIfNoExpenses()) {
            return;
        }

        this.SubMenuDisplay.printSubMenuOptions();
        int choice = this.subMenuHandler.validateSubMenuOption(this.scanner);

        switch (choice) {
            case 1 -> {
                IO.println(MessageProvider.EXPENSES_BY_ID_HEADER);
                for (Expense expense : this.expenseManager.listAllExpenses()) {
                    IO.println(ExpenseFormatter.format(expense));
                }
            }
            case 2 -> {
                IO.println(MessageProvider.EXPENSES_BY_DATE_HEADER);
                for (Expense expense : this.expenseManager.sortByDate()) {
                    IO.println(ExpenseFormatter.format(expense));
                }
            }
            case 3 -> {
                IO.println(MessageProvider.EXPENSES_BY_AMOUNT_HEADER);
                for (Expense expense : this.expenseManager.sortByAmount()) {
                    IO.println(ExpenseFormatter.format(expense));
                }
            }
        }
    }

    private void getTotalAmount() {
        if (this.checkAndWarnIfNoExpenses()) {
            return;
        }

        double value = this.expenseManager.getTotalAmount();
        IO.println(ExpensePrinter.formatCurrency(value));
    }

    private boolean checkAndWarnIfNoExpenses() {
        boolean hasExpenses = this.expenseManager.hasExpenses();
        if (!hasExpenses) {
            IO.println(MessageProvider.NO_EXPENSES_MESSAGE);
        }
        return !hasExpenses;
    }
}