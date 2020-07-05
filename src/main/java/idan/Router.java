package idan;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Router {

    private Map<String, FileToPersonTransformer> map = new HashMap<>();




    public Router() {
        System.out.println("router was created!");
        map.put("xml", new XmlToPersonTransformer());
        map.put("json", new JsonFileToPersonTransformer());
    }

    public void addFileToPersonTransofermer(String extName,FileToPersonTransformer transformer) {
        map.put(extName, transformer);
    }

    public void handleFile(File file) {
        // pink floyd.txt
        String name = file.getName();
        String[] array = name.split("\\.");
        FileToPersonTransformer transformer = map.get(array[1]);
        transformer.transform(file);

    }
}
