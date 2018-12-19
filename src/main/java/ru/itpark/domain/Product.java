package ru.itpark.domain;

public abstract class Product {
    private String category;
    private String firm;
    private int price;

    public Product(String category, String firm, int price) {
        this.category = category;
        this.firm = firm;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", firm='" + firm + '\'' +
                ", price=" + price +
                '}';
    }
}
