# 💰 Expense Manager

A robust command-line expense management application built with Java 25 LTS, featuring comprehensive input validation, multiple sorting options, and an intuitive menu-driven interface.

## 📋 Features

- **Add Expenses**: Register expenses with description, category, amount, and date
- **List Expenses**: View all expenses sorted by ID, date, or amount
- **Calculate Total**: Display the total amount of all registered expenses
- **Input Validation**: Comprehensive regex-based validation for all inputs
- **Category Management**: Six predefined expense categories
- **Data Persistence**: In-memory storage with unique ID generation

## 🏗️ Project Structure

```
developer.ezandro
├── app
│   └── ExpenseManagerApp.java          # Application entry point
├── domain
│   ├── Category.java                   # Expense categories enum
│   └── Expense.java                    # Expense record
├── exception
│   └── CategoryNotFoundException.java  # Custom exception
├── service
│   └── ExpenseManager.java             # Business logic
├── ui
│   ├── ExpenseInput.java               # Input handling with validation
│   ├── MenuDisplay.java                # Main menu display
│   ├── MenuHandler.java                # Main menu logic
│   ├── SubMenuDisplay.java             # Sorting submenu display
│   └── SubMenuHandler.java             # Sorting submenu logic
└── util
    ├── ExpenseFormatter.java           # Expense output formatting
    ├── ExpensePrinter.java             # Currency formatting
    └── MessageProvider.java            # Centralized messages
```

## 🚀 Getting Started

### Prerequisites

- **Java 25 LTS**
- Git (for cloning the repository)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/ezbueno/expense-manager-java.git
cd expense-manager-java
```

2. Compile the project:
```bash
javac -d out src/developer/ezandro/**/*.java
```

3. Run the application:
```bash
java -cp out developer.ezandro.app.ExpenseManagerApp
```

## 📖 Usage

### Main Menu

```
=== Welcome to Expense Manager ===

1. Add expense
2. List all expenses
3. Show total amount
4. Exit
```

### Adding an Expense

The application will prompt you for:

1. **Description**: Alphanumeric with basic punctuation (letters, numbers, spaces, hyphens, commas, periods)
   - Valid: `Coffee`, `Vitamin-C`, `Pizza 4 cheeses`
   - Invalid: `Expense@`, `#tag`, `$100`

2. **Category**: Choose from six options:
   - 1. FOOD
   - 2. TRANSPORT
   - 3. ENTERTAINMENT
   - 4. HEALTH
   - 5. EDUCATION
   - 6. OTHER

3. **Amount**: Positive decimal number (minimum 0.01)
   - Valid: `0.50`, `10.5`, `150.00`
   - Invalid: `0`, `-5`, `10.123`

4. **Date**: Future date in YYYY-MM-DD format
   - Valid: `2024-12-25`, `2025-01-01`
   - Invalid: `2024-13-01`, `2023-12-25` (past date)

### Sorting Options

When listing expenses, choose how to sort:
1. By ID (default registration order)
2. By Date (newest first, then by amount)
3. By Amount (highest first, then by date)

## 🔍 Key Features Explained

### Input Validation

The application uses regex patterns to validate all user inputs:

- **Description Pattern**: `^[a-zA-ZÀ-ÿ\\d\\s\\-.,!?()]+$`
- **Amount Pattern**: `^\\d+(\\.\\d{1,2})?$`
- **Date Pattern**: `^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$`

### ID Generation

Expenses are automatically assigned unique, sequential IDs using `AtomicInteger` for thread-safe generation.

### Sorting Logic

- **By Date**: Descending order (newest first), with amount as secondary criterion
- **By Amount**: Descending order (highest first), with date as secondary criterion

## 🛠️ Technologies Used

- **Java 25 LTS**: Latest long-term support version
- **Java Records**: For immutable expense data
- **Java Streams**: For efficient data processing
- **Regex**: For comprehensive input validation
- **AtomicInteger**: For thread-safe ID generation

## 📝 Code Highlights

### Immutable Expense Record
```java
public record Expense(Integer id, String description, 
                     Category category, double amount, LocalDate date)
```

### Stream-based Sorting
```java
public List<Expense> sortByDate() {
    return expenses.stream()
        .sorted(Comparator.comparing(Expense::date).reversed()
                .thenComparing(Comparator.comparing(Expense::amount).reversed()))
        .toList();
}
```

### Regex Validation
```java
private static final Pattern AMOUNT_PATTERN = 
    Pattern.compile("^\\d+(\\.\\d{1,2})?$");
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👤 Author

**Ezandro Bueno**

- GitHub: [@ezbueno](https://github.com/ezbueno)
- Repository: [expense-manager-java](https://github.com/ezbueno/expense-manager-java.git)

## 🙏 Acknowledgments

- Built with Java 25 LTS
- Focused on clean code principles
- Comprehensive input validation
- User-friendly interface
