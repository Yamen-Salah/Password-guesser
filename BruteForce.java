import java.util.function.Function;

/**
 * Convenience class for various brute force techniques.
 */
public class BruteForce {
    /**
     * Tries out each password in a given array
     * @param passwords Passwords to try out
     * @param passwordAttempter Callback method to try out each password
     */
    static String simpleDictAtk(String[] passwords, Function<String, Boolean> passwordAttempter, int start, int end) {
        // TODO: Put this in a for loop to try each element of the array.
        for (int i = start; i < end; i++) {
            
            boolean success = passwordAttempter.apply(passwords[i]);
            if (success) {
                System.out.println("Woohoo! Password is:\n");
                return passwords[i];
            }
            
        }
        return null;
        
    }

    
    /**
     * Generates and tries out strings of specified length using specified characters, attaching specified prefix to the front. 
     * @param chars
     * @param prefix String to be attached to front of each newly-generated string
     * @param length Length each string to generate, not counting the prefix's length
     * @param passwordAttempter Callback method to try out each newly generate password
     */
    static String charCombos(char[] characters, String prefix, int length, Function<String, Boolean> passwordAttempter) {
        //TODO: Use for loop and recurse with length - 1!
        return null;
    }

    /**
     * Similar to allCharacterCombinations, but combines words
     * @param words
     * @param prefix
     * @param maxLength
     * @param passwordAttempter
     */
    static void wordCombos(String[] words, String prefix, int maxLength, Function<String, Boolean> passwordAttempter) {
        
    }

    /**
     * Tries each word, but where appropriate substitutes characters with common subsitutes (eg, 'e' with '3', '1' with '!', '5' with 's')
     * @param words
     * @param passwordAttempter
     */
    static void wordsWithSubs(String[] words, Function<String, Boolean> passwordAttempter) {
        
    }
}
