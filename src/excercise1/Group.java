package excercise1;

import java.util.List;

public class Group {
    public String name;
    public List<Process> Processes;

    public Group(String name, List<Process> processes) {
        this.name = name;
        Processes = processes;
    }
}
