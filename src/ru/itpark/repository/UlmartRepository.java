package ru.itpark.repository;

import ru.itpark.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class UlmartRepository {
    private List<Product> items = new ArrayList<>();

    public void add(Product item){
        items.add(item);
    }

    public List<Product> getAll(){
        return items;
    }
}
