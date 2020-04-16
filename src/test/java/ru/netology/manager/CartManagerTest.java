package ru.netology.manager;

import ru.netology.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartManagerTest {

    private CartRepository repository = new CartRepository();
    private CartManager manager = new CartManager(repository);

    private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @Test
    public void shouldNotRemoveIfNotExists() {

        int id = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        assertThrows(NotFoundException.class, () -> manager.removeById(id));
    }

    @Test
    public void shouldRemoveIfExists() {

        int id = 3;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(id);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

}