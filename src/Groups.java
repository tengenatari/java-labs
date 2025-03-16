import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Groups {
    private ArrayList<StudentGroup> groups = new ArrayList<>();

    public void addGroup(Object method) throws FileNotFoundException {
        StudentGroup group = new StudentGroup("keyboard");
        groups.add(group);
        group.printStudents();
    }
    public void printGroups() {
        for (StudentGroup group : groups) {
            group.printStudents();
        }
    }
    public void printGoodStudents() {
        for (StudentGroup group : groups) {
            group.printGoodStudents();
        }
    }
    public void sort(){
        for (StudentGroup group : groups) {
            group.sort();
        }
    }
}
