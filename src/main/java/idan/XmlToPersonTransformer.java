package idan;

import lab0.Person;

import java.io.File;

/**
 * @author Evgeny Borisov
 */
public class XmlToPersonTransformer implements FileToPersonTransformer {
    @Override
    public Person transform(File file) {
        // 20 lines of code here
        System.out.println("xml was parsed to Person object");
        return new Person();
    }

    @Override
    public String whatIsMyType() {
        return "xml";
    }
}
