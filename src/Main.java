import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;


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
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Groups groups = new Groups();
        int input = 100;
        while(input != 9 ){
            Main.HelloMessage();
            input = scanner.nextInt();
            switch (input){
                case 1: Main.addGroup(groups); break;
                case 2: groups.printGroups(); break;
                case 3: groups.printGoodStudents(); break;
                case 4: groups.defaultSort(); break;
                case 5: groups.sortUsingInstance();
                case 6: groups.sortUsingLambda(); break;
                default: break;
            }
        }
    }
}