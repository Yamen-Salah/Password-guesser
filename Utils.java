import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Utils {

    static int[] binarySearch(long[] array, long target)
    {
        int min = 0, max = array.length - 1;
        boolean found = false;
        int steps = 0; // Counter to track search steps
        int targetPos = -1;
        while (!found) 
        {
            targetPos = (min + max) / 2; // Calculate middle index
            
            if (array[targetPos] == target) 
            { // Check if the SIN matches
                found = true;
            } 
            else if (array[targetPos] > target) 
            { // Search in the lower half
                max = targetPos;
                steps++;
            } 
            else 
            { // Search in the upper half
                min = targetPos;
                steps++;
            }
            if (steps > 20) 
            {
                System.out.println("The SIN number was not found");
                found = false;
                break;
            }
        }
        if (found)
        {
            return new int[] {steps,targetPos};
        }
        else {return new int[] {steps,-1};} // Return -1 if the SIN number was not found
    }
    

    static long[] readLongs(String filename) throws FileNotFoundException
    {
        Scanner numberFileScanner = new Scanner(new File(filename));
        // Read the first line to get the number of entries
        int count = Integer.parseInt(numberFileScanner.nextLine());
        long [] numbers = new long[count];
        for (int i = 0; i < count; i++) 
        {
            numbers[i] = Long.parseLong(numberFileScanner.nextLine());
        }
        numberFileScanner.close();
        return numbers;
    }


    static String[] readStrings(String filename) throws FileNotFoundException
    {
        Scanner namesFilScanner = new Scanner(new File(filename));
        // Read the first line to get the number of entries
        int count = Integer.parseInt(namesFilScanner.nextLine());
        String[] names = new String[count]; // Initialize names array with the given size
        // Populate the names array by reading from the file
        for (int i = 0; i < count; i++)
        {
            names[i] = namesFilScanner.nextLine();
        }
        namesFilScanner.close();
        return names;
    }

    /**
     * Prompts user for an int between specified low (inclusive) and high (inclusive)
     * @param sc Scanner for terminal input
     * @param low Lowest allowed value
     * @param high Highest allowed value
     * @return Valid user input
     */
    static int getInt(Scanner sc, int low, int high) {
        int input;
        
        do {
            System.out.print("Please enter value between " + low + " and " + high + ": ");
            String line = sc.nextLine();
            input = Integer.parseInt(line);
        } while (input < low || input > high);

        return input;
    }

    /*
     * Wrapper for System.out.println;
     */
    static <T> void prn(T thingToPrint) {
        System.out.println(thingToPrint);
    }


    /*
     * Wrapper for System.out.print;
     */
    static <T> void prt(T thingToPrint) {
        System.out.print(thingToPrint);
    }
}