import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class StudentGroup{
    private String group_name;
    private ArrayList<Student> students = new ArrayList<>();
    private Comparator<Student> comparator = null;
    public StudentGroup(Object method) throws FileNotFoundException {
        this.setGroup_name(method);
        this.addStudents(method, true);

    }
    public void setComparator(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public void setGroup_name(Object method) throws FileNotFoundException {
        if(method.equals("keyboard")){
            System.out.println("Input group name\n");
            Scanner scanner = new Scanner(System.in);

            this.group_name = scanner.nextLine();

        }
        else if(method.equals("random")){
            this.group_name = Main.generate_random_string();
        }
        else if(method instanceof Scanner scanner){
            this.group_name = scanner.nextLine();
        }
    }
    public void addStudents(Object method, Boolean set_name) throws FileNotFoundException {
        int count = 10;
        if(method instanceof String) {
            if (method.equals("keyboard")) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Input num of students to add");
                count = scanner.nextInt();


            } else if (!method.equals("random")) {
                File doc = new File((String) method);
                method = new Scanner(doc);
                if (set_name) {
                    this.group_name = ((Scanner) method).nextLine();
                }
                count = Integer.parseInt(((Scanner) method).nextLine());
            }
        }
        else{
            throw new IllegalArgumentException("...");
        }

        for (int i = 0; i < count; i++){
            Student student = new Student(method);
            students.add(student);
        }
    }

    public void sort(){
        students.sort(this.comparator);
    }

    @Override
    public String toString(){
        return String.format("%s %d\n", this.group_name, this.students.size());
    }

    public void printStudents(){
        System.out.printf("Group name: %s", this);
        System.out.println("Students: ");
        for (Student student : students){
            System.out.println(student);
        }
    }
    public void printGoodStudents(){
        System.out.printf("Group name: %s", this);
        for (Student student : students){
            if(student.is_only_good_marks()){
                System.out.println(student);
            }
        }
    }
}

