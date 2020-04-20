package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
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
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая name с аргументом String key.
     *
     * @return Массив у которых name совпадает с аргументом String key
     */
    public List<Item> findByName(String key) {
        ArrayList<Item> itemContainsKey = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemContainsKey.add(item);
            }
        }
        return itemContainsKey;
    }

    /**
     * Метод проверяет в цикле все элементы массива items, сравнивая id с аргументом String id.
     *
     * @return возвращает найденный Item или если Item не найден - null.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод возвращает index по id
     *
     * @param id заявки
     * @return index
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод заменяет заявку по id, при этом № id не меняется.
     *
     * @param id   заявки заменяемой заявки
     * @param item новая заявка
     * @return Если заявка заменилась - true, иначе false
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.set(index, item);
        return true;
    }

    /**
     * Метод удаляет заявку по id.
     *
     * @param id заявки
     * @return Если заявка удалилась - true, иначе false
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }
}