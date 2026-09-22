import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\nnlatakas\\Desktop\\Software Engineering\\data-structures\\Chapter 15 Activities\\HTMLChecker\\src\\TagSample2.html";
        Stack<String> htmlTags = new Stack<>();
        
        try (Scanner in = new Scanner(new File(filename)))
        {
            String tags = "";
            while (in.hasNext()){
                String tag = in.next();
                tags += tag + " ";

            }
            
            String[] tagArray = tags.split(" ");
            for (int i = 0; i < tagArray.length; i++){
                String tag = tagArray[i];
                if (tag.startsWith("<") && !tag.startsWith("</")){
                    htmlTags.push(tag);
                } 
                else if (tag.startsWith("</")){
                    if (htmlTags.isEmpty()){
                        System.out.println("Error: There is a closing tag without an opening tag.");
                        return;
                    }
                    String openingTag = htmlTags.pop();
                    if (!openingTag.substring(1).equals(tag.substring(2))){
                        System.out.println("Error: The closing tag " + tag + " does not match the opening tag " + openingTag);
                        return;
                    }
                }
            }

            if (htmlTags.isEmpty()){
                System.out.println("All tags are properly nested.");
            } else {
                System.out.println("Error: There are unclosed tags.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
