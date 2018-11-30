package ru.itpark.domain;

public class TShirt extends Product{
    private String size;
    private String colour;

    public TShirt(String category, String firm, int price, String size, String colour) {
        super(category, firm, price);
        this.size = size;
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                "} " + super.toString() + "\n";
    }
}
