package taxi_scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Evgeny Borisov
 */
object TaxiMain {

  case class TaxiScalaTrip(id: String, city: String, km: Int)


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("taxi_scala").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val taxiRawDataRdd = sc.textFile("data/taxi_orders.txt")

    val taxiScalaTripRdd: RDD[TaxiScalaTrip] = taxiRawDataRdd
      .map(_.toLowerCase())
      //        .map(convertFromLine)
      //        .map(convertFromLine(_))
      //      .map(line=>convertFromLine(line))
      .map(_.split(" "))
      .map(arr => TaxiScalaTrip(arr(0), arr(1), arr(2).toInt)).persist()


    println(s"total trips: ${taxiScalaTripRdd.count()}")

    val bostonTripsRdd = taxiScalaTripRdd.filter(_.city == "boston").persist()

    println(s"total trips to boston:${bostonTripsRdd.count()}")


    println(s" total km to boston ${bostonTripsRdd.map(_.km).sum()}")

    val winners = taxiScalaTripRdd
      .map(trip => (trip.id, trip.km))
      .reduceByKey(_ + _)
      .map(_.swap)
      .sortByKey(ascending = false)
      .map(_._1)
      .take(3)
      .foreach(println)


  }
}
