package spark_examples;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Component
public class TextReaderServiceImpl implements TextReaderService {

    @Autowired
    private JavaSparkContext sc;

    @Override
    public RDD<String> readLines(String fileName) {
        return null;
    }
}
