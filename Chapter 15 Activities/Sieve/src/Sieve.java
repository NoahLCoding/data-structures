import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        Set<Integer> list = new HashSet<>();
        for(int i= 2; i<=n; i++){
            list.add(i);
        }
        for(int i=2; i<=n; i++){
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                int num = iterator.next();
                if (num % i == 0 && num!=i){
                    iterator.remove();
                }
            }
        }
        System.out.print(list);
    }
}
