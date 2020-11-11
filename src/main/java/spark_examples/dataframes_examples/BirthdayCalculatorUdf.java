package spark_examples.dataframes_examples;

import org.apache.spark.sql.api.java.UDF1;

import java.time.LocalDate;

/**
 * @author Evgeny Borisov
 */
public class BirthdayCalculatorUdf implements UDF1<Long,String> {
    @Override
    public String call(Long age) throws Exception {
        return LocalDate.now().minusYears(age).toString();
    }
}
