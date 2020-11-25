```
Spark SQL
```
```
启动客户端
[hadoop@hadoop bin]$ ./spark-shell -jar /home/hadoop/app/hive-1.1.0-cdh5.7.0/lib/mysql-connector-java-5.1.49.jar 

scala> spark.sql("show databases").show();
+------------+
|databaseName|
+------------+
|     default|
|   hive_test|
+------------+

```
```
[hadoop@hadoop bin]$ ./spark-sql --jars /home/hadoop/app/hive-1.1.0-cdh5.7.0/lib/mysql-connector-java-5.1.49.jar --driver-class-path /home/hadoop/app/hive-1.1.0-cdh5.7.0/lib/mysql-connector-java-5.1.49.jar 

spark-sql> show databases;
```
```
[hadoop@hadoop sbin]$ ./start-thriftserver.sh --jars /home/hadoop/app/hive-1.1.0-cdh5.7.0/lib/mysql-connector-java-5.1.49.jar 
starting org.apache.spark.sql.hive.thriftserver.HiveThriftServer2, logging to /home/hadoop/app/spark-bin-2.6.0-cdh5.7.0/logs/spark-hadoop-org.apache.spark.sql.hive.thriftserver.HiveThriftServer2-1-hadoop.out

```
```
[hadoop@hadoop bin]$ ./beeline -u jdbc:hive2://localhost:10000 - hadoop
Connecting to jdbc:hive2://localhost:10000
20/11/25 15:19:01 INFO jdbc.Utils: Supplied authorities: localhost:10000
20/11/25 15:19:01 INFO jdbc.Utils: Resolved authority: localhost:10000
20/11/25 15:19:01 INFO jdbc.HiveConnection: Will try to open client transport with JDBC Uri: jdbc:hive2://localhost:10000
Connected to: Spark SQL (version 2.4.5)
Driver: Hive JDBC (version 1.2.1.spark2)
Transaction isolation: TRANSACTION_REPEATABLE_READ
Beeline version 1.2.1.spark2 by Apache Hive
0: jdbc:hive2://localhost:10000> 


0: jdbc:hive2://localhost:10000> show databases;
+---------------+--+
| databaseName  |
+---------------+--+
| default       |
| hive_test     |
+---------------+--+
2 rows selected (0.049 seconds)

```