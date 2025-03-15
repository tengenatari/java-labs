import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
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
    public static void main(String[] args) {
        while(true){
            
        }
    }
}