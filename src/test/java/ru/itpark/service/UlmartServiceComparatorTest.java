package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.comparator.FirmIncComparator;
import ru.itpark.comparator.PriceDecComparator;
import ru.itpark.comparator.PriceIncComparator;
import ru.itpark.domain.*;
import ru.itpark.repository.UlmartRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UlmartServiceComparatorTest {
    private UlmartService service;

    @BeforeEach
    void setUp() {
        UlmartRepository repository = new UlmartRepository();

        repository.add(new Phone("Phone", "Nokia", 10_000, "Black"));
        repository.add(new Phone("Phone", "Sony", 15_000, "Silver"));
        repository.add(new SmartPhone("Smartphone", "Apple", 80_000, "Silver", true, "6S"));
        repository.add(new SmartPhone("Smartphone", "Sony", 25_000, "Black", true, "Compact"));
        repository.add(new TShirt("TShirt", "H&M", 1_000, "S", "White"));
        repository.add(new TV("TV", "Sony", 100_000, 50));

        service = new UlmartService(repository);
    }

    @Test
    void findIncComparatorTest() {
        List<Product> sort = service.getSorted(new FirmIncComparator());

        List<String> result = sort.stream()
                .map(Product::getFirm)
                .collect(Collectors.toList());

        List<String> expected = Arrays.asList("Apple", "H&M", "Nokia", "Sony", "Sony", "Sony");
        assertEquals(expected, result);
    }

    @Test
    void priceDecComparatorTest() {
        List<Product> sort = service.getSorted(new PriceDecComparator());
        List<Integer> result = sort.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        List<Integer> expected = Arrays.asList(100_000, 80_000, 25_000, 15_000, 10_000, 1_000);
        assertEquals(expected, result);
    }

    @Test
    void priceIncComparatorTest() {
        List<Product> sort = service.getSorted(new PriceIncComparator());
        List<Integer> result = sort.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        List<Integer> expected = Arrays.asList(1_000, 10_000, 15_000, 25_000, 80_000, 100_000);
        assertEquals(expected, result);
    }
}