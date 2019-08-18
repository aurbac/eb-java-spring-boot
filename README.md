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


Select an application to use: **1) sites**


It appears you are using PHP. Is this correct? **Y**


Select a platform version. **3) PHP 7.0**


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