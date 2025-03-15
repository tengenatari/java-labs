import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static javax.management.Query.or;

public class StudentGroup{
    private String group_name;
    private ArrayList<Student> students = new ArrayList<>();
    private Comparator<Student> comparator = null;
    private StudentGroup(String name, Object... students){
        this.group_name = name;

        for(Object student: students){
            if(student instanceof Student)
                this.students.add((Student) student);
            else throw new IllegalArgumentException("...");
        }


    }
    public void setComparator(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public void addStudents(Object method) throws FileNotFoundException {
        int count = 10;
        if(method instanceof String) {
            if (method.equals("keyboard")) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Input num of students to add");
                count = scanner.nextInt();
                scanner.close();

            } else {
                File doc = new File((String) method);
                method = new Scanner(doc);
            }
        }
        else{
            throw new IllegalArgumentException("...");
        }

        for (int i = 0; i < count; i++){
            Student student = new Student(method);
            students.add(student);
        }

        if( method instanceof Scanner scanner){
            scanner.close();
        }

    }

    public void sort(){
        students.sort(this.comparator);
    }

    @Override
    public String toString(){
        return String.format("%s %d\n", this.group_name, this.students.size());
    }

}

