package idan;

import lab0.Person;

import java.io.File;

/**
 * @author Evgeny Borisov
 */
public interface FileToPersonTransformer {
    Person transform(File file);
    String whatIsMyType();
}
