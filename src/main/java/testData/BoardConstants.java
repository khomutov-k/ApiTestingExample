package testData;

public enum BoardConstants {
    NAME("Test board"),
    DESCRIPTION("Some new description");

    public final String value;

    @Override
    public String toString() {
        return this.value;
    }

    BoardConstants(String value) {
        this.value = value;
    }
}


