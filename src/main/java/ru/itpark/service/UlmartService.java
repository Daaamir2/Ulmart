package ru.itpark.service;

import ru.itpark.domain.Product;
import ru.itpark.repository.UlmartRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UlmartService {
    private UlmartRepository repository;

    public UlmartService(UlmartRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public List<Product> getSorted(Comparator<Product> comparator) {
        List<Product> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<Product> findByFirm(String firm) {
        List<Product> result = new ArrayList<>();
        List<String> findByFirmList = Arrays.asList(firm);
        for (Product product : repository.getAll()) {
            if (findByFirmList.contains(product.getFirm())) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();
        List<String> findByCategoryList = Arrays.asList(category);
        for (Product product : repository.getAll()) {
            if (findByCategoryList.contains(product.getCategory())) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findByPriceRange(int priceMin, int priceMax) {
        List<Product> result = new ArrayList<>();
        for (Product product : repository.getAll()) {
            if (product.getPrice() >= priceMin && product.getPrice() <= priceMax) {
                result.add(product);
            }
        }
        return result;
    }
}
