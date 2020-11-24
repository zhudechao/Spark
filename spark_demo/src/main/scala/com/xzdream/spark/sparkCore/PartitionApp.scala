package com.xzdream.spark.sparkCore

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object PartitionApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("PartitionApp").setMaster("local[2]")

    val sparkContext = new SparkContext(sparkConf)
    val words = sparkContext.parallelize(List("a","b","c"))
    words.coalesce(2).mapPartitionsWithIndex((index,partition) => {
      val word = new ListBuffer[String]
      while (partition.hasNext){
        word += (partition.next()+" 哪个组："+(index + 1))
      }
      word.iterator
    }).foreach(println)

    sparkContext.stop()
  }
}
