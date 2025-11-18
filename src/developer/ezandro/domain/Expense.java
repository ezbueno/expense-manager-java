package developer.ezandro.domain;

import module java.base;

public record Expense(Integer id,
        String description,
        Category category,
        double amount,
        LocalDate date) {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public Expense(String description,
                   Category category,
                   double amount,
                   LocalDate date) {
        this(ID_GENERATOR.getAndIncrement(), description, category, amount, date);
    }
}