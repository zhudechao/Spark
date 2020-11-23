package com.xzdream.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkContextApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkContextApp").setMaster("local[2]")
    val sc = new SparkContext(sparkConf)

    sc.stop()
  }
}
