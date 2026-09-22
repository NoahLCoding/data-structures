import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\noahn\\OneDrive\\Desktop\\Software\\data-structures\\Chapter 15 Activities\\FirstLetterMap\\FirstLetterMap1\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {
            Map<Character,Set<String>> list = new HashMap<>();
            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);
                Set<String> temp = new HashSet<>();
                temp.add(word);
                list.merge(c, temp, (oldSet, newSet) -> {oldSet.addAll(newSet); return oldSet;});
            }

            Set<Character> keys = list.keySet();
            for (Character key: keys){
                System.out.println(key + ": " + list.get(key));
            }
            
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
