package developer.ezandro.util;

import module java.base;
import developer.ezandro.domain.Expense;

public class ExpenseFormatter {
    private ExpenseFormatter() {
    }

    public static String format(Expense expense) {
        return String.format("%s" +
                        "\n   %-12s: %d" +
                        "\n   %-12s: %s" +
                        "\n   %-12s: %s" +
                        "\n   %-12s: " + MessageProvider.AMOUNT_FORMAT +
                        "\n   %-12s: %s" +
                        "\n%s",
                MessageProvider.EXPENSE_DETAILS_HEADER,
                MessageProvider.ID_LABEL, expense.id(),
                MessageProvider.DESCRIPTION_LABEL, expense.description(),
                MessageProvider.CATEGORY_LABEL, expense.category(),
                MessageProvider.AMOUNT_LABEL, expense.amount(),
                MessageProvider.DATE_LABEL, formatDate(expense.date()),
                MessageProvider.EXPENSE_DETAILS_FOOTER
        );
    }

    private static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(MessageProvider.DATE_FORMAT));
    }
}
