```
创建RDD
```
```
scala> val data = Array(1,2,3,4,5)
data: Array[Int] = Array(1, 2, 3, 4, 5)

scala> val distData = sc.parallelize(data)
distData: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:26

scala> distData.collect()
res0: Array[Int] = Array(1, 2, 3, 4, 5)
```
```
External Datasets 外部数据集

```