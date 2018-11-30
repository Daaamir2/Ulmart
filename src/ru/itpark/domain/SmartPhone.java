package ru.itpark.domain;

public class SmartPhone extends Phone {
    private boolean hasInternet;
    private String version;

    public SmartPhone(String category, String firm, int price, String colour, boolean hasInternet, String version) {
        super(category, firm, price, colour);
        this.hasInternet = hasInternet;
        this.version = version;
    }

    public boolean isHasInternet() {
        return hasInternet;
    }

    public void setHasInternet(boolean hasInternet) {
        this.hasInternet = hasInternet;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "hasInternet=" + hasInternet +
                ", version='" + version + '\'' +
                "} " + super.toString() + "\n";
    }
}
