package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает копию массива items без null элементов (без пустых клеток).
     * @return массив items без null элементов (без пустых клеток)
     */
    public Item[] findAll() {
        Item[] itemWithoutNull = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item != null) {
                itemWithoutNull[size] = item;
                size++;
            }
        }
        itemWithoutNull = Arrays.copyOf(itemWithoutNull, size);
        return itemWithoutNull;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая name с аргументом String key.
     * @return Массив у которых name совпадает с аргументом String key
     */
    public Item[] findByName(String key) {
        Item[] itemContainsKey = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemContainsKey[size] = item;
                size++;
            }
        }
        itemContainsKey = Arrays.copyOf(itemContainsKey, size);
        return itemContainsKey;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая id с аргументом String id.
     * @return возвращает найденный Item или если Item не найден - null.
     */
    public Item findById(String id) {
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}