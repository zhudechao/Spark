package com.xzdream.spark.sparkSession

import org.apache.spark.sql.SparkSession

object SparkSessionApp {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("SparkSessionApp")
      .getOrCreate()

    sparkSession.stop()
  }
}
