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
        for (int i = start; i < end; i++) {
            if (passwordAttempter.apply(passwords[i])) {
                System.out.println("Woohoo! Password is: " + passwords[i]);
                return passwords[i];
            }
        }
        return null;
    }

    /**
     * Generates and tries out strings of specified length using specified characters, attaching specified prefix to the front. 
     */
    static String charCombos(char[] characters, String prefix, int length, Function<String, Boolean> passwordAttempter) {
        return null;
    }

    /**
     * Similar to allCharacterCombinations, but combines words
     */
    static void wordCombos(String[] words, String prefix, int maxLength, Function<String, Boolean> passwordAttempter) {
    }

    /**
     * Tries each word, but where appropriate substitutes characters with common subsitutes (eg, 'e' with '3', '1' with '!', '5' with 's')
     */
    static void wordsWithSubs(String[] words, Function<String, Boolean> passwordAttempter) {
    }
}
