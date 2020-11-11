package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(trackerSingleton1.tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        Item item = trackerSingleton1.tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(trackerSingleton1.tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        Item item = trackerSingleton1.tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertNull(trackerSingleton1.tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        UserAction[] actions = {new Exit()};
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenShowItems() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        String ln = System.lineSeparator();
        trackerSingleton1.tracker.add(new Item("New Item 1"));
        trackerSingleton1.tracker.add(new Item("New Item 2"));
        UserAction[] actions = {new ShowAction(out), new Exit()};
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Show all Items" + ln +
                "1. Exit" + ln +
                "All items:" + ln +
                "id = 1, name = New Item 1" + ln +
                "id = 2, name = New Item 2" + ln +
                "Menu" + ln +
                "0. Show all Items" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1", "1"});
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        String ln = System.lineSeparator();
        trackerSingleton1.tracker.add(new Item("New Item"));
        UserAction[] actions = {new FindByIdAction(out), new Exit()};
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Find Item by Id" + ln +
                "1. Exit" + ln +
                "id = 1, name = New Item" + ln +
                "Menu" + ln +
                "0. Find Item by Id" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Fix it!", "1"});
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        String ln = System.lineSeparator();
        trackerSingleton1.tracker.add(new Item("Fix it!"));
        trackerSingleton1.tracker.add(new Item("Fix it!"));
        UserAction[] actions = {new FindByNameAction(out), new Exit()};
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Find Items by Name" + ln +
                "1. Exit" + ln +
                "id = 1, name = Fix it!" + ln +
                "id = 2, name = Fix it!" + ln +
                "Menu" + ln +
                "0. Find Items by Name" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExi() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"99", "0"}
        );
        TrackerSingleton1 trackerSingleton1 = TrackerSingleton1.INSTANCE;
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, trackerSingleton1, actions);
        assertThat(out.toString(), is(
                String.format("Menu%n"
                        + "0. Exit%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "Menu%n"
                        + "0. Exit%n"
                )));
    }
}