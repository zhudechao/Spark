package com.xzdream.spark.sparkCore

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object MapPartitionApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("MapPartitionApp").setMaster("local[2]")

    val sparkContext = new SparkContext(sparkConf)

    val words = new ListBuffer[String]

    for(i <- 1 to 100){
      words += "xzdream"+i;
    }

    val rdd = sparkContext.parallelize(words)

    rdd.map(x=>{
      val conn = DB.getConn()
    }).foreach(println)

    sparkContext.stop()
  }
}

object DB{
  def getConn() = {

  }
}
