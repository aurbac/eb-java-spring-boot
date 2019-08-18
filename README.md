# PHP Multisite with AWS Elastic Beanstalk

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

## Install Maven

``` bash
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
```

### Configure Virtual Hosts and VPC/Subnets

* Edit the file [**.ebextensions/vhosts.config**](.ebextensions/vhosts.config) with your own domains.
* Replace values in [**.ebextensions/vpc.config**](.ebextensions/vpc.config) with the resources created by the CloudFormation template or your own vpc and subnets.

### Commit changes

``` bash
git add .
git commit -m "Changes for VPC and subnets"
```

## Initialize Elastic Beanstalk Project

``` bash
eb init
```

Select a default region: **1) us-east-1 : US East (N. Virginia)**


Enter Application Name: **eb-java-spring-boot**


Select a platform. **11) Java**


Select a platform version. **1) Java 8**


Do you wish to continue with CodeCommit? **N**


Do you want to set up SSH for your instances? **Y**


Select a keypair. **(Select your KeyPair)**


## Create your first Environment


``` bash
eb create
```

Enter Environment Name: **(default is sites-dev)**


Enter DNS CNAME prefix: **(default is sites-dev)**


Select a load balancer type: **2) application**


Wait a few minutes until your environment is deployed.