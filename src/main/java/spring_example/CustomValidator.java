package spring_example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Evgeny Borisov
 */
public class CustomValidator implements Validator {
    @Override
    public void printValidation(String email)  {
        try {
            new FileInputStream(new File(""));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
