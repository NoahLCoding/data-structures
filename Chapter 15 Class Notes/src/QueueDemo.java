import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print que of string (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        // Add some print jobs
        jobs.add("Jason: Quarter 2 Expense Report");
        jobs.add("Evan: Recipe for Banana Bread");
        jobs.add("Emily: Top Secret Document");

        System.out.println("Printing: " + jobs.remove()); //Prints Jason

        //Add some more print jobs
        jobs.add("Noah: Grocery List");
        jobs.add("Emily: Really Top Secret Document");
        jobs.add("Emily: Can I get Fired For This?");
        
        System.out.println("Printing: " + jobs.remove()); // Prints Evan's
        System.out.println("Printing: " + jobs.remove()); // Prints Emily

        jobs.add("Boss: Emily's Termination Letter");
        int numJobs = jobs.size();
        for (int i = 0; i<numJobs; i++){
            System.out.println("Printing: " + jobs.remove());

        }

        //Create a to-do list
        // The Work Order class has an int priority and a String description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        // Lower priority is considered more important
        toDo.add(new WorkOrder(3, "WaterPlants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(1, "Conquer the World"));
        toDo.add(new WorkOrder(9, "Play videogames"));
        toDo.add(new WorkOrder(1, "Study for the Ch. 15 Quiz"));

        System.out.println(toDo);
        while(toDo.size()>0){
            System.out.println(toDo.remove());
        }
    }
}
