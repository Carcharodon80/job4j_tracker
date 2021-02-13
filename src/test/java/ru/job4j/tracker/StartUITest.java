package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }


    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenShowItems() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("New Item 1"));
        tracker.add(new Item("New Item 2"));
        List<UserAction> actions = Arrays.asList(new ShowAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln
                + "0. Show all Items" + ln
                + "1. Exit" + ln
                + "All items:" + ln
                + "id = 1, name = New Item 1" + ln
                + "id = 2, name = New Item 2" + ln
                + "Menu" + ln
                + "0. Show all Items" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("New Item"));
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln
                + "0. Find Item by Id" + ln
                + "1. Exit" + ln
                + "id = 1, name = New Item" + ln
                + "Menu" + ln
                + "0. Find Item by Id" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Fix it!", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("Fix it!"));
        tracker.add(new Item("Fix it!"));
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln
                + "0. Find Items by Name" + ln
                + "1. Exit" + ln
                + "id = 1, name = Fix it!" + ln
                + "id = 2, name = Fix it!" + ln
                + "Menu" + ln
                + "0. Find Items by Name" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExi() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"99", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format("Menu%n"
                        + "0. Exit%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "Menu%n"
                        + "0. Exit%n"
                )));
    }
}