import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. Then print out the word sets in
 * alphabetical order. Update the map by modifying
 * Worked Example 15.1.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\noahn\\OneDrive\\Desktop\\Software\\data-structures\\Chapter 15 Activities\\FirstLetterMap\\FirstLetterMap2\\src\\test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Character, Set<String>> words = new HashMap<>();
            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                if(words.get(c) == null){
                    Set<String> temp = new HashSet<>();
                    temp.add(word);
                    words.put(c, temp);
                }
                else{
                    words.get(c).add(word);
                }

            }
            Set<Character> keys = words.keySet();
            for (Character key: keys){
                System.out.println(key + ": " + words.get(key));
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
