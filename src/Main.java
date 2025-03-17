import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.util.stream.Stream;


public class Main {
    public static String generate_random_string(){
        Random rng = new Random();
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        final int length = 6;
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public static ArrayList<Integer> generate_random_list(){
        Random rng = new Random();
        final int length = 10;
        ArrayList<Integer> marks = new ArrayList<>();

        for(int i = 0; i < length; i++ ){
            marks.add(rng.nextInt(2, 5));
        }
        return marks;
    }
    public static void addGroup(Groups group) throws FileNotFoundException {
        System.out.println("Enter method to add group");
        System.out.println("options: keyboard, random or filename(/users/students.txt)");
        Scanner scanner = new Scanner(System.in);
        group.addGroup(scanner.nextLine());
    }
    public static void HelloMessage(){
        System.out.println("Options: \n" +
                "1 - addGroup\n" +
                "2 - viewAllStudents\n" +
                "3 - viewGoodStudents\n" +
                "4 - sortAllGroups\n" +
                "5 - sortAllGroupsUsingInstance\n" +
                "6 - sortAllGroupsUsingLambda\n" +
                "9 - exit");
    }
    public static void print_using_iter(Iterator<Object> iterator){
        while (iterator.hasNext())
            System.out.println(iterator.next());
    };
    public static void main(String[] args) throws FileNotFoundException {
        StudentGroup group = new StudentGroup("random");
        group.printStudents();
        Stream<Student> stream = group.getStudents().stream();

        System.out.println("After stream");
        System.out.println("1 task");

        stream = group.getStudents().stream();
        var iterator_task_1 = stream
                .filter(e -> e.get_average() > 3.0)
                .iterator();
        while (iterator_task_1.hasNext())
            System.out.println(iterator_task_1.next());


        System.out.println("2 task");

        stream = group.getStudents().stream();
        var iterator_task_2 = stream.
                map(Student::get_average)
                .iterator();

        while (iterator_task_2.hasNext())
            System.out.println(iterator_task_2.next());


        System.out.println("3 task");

        stream = group.getStudents().stream();

        var iterator_task_3 = stream.
                peek(e -> {e.setName("Andrey Zhilin");})
                .iterator();
        while (iterator_task_3.hasNext())
            System.out.println(iterator_task_3.next());

        System.out.println("Task 4");

        stream = group.getStudents().stream();
        int n = 5;
        var iterator_task_4 = stream
                .limit(n)
                .iterator();

        while (iterator_task_4.hasNext())
            System.out.println(iterator_task_4.next());

        System.out.println("Task 5");

        stream = group.getStudents().stream();
        int length = group.getStudents().size();
        var iterator_task_5 = stream
                .skip(Math.max(0, length - n))
                .iterator();

        while (iterator_task_5.hasNext())
            System.out.println(iterator_task_5.next());

        System.out.println("task 6");

        stream = group.getStudents().stream();
        var array = stream.toArray();

        System.out.println(Arrays.toString(array));

        System.out.println("task 7 ");

        stream = group.getStudents().stream();

        var iterator_task_7 = stream
                .min((a, b) -> a.get_average().compareTo(b.get_average()));
        System.out.println(iterator_task_7);

        System.out.println("task 8");
        stream = group.getStudents().stream();
        var iterator_task_8 = stream.anyMatch(Student::is_only_good_marks);
        System.out.println(iterator_task_8);

        System.out.println("task 9 ");
        stream = group.getStudents().stream();
        var iterator_task_9 = stream.allMatch(e -> e.get_average() > 2.5);

        System.out.println(iterator_task_9);






    }
}