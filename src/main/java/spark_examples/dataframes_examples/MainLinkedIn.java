package spark_examples.dataframes_examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;

import static org.apache.spark.sql.functions.*;

/**
 * @author Evgeny Borisov
 */
public class MainLinkedIn {
    private static final String SALARY = "salary";
    private static final String BIRTHDAY = "birthday";
    private static final String AGE = "age";
    private static final String KEYWORDS = "keywords";
    private static final String KEYWORD = "keyword";

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("linkedIn").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*");

        sqlContext.udf().register(BirthdayCalculatorUdf.class.getName(),new BirthdayCalculatorUdf(), DataTypes.StringType);
        dataFrame.persist();
        dataFrame.show();
        dataFrame.printSchema();
        StructField[] fields = dataFrame.schema().fields();
        for (StructField field : fields) {
            System.out.println(field.dataType().typeName());
            System.out.println(field.nullable());
        }
        dataFrame.withColumn(BIRTHDAY, callUDF(BirthdayCalculatorUdf.class.getName(), col(AGE))).show();
        DataFrame salaryDF = dataFrame.withColumn(SALARY, col(AGE).multiply(10).multiply(size(col(KEYWORDS))));
        dataFrame.persist();
        salaryDF.show();

        System.out.println("*************");
        dataFrame.withColumn(KEYWORD,explode(col(KEYWORDS))).select(KEYWORD).show();
        System.out.println("*************");

        DataFrame keywordDF = dataFrame.select(explode(col(KEYWORDS)).as(KEYWORD));


        Row row = keywordDF.groupBy(col(KEYWORD)).agg(count(KEYWORD).as("AMOUNT"))
                .sort(col("AMOUNT").desc()).head();

        String mostPopular = row.getAs(KEYWORD);

        salaryDF.filter(array_contains(col(KEYWORDS),mostPopular))
                .filter(col(SALARY).leq(2000))
                .show();

//        dataFrame.where("age<40").show();
//        dataFrame.show();
    }
}







