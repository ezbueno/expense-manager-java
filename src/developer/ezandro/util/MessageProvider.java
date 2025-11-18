package developer.ezandro.util;

public class MessageProvider {
    private MessageProvider() {
    }

    // Mensagens gerais do sistema
    public static final String INVALID_OPTION_MESSAGE = "ERROR: Invalid option. Please enter a number from the list.";
    public static final String CHOOSE_OPTION_MESSAGE = "Choose an option: ";

    // Mensagens de ExpenseInput
    public static final String ENTER_DESCRIPTION_MESSAGE = "Enter description: ";
    public static final String DESCRIPTION_EMPTY_MESSAGE = "ERROR: Description cannot be empty.";
    public static final String DESCRIPTION_INVALID_MESSAGE = "ERROR: Invalid description. Use only letters, numbers, spaces, hyphens and basic punctuation.";
    public static final String CHOOSE_CATEGORY_MESSAGE = "Choose a category: ";
    public static final String CATEGORY_EMPTY_MESSAGE = "ERROR: Category cannot be empty.";
    public static final String ENTER_AMOUNT_MESSAGE = "Enter amount: ";
    public static final String AMOUNT_EMPTY_MESSAGE = "ERROR: Amount cannot be empty.";
    public static final String AMOUNT_INVALID_FORMAT_MESSAGE = "ERROR: Invalid amount format. Use positive numbers only (e.g., 150.50).";
    public static final String AMOUNT_MINIMUM_MESSAGE = "ERROR: Minimum amount is 0.01";
    public static final String AMOUNT_INVALID_NUMBER_MESSAGE = "ERROR: Invalid amount. Please enter a valid number (e.g., 150.50).";
    public static final String ENTER_DATE_MESSAGE = "Enter date (YYYY-MM-DD): ";
    public static final String DATE_EMPTY_MESSAGE = "ERROR: Date cannot be empty.";
    public static final String DATE_INVALID_FORMAT_MESSAGE = "ERROR: Invalid date format. Please use YYYY-MM-DD (e.g., 2024-12-25)";
    public static final String DATE_PAST_MESSAGE = "ERROR: Date cannot be in the past. Please enter a future date.";
    public static final String DATE_INVALID_MESSAGE = "ERROR: Invalid date. Please check if the date exists (e.g., 2024-02-30 is invalid).";
    public static final String CATEGORIES_HEADER_MESSAGE = "\nPlease choose one of the categories below:";

    // Mensagens de MenuHandler
    public static final String EXPENSE_ADDED_SUCCESS_MESSAGE = "Expense added successfully!";
    public static final String NO_EXPENSES_MESSAGE = "\nNo expenses registered yet. Please register an expense first (option [1]).";
    public static final String EXPENSES_BY_ID_HEADER = "\n=== List of Expenses sorted by ID ===";
    public static final String EXPENSES_BY_DATE_HEADER = "\n=== List of Expenses sorted by Date ===";
    public static final String EXPENSES_BY_AMOUNT_HEADER = "\n=== List of Expenses sorted by Amount ===";

    // Mensagens de MenuDisplay
    public static final String WELCOME_MESSAGE = """
            
            === Welcome to Expense Manager ===
            
            1. Add expense
            2. List all expenses
            3. Show total amount
            4. Exit
            
            Choose an option:\s""";

    public static final String EXIT_PROGRAM_MESSAGE = """
            
            === Program terminated ===
            Thank you for using Expense Manager.
            """;

    // Mensagens de SubMenuDisplay
    public static final String SUB_MENU_MESSAGE = """
            
            How would you like to sort the expenses?
            
            1. By ID (default)
            2. By Date
            3. By Amount
            4. Return to Main Menu
            
            Choose an option:\s""";

    // Mensagens para ExpenseFormatter
    public static final String EXPENSE_DETAILS_HEADER = """
            
            ----------------------------------------
            💰 Expense Details:
            ----------------------------------------""";

    public static final String EXPENSE_DETAILS_FOOTER = "----------------------------------------";
    public static final String ID_LABEL = "ID";
    public static final String DESCRIPTION_LABEL = "Description";
    public static final String CATEGORY_LABEL = "Category";
    public static final String AMOUNT_LABEL = "Amount";
    public static final String DATE_LABEL = "Date";
    public static final String AMOUNT_FORMAT = "$%.2f";
    public static final String DATE_FORMAT = "MMMM dd, yyyy";

    // Mensagens para ExpensePrinter
    public static final String TOTAL_SPENT_HEADER = """
            
            ----------------------------------------
            Total spent:""";

    public static final String TOTAL_SPENT_FOOTER = "----------------------------------------";
    public static final String TOTAL_AMOUNT_FORMAT = "$%.2f";
}