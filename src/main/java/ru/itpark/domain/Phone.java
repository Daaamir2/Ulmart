package ru.itpark.domain;

public class Phone extends Product {
    private String colour;

    public Phone(String category, String firm, int price, String colour) {
        super(category, firm, price);
        this.colour = colour;

    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "colour='" + colour + '\'' +
                "} " + super.toString() + "\n";
    }
}
