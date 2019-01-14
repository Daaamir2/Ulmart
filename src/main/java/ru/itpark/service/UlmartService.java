package ru.itpark.service;

import ru.itpark.domain.Product;
import ru.itpark.repository.UlmartRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> findByFirmList = Collections.singletonList(firm);

        return repository.getAll().stream()
                .filter(product -> findByFirmList.contains(product.getFirm()))
                .collect(Collectors.toList());
    }

    public List<Product> findByCategory(String category) {
        List<String> findByCategoryList = Collections.singletonList(category);

        return repository.getAll().stream()
                .filter(product -> findByCategoryList.contains(product.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Product> findByPriceRange(int priceMin, int priceMax) {
        return repository.getAll().stream()
                .filter(product -> product.getPrice() >= priceMin && product.getPrice() <= priceMax)
                .collect(Collectors.toList());
    }
}
