package ir.maktabsharif105.jdbc.domain.enumeration;

public enum Grade {
    A(1), B(0), C(3), D(100);

    private final int level;

    Grade(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return switch (this) {
            case A -> "my A";
            case B -> "my B";
            case C -> "my C";
            case D -> "my D";
        };
    }
}
