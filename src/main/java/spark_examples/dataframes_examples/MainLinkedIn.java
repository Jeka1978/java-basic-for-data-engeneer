package spark_examples.dataframes_examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;

import static org.apache.spark.sql.functions.col;

/**
 * @author Evgeny Borisov
 */
public class MainLinkedIn {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("linkedIn").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*");
        dataFrame.where(col("age").leq(40))
                .withColumn("age*2", col("age").plus(2).multiply(2)).show();

//        dataFrame.where("age<40").show();
//        dataFrame.show();
    }
}
