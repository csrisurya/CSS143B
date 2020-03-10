public class Task {
    int priority;
    String taskName;

    public Task(int priority, String taskName) {
        this.priority = priority;
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
