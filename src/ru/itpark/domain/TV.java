package ru.itpark.domain;

public class TV extends Product{
    private int diagonalInInches;

    public TV(String category, String firm, int price, int diagonal) {
        super(category, firm, price);
        this.diagonalInInches = diagonal;
    }

    public int getDiagonal() {
        return diagonalInInches;
    }

    public void setDiagonal(int diagonal) {
        this.diagonalInInches = diagonal;
    }

    @Override
    public String toString() {
        return "TV{" +
                "diagonalInInches=" + diagonalInInches +
                "} " + super.toString() + "\n";
    }
}
