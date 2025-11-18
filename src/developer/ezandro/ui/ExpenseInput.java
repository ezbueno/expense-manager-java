package developer.ezandro.ui;

import module java.base;
import developer.ezandro.domain.Category;
import developer.ezandro.domain.Expense;
import developer.ezandro.exception.CategoryNotFoundException;
import developer.ezandro.util.MessageProvider;

public class ExpenseInput {
    /**
     * Regex pattern para validar descrições de despesas.
     * Aceita:
     * - Letras (maiúsculas/minúsculas, incluindo acentuadas: A-Z, a-z, À-ÿ)
     * - Números (0-9)
     * - Espaços (\\s)
     * - Hífens (\\-), vírgulas, pontos, exclamações, interrogações e parênteses
     * Exemplos válidos: "Café", "Vitamina-C", "Açúcar mascavo", "Pizza 4 queijos", "Material escolar (caderno)"
     * Exemplos inválidos: "Descrição@", "#tag", "$100"
     */
    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("^[a-zA-ZÀ-ÿ\\d\\s\\-.,!?()]+$");

    /**
     * Regex para validar quantias monetárias (valores positivos).
     * - Parte inteira: 1+ dígitos (ex: "5", "10", "150")
     * - Parte decimal (opcional): ponto seguido de 1 ou 2 dígitos (ex: ".5", ".50", ".99")
     * - Valor mínimo: 0.01 (validado após conversão)
     * <p>
     * Exemplos válidos: "0.50", "5", "10.5", "10.99", "150.00"
     * Exemplos inválidos: "0", "0.0", "0.00", "-5", "10.123", ".5"
     */
    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");

    /**
     * Regex para validar datas no formato YYYY-MM-DD.
     * - Ano: 4 dígitos (1900-2099)
     * - Mês: 01-12
     * - Dia: 01-31 (validação básica, a validação real é feita pelo LocalDate.parse)
     * <p>
     * Exemplos válidos: "2024-12-25", "2024-01-01"
     * Exemplos inválidos: "2024-13-01", "2024-02-30", "24-12-25"
     */
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");

    public Expense readExpense(Scanner scanner) {
        String description = this.readDescription(scanner);
        Category category = this.readCategory(scanner);
        double amount = this.readAmount(scanner);
        LocalDate date = this.readDate(scanner);
        return new Expense(description, category, amount, date);
    }

    private String readDescription(Scanner scanner) {
        while (true) {
            IO.print(MessageProvider.ENTER_DESCRIPTION_MESSAGE);
            String description = scanner.nextLine().trim();

            if (description.isEmpty()) {
                IO.println(MessageProvider.DESCRIPTION_EMPTY_MESSAGE);
            } else if (!DESCRIPTION_PATTERN.matcher(description).matches()) {
                IO.println(MessageProvider.DESCRIPTION_INVALID_MESSAGE);
            } else {
                return description;
            }
        }
    }

    private Category readCategory(Scanner scanner) {
        this.displayCategories();

        while (true) {
            try {
                IO.print(MessageProvider.CHOOSE_CATEGORY_MESSAGE);
                String category = scanner.nextLine().trim();

                if (category.isEmpty()) {
                    IO.println(MessageProvider.CATEGORY_EMPTY_MESSAGE);
                } else {
                    int option = Integer.parseInt(category);
                    return Category.fromOption(option);
                }

            } catch (CategoryNotFoundException e) {
                IO.println(e.getMessage());
            } catch (NumberFormatException _) {
                IO.println(MessageProvider.INVALID_OPTION_MESSAGE);
            }
        }
    }

    private double readAmount(Scanner scanner) {
        while (true) {
            try {
                IO.print(MessageProvider.ENTER_AMOUNT_MESSAGE);
                String amount = scanner.nextLine().trim();

                if (amount.isEmpty()) {
                    IO.println(MessageProvider.AMOUNT_EMPTY_MESSAGE);
                } else if (!AMOUNT_PATTERN.matcher(amount).matches()) {
                    IO.println(MessageProvider.AMOUNT_INVALID_FORMAT_MESSAGE);
                } else {
                    double value = Double.parseDouble(amount);
                    if (value < 0.01) {
                        IO.println(MessageProvider.AMOUNT_MINIMUM_MESSAGE);
                    } else {
                        return value;
                    }
                }

            } catch (NumberFormatException _) {
                IO.println(MessageProvider.AMOUNT_INVALID_NUMBER_MESSAGE);
            }
        }
    }

    private LocalDate readDate(Scanner scanner) {
        while (true) {
            try {
                IO.print(MessageProvider.ENTER_DATE_MESSAGE);
                String date = scanner.nextLine().trim();

                if (date.isEmpty()) {
                    IO.println(MessageProvider.DATE_EMPTY_MESSAGE);
                } else if (!DATE_PATTERN.matcher(date).matches()) {
                    IO.println(MessageProvider.DATE_INVALID_FORMAT_MESSAGE);
                } else {
                    LocalDate parsedDate = LocalDate.parse(date);

                    if (parsedDate.isBefore(LocalDate.now())) {
                        IO.println(MessageProvider.DATE_PAST_MESSAGE);
                    } else {
                        return parsedDate;
                    }
                }

            } catch (DateTimeParseException _) {
                IO.println(MessageProvider.DATE_INVALID_MESSAGE);
            }
        }
    }

    private void displayCategories() {
        int count = 1;

        IO.println(MessageProvider.CATEGORIES_HEADER_MESSAGE);

        for (Category category : Category.values()) {
            IO.println(count + ". " + category);
            count++;
        }
    }
}