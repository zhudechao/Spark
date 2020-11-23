```
spark源码编译
```
```
源码下载
wget https://archive.apache.org/dist/spark/spark-2.4.5/spark-2.4.5.tgz
```
```
编译前置环境
Maven 3.6.*
Java 8+
Scala 2.11.8
git
```
```
安装git
yum install -y git
```
```
安装jdk
[root@hadoop001 ~]# mkdir /usr/java
 
[root@hadoop001 ~]# tar -zxvf /home/hadoop/app/jdk-8u45-linux-x64.gz -C /usr/java/
[root@hadoop001 java]# chown -R root:root jdk1.8.0_212/
[root@hadoop001 java]# chown -R root:root jdk1.8.0_212/*
 
[hadoop@hadoop001 zookeeper]$ vi ~/.bash_profile 
 
export JAVA_HOME=/usr/java/jdk1.8.0_45/
PATH=$JAVA_HOME/bin:$PATH:$HOME/bin
 
export PATH
```
```
安装maven
安装maven
[root@hadoop software]# wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
[root@hadoop001 software]# tar -zxvf apache-maven-3.6.3-bin.tar.gz -C /root/app/
 
配置环境变量
# .bash_profile
 
# Get the aliases and functions
if [ -f ~/.bashrc ]; then
     . ~/.bashrc
fi
 
# User specific environment and startup programs
 
PATH=$PATH:$HOME/bin
JAVA_HOME=/usr/java/jdk1.8.0_212
PATH=$PATH:$JAVA_HOME/bin
MAVEN_HOME=/root/app/apache-maven-3.6.3
PATH=$PATH:$MAVEN_HOME/bin
export PATH
 
 
配置maven仓库位置
[root@hadoop001 apache-maven-3.6.3]# vi /root/app/apache-maven-3.6.3/conf/settings.xml
<localRepository>/root/maven_repo</localRepository>
```
```
安装scala
[root@hadoop001 software]# wget https://downloads.lightbend.com/scala/2.11.12/scala-2.11.12.tgz
[root@hadoop001 software]# tar -zxvf scala-2.13.2.tgz -C /root/app/
 
配置环境变量
# .bash_profile
 
# Get the aliases and functions
if [ -f ~/.bashrc ]; then
     . ~/.bashrc
fi
 
# User specific environment and startup programs
 
PATH=$PATH:$HOME/bin
JAVA_HOME=/usr/java/jdk1.8.0_212
PATH=$PATH:$JAVA_HOME/bin
MAVEN_HOME=/root/app/apache-maven-3.6.3
SCALA_HOME=/root/app/scala-2.13.2
PATH=$PATH:$MAVEN_HOME/bin:$SCALA_HOME/bin
export PATH

```
```
修改编译脚本增加编译速度
VERSION=2.4.2
SPARK_HADOOP_VERSION=2.6.0-cdh5.7.0
SPARK_HIVE=1
SCALA_VERSION=2.11
```
```
进入spark源码进行编译
/root/software/spark-2.4.5/dev
[root@hadoop001 spark-2.4.5]# ./dev/make-distribution.sh \
--name 2.6.0-cdh5.7.0 \
--tgz \
-Phadoop-2.6 \
-Dhadoop.version=2.6.0-cdh5.7.0 \
-Phive \
-Phive-thriftserver \
-Pyarn \
-Pkubernetes

```

```
编译出错解决
[ERROR] Failed to execute goal on project spark-launcher_2.11: Could not resolve dependencies for project org.apache.spark:spark-launcher_2.11:jar:2.4.5: Could not find artifact org.apache.hadoop:hadoop-client:jar:2.6.0-cdh5.7.0 in gcs-maven-central-mirror (https://maven-central.storage-download.googleapis.com/repos/central/data/) -> [Help 1]

pom.xml
<!--新增一个CDH仓库-->
    <repository>
      <id>cloudera</id>
      <name>cloudera Repository</name>
      <url>https://repository.cloudera.com/artifactory/cloudera-repos/</url>
    </repository>
```