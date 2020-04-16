package ru.netology.repository;

import ru.netology.domain.PurchaseItem;
import ru.netology.exception.NotFoundException;

public class CartRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void removeById(int id) {
        if (findById(id) != null) {
            int length = items.length - 1;
            PurchaseItem[] tmp = new PurchaseItem[length];
            int index = 0;
            for (PurchaseItem item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
        else {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
    }


    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public PurchaseItem findById(int id) {
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}