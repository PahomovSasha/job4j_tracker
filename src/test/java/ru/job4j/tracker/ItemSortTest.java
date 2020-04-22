package ru.job4j.tracker;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void whenDescCompatorByName() {
        Comparator<Item> cmpNamePriority = new ItemDescByName();
        int rsl = cmpNamePriority.compare(
                new Item("Паша"),
                new Item("Саша")
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscCompatorByName() {
        Comparator<Item> cmpNamePriority = new ItemAscByName();
        int rsl = cmpNamePriority.compare(
                new Item("Паша"),
                new Item("Саша")
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenStringsAreEqualThenZero() {
        Comparator<Item> cmpNamePriority = new ItemAscByName();
        int rsl = cmpNamePriority.compare(
                new Item("Паша"),
                new Item("Паша")
        );
        assertThat(rsl, is(0));
    }
}
