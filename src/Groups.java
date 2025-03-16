import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Groups {
    private ArrayList<StudentGroup> groups = new ArrayList<>();

    public void addGroup(Object method) throws FileNotFoundException {
        StudentGroup group = new StudentGroup(method);
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
    public void defaultSort(){
        for (StudentGroup group : groups) {
            group.setComparator(null);
        }
        this.sort();
    };
    public void sortUsingLambda(){
        for (StudentGroup group : groups) {
            group.setComparator((a, b) -> a.get_average().compareTo(b.get_average()));
        }
        this.sort();
    }
    public void sortUsingInstance(){
        for (StudentGroup group : groups) {
            group.setComparator(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.get_average().compareTo(o2.get_average());
                }
            });
        }
        this.sort();
    }
}
