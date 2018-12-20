package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Product {
    private String category;
    private String firm;
    private int price;
}
