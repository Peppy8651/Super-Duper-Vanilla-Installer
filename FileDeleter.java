import java.io.File;
import java.io.IOException;

public class FileDeleter {
    public boolean deleteFolder(File file) throws IOException {
        boolean success;
        if (file.isDirectory()) {
            File[] folder = file.listFiles();
            for (File subFile : folder) {
                if (subFile.isDirectory()) {
                    deleteFolder(subFile);
                }
                else {
                    subFile.delete();
                }
            }
            success = file.delete();
        }
        else {
            success = false;
            throw new Error("File is not a directory. Please actually use a directory.");
        }
        return success;
    }
}    