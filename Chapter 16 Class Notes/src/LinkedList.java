import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    // first refers to the head(first Node) of the list
    // if the list is empty, first will be null
    private Node head;

    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.head = null;
    }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst(){
        
        return null;
    }

    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if (this.head == null){
            throw new NoSuchElementException();
        }
        Object element = this.head.data;
        this.head = this.head.next;
        return element;
    }


    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element){
         Node newNode = new Node();
         newNode.data = element;
         newNode.next = head;
         this.head = newNode;
    }

    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator(){
        return new LinkedListIterator();
    }

    public String toString(){
        if (head == null){
            return "[]";
        }

        // StringBuilder is mutable
        // It is more efficient for manipulating strings
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node current = head;
        while (current !=null){
            if(current.next==null) sb.append(current.data);
            else sb.append(current.data + ", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    //Class Node
    //Node is static because it does NOT need to access anything in LinkedList
    // The Node object willl store information, not interact
    static class Node{
        public Object data = null;
        public Node next;
    }

    class LinkedListIterator implements ListIterator
    {
        //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            if(position == null){
                position = head;
            }
            else{
                previous = position;

                position = position.next;
            }
            
            isAfterNext = true;

            return position.data;
        }

        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
       public boolean hasNext(){
            //Check if the list is empty if the iterator hasn't moved
            if (position == null){
                return head != null;
            }
            // the iterator has moved so check the next node
            return position.next != null;
       }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
       public void add(Object element){
            //Check if the iterator is at the beginning
            if (position == null){
                addFirst(element);
                position = head;
            }
            else{
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;

                //Set the next element of the current position to point to our new Node
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;

       }

        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(){
            if (!isAfterNext){
                throw new IllegalStateException();
            }
        
            //check if the iterator is at the beginning
            if (position == head){
                removeFirst();
                position = null;
            }
            else{
                previous.next = position.next;
                position = previous;

            }

            isAfterNext = false;
        }

        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
            position.data = element;
        
        //we don't have to reset isAfterNext because the structure of the list has not changed
        }

    }//LinkedListIterator
}//LinkedList
