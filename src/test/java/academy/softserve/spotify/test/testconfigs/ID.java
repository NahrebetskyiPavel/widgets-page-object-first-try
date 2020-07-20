package academy.softserve.spotify.test.testconfigs;

public enum ID {
    EMAIL("email"),
    CONFIRM_EMAIL("confirm"),
    PASSWORD("password"),
    PROFILE_NAME("displayname"),
    DAY_OF_BIRTH("day"),
    MONTH_OF_BIRTH("month"),
    YEAR_OF_BIRTH("year");
    private String value;
    ID(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}