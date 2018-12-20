package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.*;
import ru.itpark.repository.UlmartRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UlmartServiceFindTest {
    private UlmartService service;
    @BeforeEach
    void setUp() {
        UlmartRepository repository = new UlmartRepository();
        repository.add(new Phone("Phone","Nokia", 10_000,"Black"));
        repository.add(new Phone("Phone","Sony", 15_000,"Silver"));
        repository.add(new Phone("Phone","Motorola", 9_000,"Red"));
        repository.add(new Phone("Phone","Apple", 12_000,"White"));
        repository.add(new SmartPhone("Smartphone", "Apple", 80_000, "Silver", true, "6S"));
        repository.add(new SmartPhone("Smartphone", "Sony", 25_000, "Black", true, "Compact"));
        repository.add(new SmartPhone("Smartphone", "Apple", 40_000, "Silver", true, "5S"));
        repository.add(new SmartPhone("Smartphone", "Fox", 10_000, "Blue", false, "1.1.1."));
        repository.add(new TShirt("TShirt", "H&M", 1_000, "S", "White"));
        repository.add(new TShirt("TShirt", "H&M", 1_100, "M", "White"));
        repository.add(new TShirt("TShirt", "H&M", 900, "L", "White"));
        repository.add(new TShirt("TShirt", "Zara", 5_000, "XL", "White"));
        repository.add(new TShirt("TShirt", "Uniqlo", 2_000, "S", "White"));
        repository.add(new TV("TV","Sony", 100_000, 50));
        
        service = new UlmartService(repository);
    }

    @Test
    void findByFirmWithZeroResult() {
        List<Product> result = service.findByFirm("Panasonic");

        assertEquals(0,result.size());
    }
    @Test
    void findByFirmWithOneResult(){
        List<Product> result = service.findByFirm("Fox");

        assertEquals(1,result.size());
    }
    @Test
    void findByFirmWithMultipleResult() {
        List<Product> result = service.findByFirm("Sony");

        assertEquals(3,result.size());
    }

    @Test
    void findByCategoryWithZeroResult() {
        List<Product> result = service.findByCategory("Printer");

        assertEquals(0,result.size());
    }
    @Test
    void findByCategoryWithOneResult(){
        List<Product> result = service.findByCategory("TV");

        assertEquals(1,result.size());
    }
    @Test
    void findByCategoryWithMultipleResult() {
        List<Product> result = service.findByCategory("Smartphone");

        assertEquals(4,result.size());
    }

    @Test
    void findByPriceRangeWithZeroResult() {
        {
            int priceMin = 0;
            int priceMax = 899;
            List<Product> result = service.findByPriceRange(priceMin, priceMax);

            assertEquals(0, result.size());
        }
        {
            int priceMin = 110_000;
            int priceMax = 120_000;
            List<Product> result = service.findByPriceRange(priceMin, priceMax);

            assertEquals(0, result.size());
        }
    }
    @Test
    void findByPriceRangeWithOneResult(){
        int priceMin = 1_000;
        int priceMax = 1_000;
        List<Product> result = service.findByPriceRange(priceMin,priceMax);

        assertEquals(1,result.size());
    }
    @Test
    void findByPriceRangeWithMultipleResult() {
        int priceMin = 9_000;
        int priceMax = 12_000;
        List<Product> result = service.findByPriceRange(priceMin, priceMax);

        assertEquals(4,result.size());
    }
}