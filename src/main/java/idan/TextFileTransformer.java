package idan;

import lab0.Person;

import java.io.File;

/**
 * @author Evgeny Borisov
 */
public class TextFileTransformer implements FileToPersonTransformer {
    @Override
    public Person transform(File file) {
        System.out.println("handling TEXT file!!!!!!!!!!!");
        return null;
    }

    @Override
    public String whatIsMyType() {
        return "txt";
    }
}
