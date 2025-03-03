import java.util.function.Function;
import java.util.concurrent.atomic.AtomicInteger;

public class BruteForce {
    /**
     * Tries out each password in a given array (dictionary attack)
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
     * Recursively generates and tries all possible 6-character passwords using multi-threading.
     */
    static String charCombos(char[] characters, String prefix, int length, 
                             Function<String, Boolean> passwordAttempter, AtomicInteger attempts, 
                             long startTime) {
        if (prefix.length() == length) {
            int attemptCount = attempts.incrementAndGet();
            boolean result = passwordAttempter.apply(prefix);

            // Print progress every 1000 attempts
            if (attemptCount % 1000 == 0) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                double progress = (100.0 * attemptCount) / 19_770_609_664L;
                System.out.printf("Attempts: %d / 19,770,609,664 (%.6f%%) | Time elapsed: %.2f seconds%n",
                        attemptCount, progress, elapsedTime / 1000.0);
            }

            return result ? prefix : null;
        }

        for (char c : characters) {
            String found = charCombos(characters, prefix + c, length, passwordAttempter, attempts, startTime);
            if (found != null) return found; // Stop recursion if password is found
        }
        return null;
    }
}
