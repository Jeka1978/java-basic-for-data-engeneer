package spark_examples.taxi;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TaxiService {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("taxi");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rawDataRdd = sc.textFile("data/taxi_orders.txt");
        List<String> list = rawDataRdd.collect();
        list.forEach(System.out::println);

        //todo
       //Count number of lines
       //Count amount of trips to Boston longer than 10 km
       //Calculate sum of all kilometers trips to Boston
       //Write names of 3 drivers with max total kilometers in this day(sort top to down)

    }
}
