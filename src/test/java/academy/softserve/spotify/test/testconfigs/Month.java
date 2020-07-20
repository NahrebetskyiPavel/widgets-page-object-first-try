package academy.softserve.spotify.test.testconfigs;

public enum Month {
    January("January"),
    February("February"),
    March("March"),
    April("April"),
    May("May"),
    June("June"),
    July("July"),
    August("August"),
    September("September"),
    October("October"),
    November("November"),
    December("December");
    private String value;

    Month(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
