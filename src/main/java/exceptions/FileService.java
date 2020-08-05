package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Evgeny Borisov
 */
public class FileService {
    public void handleFile(File file) throws FileNotFoundException {
        System.out.println(123);
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println(456);
    }
}
