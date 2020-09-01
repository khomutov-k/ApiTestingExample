package testData;

public enum ListConstants {
    NAME("Test list"),
    DESCRIPTION("Some new description for list");

    public final String value;

    @Override
    public String toString() {
        return this.value;
    }

    ListConstants(String value) {
        this.value = value;
    }
}