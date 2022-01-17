package sample;

public class Tasks {
    private String deadline;
    private String course;
    private String task;

    public Tasks(String deadline, String course, String task) {
        this.deadline = deadline;
        this.course = course;
        this.task = task;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
