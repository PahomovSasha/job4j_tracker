package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createNewItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItem2() {
        String[] answers = {"TEST", "DRIVE"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createNewItem(input, tracker);
        StartUI.createNewItem(input, tracker);
        Item created = tracker.findAll()[1];
        Item expected = new Item("DRIVE");
        assertThat(created.getName(), is(expected.getName()));
    }
}
