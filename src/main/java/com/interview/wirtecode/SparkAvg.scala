package com.interview.wirtecode

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkAvg {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("wordcout").setMaster("local[*]")

    val spark = new SparkContext(conf)

    val tuples = List(("a",1), ("a",3),("b",3), ("b",5), ("c",4))

    val key2countRDD: RDD[(String, Int)] = spark.makeRDD(tuples)

    val key2Tuple: RDD[(String, (Int, Int))] = key2countRDD.combineByKey(
      (_, 1),
      (t: (Int, Int), v: Int) => (t._1 + v, t._2 + 1),
      (t1: (Int, Int), t2: (Int, Int)) => (t1._1 + t2._1, t1._2 + t2._2)
    )

    val key2Avg: RDD[(String, Int)] = key2Tuple.map {
      case (key, (sum, count)) => (key, sum / count)
    }

    key2Avg.collect().foreach(println)



    spark.stop();

  }
}
