package ru.netology.manager;

import exception.NotFoundException;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;
import service.Service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartManagerTest {

    CartRepository repository = new CartRepository();
    CartManager manager = new CartManager(repository);
    private Service service = new Service();

    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @Test
    public void shouldNotRemoveIfNotExists() {

        int id = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(id);

        assertThrows(NotFoundException.class, () -> service.throwUnchecked());
    }

    @Test
    public void shouldNotRemoveIfExists() {

        int id = 3;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(id);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowUncheckedException() {
        assertThrows(NotFoundException.class, () -> service.throwUnchecked());
    }
}