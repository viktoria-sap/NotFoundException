package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTest {

    CartRepository repository = new CartRepository();
    CartManager manager = new CartManager(repository);

    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @Test
    public void shouldNotRemoveIfNotExists() {

        int idToRemove = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        try {
            manager.removeById(idToRemove);
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("Element with id: " + id + " not found");
        }

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfExists() {

        int idToRemove = 3;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        try {
            manager.removeById(idToRemove);
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("NotFoundException");
        }

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }
}