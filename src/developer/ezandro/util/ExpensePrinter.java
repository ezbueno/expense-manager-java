package developer.ezandro.util;

public class ExpensePrinter {
    private ExpensePrinter() {
    }

    public static String formatCurrency(double value) {
        String formattedValue = String.format(MessageProvider.TOTAL_AMOUNT_FORMAT, value);

        return MessageProvider.TOTAL_SPENT_HEADER +
                "\n   " + formattedValue +
                "\n" + MessageProvider.TOTAL_SPENT_FOOTER;
    }
}
