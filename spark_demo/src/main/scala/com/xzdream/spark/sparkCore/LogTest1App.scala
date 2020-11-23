package com.xzdream.spark.sparkCore

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 取国家前2
 */
object LogTest1App {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("LogTest1App").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("file:///Users/zhudechao/githup/Spark/spark_demo/input")
    lines.map(x=>{
      val splits = x.split("\t")
      val country = splits(2)

      (country,1)
    }).reduceByKey(_+_).sortBy(_._2,false).take(2).foreach(println)
  }
}
