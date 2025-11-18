package developer.ezandro.domain;

import developer.ezandro.exception.CategoryNotFoundException;

public enum Category {
    FOOD(1),
    TRANSPORT(2),
    ENTERTAINMENT(3),
    HEALTH(4),
    EDUCATION(5),
    OTHER(6);

    private final int option;

    Category(int option) {
       this.option = option;
    }

    private int getOption() {
        return this.option;
    }

    public static Category fromOption(int option) {
        for (Category category : Category.values()) {
            if (category.getOption() == option) {
                return category;
            }
        }
        throw new CategoryNotFoundException(String.format("ERROR: Category %s not found. Please choose a valid category number.", option));
    }
}