package com.interview.wirtecode

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("wordcout").setMaster("local[*]")

    val spark = new SparkContext(conf)

    val lineRDD: RDD[String] = spark.textFile("./data/word.txt")

    val word2CountRRDD: RDD[(String, Int)] = lineRDD.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)

    word2CountRRDD.collect().foreach(println)

    spark.stop();

  }
}
