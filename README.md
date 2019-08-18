# Spring Boot application with AWS Elastic Beanstalk

## Requirements

* [AWS Command Line Interface](https://aws.amazon.com/cli/)
* [The Elastic Beanstalk Command Line Interface](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3.html)
* VPC with Public and Private subnets is required
    - You can use the following [CloudFormation Template to create your VPC-Public-And-Private](https://raw.githubusercontent.com/aurbac/msg-app-backend/master/vpc/AURBAC-VPC-Public-And-Private.json)

## Clone Github Project

``` bash
git clone https://github.com/aurbac/eb-java-spring-boot.git
cd eb-java-spring-boot
```

## Install OpenJDK 8

``` bash
sudo yum -y install java-1.8.0-openjdk-devel
```

Switch or upgrade the default Java development toolset to OpenJDK 8.

``` bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

Confirm that the command line versions of the Java runner and compiler are using OpenJDK 8.

``` bash
java -version
javac -version
```

## Install Maven

``` bash
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
```

## Build Project

``` bash
mvn package
```

## Configure VPC/Subnets

* Replace values in [**.ebextensions/vpc.config**](.ebextensions/vpc.config) with the resources created by the CloudFormation template or your own vpc and subnets.

## Commit changes

``` bash
git add .
git commit -m "Changes for VPC and subnets"
```

## Generate Artifact

``` bash
cp .ebextensions target/.ebextensions -r
cd target
zip ExampleJava-0.0.1-SNAPSHOT.zip -ur .ebextensions ExampleJava-0.0.1-SNAPSHOT.jar
cd ..
```

## Initialize Elastic Beanstalk Project

``` bash
eb init
```

Select a default region: **1) us-east-1 : US East (N. Virginia)**


Select an application to use: **1) eb-java-spring-boot**


Select a platform. **11) Java**


Select a platform version. **1) Java 8**


Do you wish to continue with CodeCommit? **N**


Do you want to set up SSH for your instances? **Y**


Select a keypair. **(Select your KeyPair)**


## Deploy configuration    

Open **.elasticbeanstalk/config.yml** file and add a **deploy** config as follows:

``` yaml
deploy:
  artifact: target/ExampleJava-0.0.1-SNAPSHOT.zip
```

## Create your first Environment


``` bash
eb create
```

Enter Environment Name: **(default is eb-java-spring-boot-dev)**


Enter DNS CNAME prefix: **(default is eb-java-spring-boot-dev)**


Select a load balancer type: **2) application**


Wait a few minutes until your environment is deployed.