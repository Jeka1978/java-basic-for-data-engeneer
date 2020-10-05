package spark_examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class SparkConfig {


    @Bean
    @Profile("PROD")
    public SparkConf prodSparkConf() {
        return new SparkConf().setAppName("demo");
    }

    @Bean
    @Profile("DEV")
    public SparkConf devSparkConf() {
        return new SparkConf().setAppName("demo").setMaster("local[*]");
    }

    @Bean
    public JavaSparkContext sc(SparkConf sparkConf) {
        return new JavaSparkContext(sparkConf);
    }

}



