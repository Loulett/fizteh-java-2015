package ru.fizteh.fivt.students.loulett.threads.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Sasha on 17.12.2015.
 */
public class QueueBlock<T> {
    private Queue<T> queue;
    private final Integer maxSize;

    QueueBlock(int number) {
        maxSize = number;
        queue = new LinkedList<>();
    }

    synchronized void offer(List<T> list) throws InterruptedException {
        while (queue.size() + list.size() > maxSize) {
            wait();
        }
        queue.addAll(list);
        notifyAll();
    }

    synchronized List<T> take(int n) throws InterruptedException {
        while (queue.size() < n) {
            wait();
        }
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            result.add(queue.remove());
        }
        notifyAll();
        return result;
    }
}
