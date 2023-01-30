package utils;

public enum SearchDropDown {
    NAME("Name"),
    EMAIL("Email"),
    CITY("City"),
    ID("Id");

    private String value;

    SearchDropDown(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}