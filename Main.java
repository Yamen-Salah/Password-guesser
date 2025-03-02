import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.concurrent.ExecutorService;

class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String sevenZexe = "./bin/7zr_win.exe"; // Change this if using Linux or Mac.
        String secretFile = "secrets/1.7z"; // Secret file to extract using password.
        AtomicBoolean found = new AtomicBoolean(false); // Shared flag to stop all threads once password is found
        Function<String, Boolean> callback = password -> {
            if (found.get()) return true; // Stop if already found
            boolean result = usePassword(sevenZexe, secretFile, password);
            if (result) found.set(true); // Mark as found
            return result;
        };

        String[] commonPasswords = Utils.readStrings("dictionaries/10-million-password-list-top-1000000.txt");
        char[] allowedCharacters = {'a', 'b', 'c'};
        
        ExecutorService executor = Executors.newFixedThreadPool(8); // Reduced to 8 threads
        int chunkSize = commonPasswords.length / 8; // Split into 8 chunks

        for (int i = 0; i < 8; i++) {
            int start = i * chunkSize;
            int end = (i == 7) ? commonPasswords.length : (i + 1) * chunkSize;
            executor.submit(() -> {
                if (!found.get() && BruteForce.simpleDictAtk(commonPasswords, callback, start, end) != null) {
                    found.set(true);
                    executor.shutdownNow();
                }
            });
        }
        
        executor.awaitTermination(3, java.util.concurrent.TimeUnit.DAYS);
    }

    static Boolean usePassword(String commandExe, String filename, String password) {
        try {
            Process command = new ProcessBuilder(commandExe, "e", filename, "-y", "-p" + password).start();
            int exitCode = command.waitFor();
            if (exitCode == 0) {
                System.out.println("Success! Password: " + password);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
