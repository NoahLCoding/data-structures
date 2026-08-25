import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        //addLast method can be used to populate 
        LinkedList<String> staff = new LinkedList<String>();
        staff.addLast("Tony");
        staff.addLast("Steve");
        staff.addLast("Wanda");
        staff.addLast("Dr.Strange");
        System.out.println(staff);

        // this list is currently TSWD
        /*
            The lisIterator method creates a new list iterator that is positioned at the head of the list. 
            The | is used to represent the iterator position.
        */
        ListIterator<String> iterator = staff.listIterator(); //  |TSWD

        
        //the next method advanced the iterator over the next element in the list.
        iterator.next();// T|SWD
        // the next method also returns the element the iterator passes over.
        String avenger = iterator.next();//TS|WD
        System.out.println(avenger);

        //The iterator add method inserts an element at the iterator position
        //The iterator is then positioned after the element that was added

        iterator.add("Natasha");// TSN|WD
        iterator.add("Bruce");// TSNB|WD

        System.out.println(staff);
        //the remove method removes the element returned by the last call to next or previous
        //the remove method can only be called after calling next or previous
        //the remove method cannot be called after calling add.
        
        iterator.next();// TSNBW|D
        iterator.remove();// TSNB|D

        System.out.println(staff);
        // The set ethod updates the element returned by the last call to next or previous

        iterator.previous(); // TSN|BD
        iterator.set("T'Challa"); // TSN|TD

        System.out.println(staff);

        iterator = staff.listIterator();//|TSNTD
        
        while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")){// TSN|TD
                iterator.remove(); // TS|TD
            }
        } // TSTD|

        System.out.println(staff);
    
        //Enhanced for loops work with linked lists
        //the enhanced for loop AUTOMATICALLY creats an iterator
        for (String n: staff){
            System.out.print(n+" ");
        }
        
        /*
            ConcurrentModificationException

            Cannot modify a linked list while using an iterator
            unless you use the iterator to do the modification
        */

        iterator = staff.listIterator(); // |TSTD
        while (iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Tony")){
                //staff.remove("Tony"); ConcurrentModificationException
            }
        }
        
    }
}
