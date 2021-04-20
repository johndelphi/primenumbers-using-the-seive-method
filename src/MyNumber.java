import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// john michael
//course cosc 2436 2801
//date 4/19/2021
//description
/**
 * Create a class called MyNumber with an integer private attribute.
 * 
 * Create a constructor that defines an integer parameter to set the private
 * integer attribute.
 * 
 * Create a setter that validates the attribute does not accept a value lower
 * than 2 or the method will throw a IllegalArgumetException.
 * 
 * Create a getter to return the private integer attribute value.
 * 
 * Define a public method that is called isPrime() that returns a boolean and
 * implements the Sieve of Eratosthenes method.
 * 
 * Define a public method that is called numberOfPrimes() that returns the
 * number of prime numbers between 2 and the private attribute value.
 * 
 * Demonstrate this object in a main method that allows the user to interact
 * with all the public methods of your class.
 */

public class MyNumber {

    public static void main(String[] args) {

        /* small test */
        int[] primes = sieve(1, 100);
        for (int i : primes) {
            System.out.println(i);
        }
    }

    private static int[] sieve(int start, int end) {

        /* some basic range checks */
        if (start < 1 || end < start || start == end) {
            throw new IllegalArgumentException("Please enter a number greater than 1");
        }

        /* generate ints within range */
        int[] primes = new int[end - start + 1];
        for (int j = 0; j < end - start + 1; j++) {
            primes[j] = start + j;
        }

        /*
         * init running prime to start, and increment until running prime squared is
         * greater than the end
         */
        for (int runningPrime = (start == 1 ? 2 : start); end > Math.pow(runningPrime, 2); runningPrime++) {
            for (int i = runningPrime; i < primes.length; i++) {
                if (-1 != primes[i]) {
                    if (primes[i] % runningPrime == 0) {
                        primes[i] = -1;
                    }
                }
            }
        }

        /* handling that twat */
        if (primes[0] == 1) {
            primes[0] = -1;
        }

        /* list primes */
        List list = new ArrayList();
        for (int i = 0; i < primes.length; i++) {
            if (-1 != primes[i])
                list.add(primes[i]);
        }

        /* create the return int array */
        int[] primesFound = new int[list.size()];
        int k = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            // Integer i = (Integer) iterator.next();
            // primesFound[k] = i.intValue();
            // k++;
            primesFound[k++] = ((Integer) iterator.next()).intValue();
        }

        return primesFound;
    }
}