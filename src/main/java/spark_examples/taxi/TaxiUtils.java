package spark_examples.taxi;

import scala.Tuple2;

/**
 * @author Evgeny Borisov
 */
public class TaxiUtils {
    public static TaxiTrip convertFromLine(String line) {
        String[] arr = line.split(" ");
        return TaxiTrip.builder().id(arr[0]).city(arr[1].toLowerCase()).km(Integer.parseInt(arr[2])).build();
    }

    public static Tuple2<String, String> convertFromLineToTuple(String line) {
        String[] arr = line.split(", ");
        return Tuple2.apply(arr[0], arr[1]);
    }
}
