package ru.itpark;

import ru.itpark.domain.Phone;
import ru.itpark.domain.SmartPhone;
import ru.itpark.domain.TV;
import ru.itpark.service.UlmartService;
import ru.itpark.comparator.FirmIncComparator;
import ru.itpark.comparator.PriceIncComparator;
import ru.itpark.domain.TShirt;
import ru.itpark.repository.UlmartRepository;

public class Main {
    public static void main(String[] args) {
        UlmartService service = new UlmartService(new UlmartRepository());

        service.add(new Phone("Phone","Nokia", 10_000,"Black"));
        service.add(new Phone("Phone","Sony", 15_000,"Silver"));
        service.add(new Phone("Phone","Motorola", 9_000,"Red"));
        service.add(new Phone("Phone","Apple", 12_000,"White"));

        service.add(new SmartPhone("Smartphone", "Apple", 80_000, "Silver", true, "6S"));
        service.add(new SmartPhone("Smartphone", "Sony", 25_000, "Black", true, "Compact"));
        service.add(new SmartPhone("Smartphone", "Apple", 40_000, "Silver", true, "5S"));
        service.add(new SmartPhone("Smartphone", "Fox", 10_000, "Blue", false, "1.1.1."));

        service.add(new TShirt("TShirt", "H&M", 1_000, "S", "White"));
        service.add(new TShirt("TShirt", "H&M", 1_100, "M", "White"));
        service.add(new TShirt("TShirt", "H&M", 900, "L", "White"));
        service.add(new TShirt("TShirt", "Zara", 5_000, "XL", "White"));
        service.add(new TShirt("TShirt", "Uniqlo", 2_000, "S", "White"));

        service.add(new TV("TV","Sony", 100_000, 50));
        service.add(new TV("TV","Sony", 150_000, 54));

        System.out.println(service.findByFirm("Apple").getSorted(new FirmIncComparator()));
        System.out.println(service.findByCategory("Smartphone").getSorted(new FirmIncComparator()));
        System.out.println(service.getSorted(new PriceIncComparator()));

    }
}
