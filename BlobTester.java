import java.nio.file.Files;
import java.nio.file.Path;

public class BlobTester {
    public static void main(String[] args) throws Exception {
        Path testFile = Files.createTempFile("blob-test-", ".txt");
        Files.writeString(testFile, "Blob test " + System.nanoTime());

        String hash = Git.createblob(testFile.toString());
        Path blob = Path.of("git", "objects", hash);

        if (!Files.isRegularFile(blob)) {
            throw new AssertionError("not exist");
        }
        if (Files.mismatch(testFile, blob) != -1) {
            throw new AssertionError("not match");
        }

        Files.delete(testFile);
        Files.delete(blob);
        System.out.println("PASS: blob exists, matches, and was cleaned up");
    }
}
