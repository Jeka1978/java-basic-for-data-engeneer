package idan;

import java.io.File;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        TextFileTransformer transformer = new TextFileTransformer();
        router.addFileToPersonTransofermer(transformer.whatIsMyType(), transformer);


        File file = new File("abc.txt");
        System.out.println(file.getName());

        router.handleFile(file);

    }
}
