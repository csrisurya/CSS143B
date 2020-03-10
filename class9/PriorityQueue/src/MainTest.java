import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class MainTest {
    @Test
    public void test1() {

        PriorityQueue<Task> taskQueue = new PriorityQueue <> (5, new TaskComparator());

        taskQueue.add(new Task(9, "play video game"));

        taskQueue.add(new Task(9, "sleep"));

        taskQueue.add(new Task(0, "assign homework 7"));

        taskQueue.add(new Task(5, "prepare slides 5"));

        taskQueue.add(new Task(9, "eat"));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }

    private long testLinearBuild(List<Task> tasks, int length) {
        PriorityQueue<Task> pq = new PriorityQueue<>(length, new TaskComparator());

        long startTime = System.nanoTime();

        pq.addAll(tasks);

        long endTime = System.nanoTime();

        pq.clear();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    private long testNlogNBuild(List<Task> tasks, int length) {
        PriorityQueue<Task> pq = new PriorityQueue<>(length, new TaskComparator());

        long startTime = System.nanoTime();

        for (Task task : tasks) {
            pq.add(task);
        }

        long endTime = System.nanoTime();

        pq.clear();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    @Test
    public void timePQBuild() {
        int start = 100000;
        int end = start * 100;
        for (int i=start; i<=end; i+=200000) {
            int length = i;
            List<Task> tasks = new ArrayList<>(i);
            for (int j=0; j<length; j++) {
               tasks.add(new Task(j, "task:"+ j));
            }
            List<Task> taskCopy = new ArrayList<>(tasks);

            long tN = testLinearBuild(tasks, length);

            long tNlogN = testNlogNBuild(tasks, length);

            tasks.clear();
            taskCopy.clear();

            System.out.printf("%d %d %d\n", length, tN, tNlogN);
        }
    }
}
