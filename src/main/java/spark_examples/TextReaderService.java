package spark_examples;

import org.apache.spark.rdd.RDD;

/**
 * @author Evgeny Borisov
 */
public interface TextReaderService {
    RDD<String> readLines(String fileName);
}
