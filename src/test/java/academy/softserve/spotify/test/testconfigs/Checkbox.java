package academy.softserve.spotify.test.testconfigs;

public enum Checkbox {
    MALE("//span[contains(text(),'Male')]"),
    FEMALE("//span[contains(text(),'Female')]"),
    NON_BINARY("//span[contains(text(),'Non-binary')]"),
    SHARE("//span[contains(text(),'Share')]"),
    SPAM("//span[contains(text(),'Please send me Spotify marketing messages')]"),
    AGREMENT_HEADER("//body/div[@id='__next']/main/div/div/label/span[1]"),
    AGREEMENT("//body/div/main/div/form/div[9]/label[1]/span[1]"),
    CAPTCHA("//div[9]//label[1]//span[2]");


    private String value;

    Checkbox(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
