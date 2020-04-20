package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1");
        Item itemTwo = new Item("test2");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        ArrayList<Item> result = (ArrayList<Item>) tracker.findAll();
        assertThat(result, is(new ArrayList<>(Arrays.asList(itemOne, itemTwo))));
    }

    @Test
    public void findItemByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1");
        tracker.add(itemOne);
        ArrayList<Item> result = (ArrayList<Item>) tracker.findByName("test1");
        assertThat(result, is(new ArrayList<>(Arrays.asList(itemOne))));
    }

    @Test
    public void findItemById() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1");
        tracker.add(itemOne);
        Item result = tracker.findById(itemOne.getId());
        assertThat(result, is(itemOne));
    }

    @Test
    public void findItemByIncorrectId() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1");
        tracker.add(itemOne);
        Item result = tracker.findById("TEST");
        assertNull(result);
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}