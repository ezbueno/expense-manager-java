package developer.ezandro.service;

import module java.base;
import developer.ezandro.domain.Expense;

public class ExpenseManager {
    private final List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public List<Expense> listAllExpenses() {
        return Collections.unmodifiableList(this.expenses);
    }

    public boolean hasExpenses() {
        return !this.expenses.isEmpty();
    }

    public double getTotalAmount() {
        return this.expenses
                .stream()
                .mapToDouble(Expense::amount)
                .sum();
    }

    public List<Expense> sortByDate() {
        return this.expenses
                .stream()
                .sorted(Comparator.comparing(Expense::date)
                        .reversed()
                        .thenComparing(Comparator.comparing(Expense::amount).reversed()))
                .toList();
    }

    public List<Expense> sortByAmount() {
        return this.expenses
                .stream()
                .sorted(Comparator.comparingDouble(Expense::amount)
                        .reversed()
                        .thenComparing(Comparator.comparing(Expense::date).reversed()))
                .toList();
    }
}