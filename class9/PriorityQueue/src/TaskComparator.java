import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        if (task1.priority<task2.priority) {
            return 1;
        } else if (task1.priority>task2.priority) {
            return -1;
        }
        return 0;
    }
}
