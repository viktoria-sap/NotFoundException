package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

public class CartManager {
    private CartRepository repository;

    public void removeById(int id) {
        repository.removeById(id);
        System.out.println("manager done"); // for demo only
    }

    public CartManager(CartRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {
        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}
