package spark_examples.taxi;

import org.apache.spark.Accumulator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TaxiService {
    public static void main(String[] args) throws InterruptedException {
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("taxi");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rawDataRdd = sc.textFile("data/taxi_orders.txt");
        JavaRDD<TaxiTrip> taxiTripRdd = rawDataRdd.map(TaxiUtils::convertFromLine);
        taxiTripRdd.persist(StorageLevel.MEMORY_AND_DISK());

        long count = taxiTripRdd.count();
        System.out.println("count = " + count);

        Accumulator<Integer> smallTripsAcc = sc.accumulator(0, "smallTripsAcc");

        taxiTripRdd.foreach(taxiTrip ->{
            if (taxiTrip.getKm() < 5) {
               smallTripsAcc.add(1);
            }
        } );

        System.out.println("smallTripsAcc = " + smallTripsAcc.value());

        JavaRDD<TaxiTrip> bostonTripsRdd = taxiTripRdd.filter(taxiTrip -> taxiTrip.getCity().equals("boston"));

        bostonTripsRdd.persist(StorageLevel.MEMORY_AND_DISK());

        System.out.println("amountOfTripsToBoston = " + bostonTripsRdd.count());

        Double totalKmToBoston = bostonTripsRdd.mapToDouble(TaxiTrip::getKm).sum();
        System.out.println("totalKmToBoston = " + totalKmToBoston);


        JavaRDD<String> driversRawDataRdd = sc.textFile("data/drivers.txt");
        JavaPairRDD<String, String> driversRdd = driversRawDataRdd.mapToPair(TaxiUtils::convertFromLineToTuple);


        List<Tuple2<String, Integer>> list = taxiTripRdd.mapToPair(taxiTrip -> Tuple2.apply(taxiTrip.getId(), taxiTrip.getKm()))
                .reduceByKey(Integer::sum)
                .join(driversRdd)
                .mapToPair(Tuple2::_2)
                .sortByKey(false)
                .mapToPair(Tuple2::swap)
                .take(3);

        System.out.println("list = " + list);

       Thread.sleep(1000_0000);

        //(id,(totalKm,name))

                //(totalKm,name)











        //todo
       //Count number of lines
       //Count amount of trips to Boston longer than 10 km
       //Calculate sum of all kilometers trips to Boston
       //Write names of 3 drivers with max total kilometers in this day(sort top to down)

    }
}
