package com.xzdream.spark.sparkSql

import org.apache.spark.sql.SparkSession

object DataFrameApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[2]")
      .appName("DataFrameApp")
      .getOrCreate()

    import spark.implicits._

    val df = spark.read.text()
    df.select($"name")

    spark.stop()
  }
}
