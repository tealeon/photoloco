package at.htl.photoloco.entity;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private final int value;

    Rating(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
