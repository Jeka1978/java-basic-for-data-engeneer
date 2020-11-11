package spark_examples.dataframes_examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import spark_examples.songs.WordsUtil;

/**
 * @author Evgeny Borisov
 */
public class MorDfExamples {


    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("linkedIn").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);

        JavaRDD<Row> rdd = sc.textFile("data/songs/metallica.txt")
                .flatMap(WordsUtil::getWords)
                .map(word -> RowFactory.create(word, word.length()));


        StructType schema = DataTypes.createStructType(
                new StructField[]{
                        DataTypes.createStructField("word", DataTypes.StringType, true),
                        DataTypes.createStructField("size", DataTypes.IntegerType, true)
                }

        );

        sqlContext.createDataFrame(rdd, schema).show();


    }

}
