package ru.itpark.comparator;

import ru.itpark.domain.Product;

import java.io.Serializable;
import java.util.Comparator;

public class FirmComparator implements Comparator<Product>, Serializable {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getFirm().compareTo(o2.getFirm());
    }
}
