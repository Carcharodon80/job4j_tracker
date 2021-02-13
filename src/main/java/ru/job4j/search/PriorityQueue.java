package ru.job4j.search;

import java.util.LinkedList;

/**
 *
 */
public class PriorityQueue {
    /**
     *
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     *
     * @return
     */
    public Task take() {
        return tasks.poll();
    }
}
