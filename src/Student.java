import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    private String name;
    private String place_of_birth;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(Object method){
        if(method.equals("keyboard")){

            System.out.println("Input student name\n");
            Scanner scanner = new Scanner(System.in);

            this.name = scanner.nextLine();
            System.out.println("Input student's place of birth");

            this.place_of_birth = scanner.nextLine();
            System.out.println("Input count of marks");

            int count = scanner.nextInt();


            for(int i = 0; i < count; i++){

                this.marks.add(scanner.nextInt());
            }
            scanner.close();
        }
        else if(method.equals("random")){
            this.name = Main.generate_random_string();
            this.place_of_birth = Main.generate_random_string();
            this.marks = Main.generate_random_list();
        }
        else if (method instanceof Scanner scanner) {

            this.name = scanner.nextLine();
            this.place_of_birth = scanner.nextLine();
            int count = scanner.nextInt();

            for(int i = 0; i < count; i++){

                this.marks.add(scanner.nextInt());
            }
        }
    }

    public Double get_average(){
        double average = 0;
        int n = this.marks.size();
        for (Integer mark : this.marks) average += mark;
        return average/n;
    }

    public Boolean is_only_good_marks(){
        for (Integer mark : this.marks)
            if(mark < 4)
                return false;
        return true;
    }

    @Override
    public int compareTo(Student o) {
        return this.get_average().compareTo(o.get_average());
    }
    @Override
    public String toString(){
        return String.format("%s %f\n", this.name, this.get_average());
    }
}
