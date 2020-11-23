package com.xzdream.spark.sparkCore

import org.apache.spark.{SparkConf, SparkContext}

object LogApp {
  def main(args: Array[String]): Unit = {
    //创建SparkConf
    val sparkConf = new SparkConf()
    sparkConf.setAppName("LogApp").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)

    //读取日志文件
    val lines = sc.textFile("file:///Users/zhudechao/githup/Spark/spark_demo/input")
    var traffic = 0L
    lines.map(x=>{
      val splits = x.split("\t")
      val ip = splits(0)
      try{
        traffic = splits(1).toLong
      }catch {
        case e:Exception => 0L
      }
      (ip,traffic)
    }).reduceByKey(_+_)
      //.collect.foreach(println)

    sc.stop()
  }
}
