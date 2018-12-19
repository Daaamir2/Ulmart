package ru.itpark.service;

import ru.itpark.domain.Product;
import ru.itpark.repository.UlmartRepository;

import java.util.Comparator;
import java.util.List;

public class UlmartService {
    private UlmartRepository repository;

    public UlmartService(UlmartRepository repository){
        this.repository = repository;
    }

    public void add(Product product){
        repository.add(product);
    }

    public List<Product> getAll(){
        return repository.getAll();
    }

    public List<Product> getSorted(Comparator<Product> comparator){
        List<Product> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public UlmartService findByFirm(String firm){
        UlmartService service = new UlmartService(new UlmartRepository());
        for (Product product : repository.getAll()) {
            if(product.getFirm().equalsIgnoreCase(firm)){
                service.add(product);
            }
        }
        return service;
    }

    public UlmartService findByCategory(String category){
        UlmartService service = new UlmartService(new UlmartRepository());
        for (Product product : repository.getAll()) {
            if(product.getCategory().equalsIgnoreCase(category)){
                service.add(product);
            }
        }
        return service;
    }
}
