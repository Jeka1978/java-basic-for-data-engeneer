package idan;

import lab0.Person;

import java.io.File;

/**
 * @author Evgeny Borisov
 */
public class JsonFileToPersonTransformer implements FileToPersonTransformer {
    @Override
    public Person transform(File file) {
        System.out.println("handling json file!!!!!!!!!!!");
        return new Person();
    }

    @Override
    public String whatIsMyType() {
        return "null";
    }
}
