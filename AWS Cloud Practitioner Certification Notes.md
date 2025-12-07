Sources: aws docs, stephane maarek Udemy, chatgpt.

- Iaas: amazon ec2 
- Paas: elastic beanstalk 
- Saas: AWS recognition or Google workspace etc 
- Faas function as a service: lambda 

## 3 pricing fundamentals 
1. Computer: pay for compute time 
2. Storage: pay for exact storage 
3. Data transferred in and out 
	1. Data in is free 
	2. Data out is charged. 

# global AWS services: (they run globally regardless of user location)
- identity and access management (IAM)
- Route 53 (DNS service)
- Cloud front (CDN)
- WAF web application firewall 

## Shared responsibility Model diagram 
1. Customer is responsible for security **IN** the cloud 
2. AWS is responsible for security **OF** the cloud


# Real-World Example (Website Architecture) for diff betn edge, region and AZ 

Let’s say you host a global website:
	Region: us-east-1

Your EC2, RDS, S3 live here

Availability Zones: us-east-1a + us-east-1b

Your web servers are split across both for high availability

Edge Locations: worldwide

CloudFront caches images and videos near users in Asia, Europe, etc.

Result:
If one AZ fails → your app stays online
If users are far from the Region → Edge Locations reduce load time
If the entire Region fails → separate disaster recovery Region is needed

# IAM: identity and access management (global service)
- root account during signup... Part of iam 
- users can be created by iam 
- since iam is a global service, you cannot select a particular region in the console... It's global
- users can be grouped together using iam for eg 3 users in dev group and 2 in operations group.
- a user can belong to multiple groups for eg PM can belong to all groups 
- Users or groups can be assigned json documents called policies 
- don't allow everyone to do everything
	- in AWS we use **least privilege principle**

## after user is created 
- user can create an alias name so that the login link for the user is simplified. 
- when AWS signin page (fresh incognito page) then 2 options are present of root user and iam user. 
	- if iam selected: put your account id(or alias name), iam user name and password. 
- **never lose root account password, if lost, you'll have to contact AWS support**

AWS allows multiple sessions in same browser. 
	Click on account and click on add session. Now you will be at a signin page, do so. 

### IAM Policies 
- group level policy: applies to all users of the group. 
- inline policy: no group policy (only attached to a user who is in no group)
- policies are json files. 
	- policy json contains a version number "usually a date". Version number is not to depict AWS version, it's to depict policy version (for example date of when the policy was last updated etc)
	- id : identifier of policy 
	- statement: an array. One policy can have one array of statement which can have multiple statement elements. 
		- sid : statement id (optional) it's just for human understanding, this sid isn't used for security or other technical tasks. 
		- effect: whether statement allows ir denies access. Effect has only 2 values "allow" And "deny"
		- principal: which account/user/role this policy applies to 
		- action: list of api calls that are allowed or denied by this policy 
			- "s3:GetObject" → download an object
			- "s3:PutObject" → upload an object
			- "ec2:StartInstances" → start EC2
			- "iam:CreateUser" → create IAM user
			- You can also use wildcards: "Action": "s3:*" Means: all S3 actions
		- resources: list of resource to which the action is applied to. 
		- condition: conditions for when this policy is in effect (optional) 
- sample policy: 
```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "AllowReadFromMyBucket",
      "Effect": "Allow",
      "Action": [
        "s3:GetObject"
      ],
      "Resource": "arn:aws:s3:::my-company-bucket/*"
    }
  ]
} 
```

## IAM MFA 
- Password policy can be setup to protect users 
- we can define password policy (minimum chars, numbers etc...)
- allow all iam users to change their passwords 
- we can put a password expiration (change password every 90 days etc)
- prevent password reuse. 
- mfa: multifactor authentication 
- protect your root and iam accounts with mfa 
- mfa: password that you know + security device that you own. 
- it's just like rsa or Google sign-in popup 
- mfa devices:
	- virtual mfa device like Google authenticator or authy, both for phone only 
	- universal 2nd factor u2f security key: yubikey by yubico (physical pendrive like device) 
	- hardware key fob mfa device like gemalto 
	- hardware key fob mfa device for AWS govcloud (for govt): surepassID 

### 3 options to access AWS: 
1. AWS Management Console (protected by password + mfa)
2. AWS Command Line Interface CLI (Protected by access key)
3. AWS SDK protected by access key 
Access keys are generated form console 
Access keys are like passwords and not to be shared ot commited. 

Cloudshell: using this instead of cli. Its a browser based cli. 

## IAM Roles for Services 
Some AWS services will need to perform actions on our behalf. To do so, we will assign permissions to aes services with iam roles. 

Common rules are ec2 instance roles, lambda function role etc. 

## IAM security tools
1. Iam credentials report (account level): report that lists all your account's users and the status of their various credentials 
2. Iam access advisor(user level): access advisor shows the service permissions granted to a user and when those services were last accessed. 
## IAM guidelines and best practices: 
- don't use root account except for AWS account setup. 
- one physical user = one AWS user 
- assign users to groups and assign permissions to groups. 
- create strong password policy 
- use and enforce use of mfa 
- create and use roles for giving permissions to AWS services. 
- use access keys for programmatic access like cli and sdk
- audit permissions of your account using iam credential report and access advisor 
- don't share iam users and access keys 

## shared responsibility model for IAM 
- AWS responsible for infra, configuration and vulnerability analysis and compliance validation. 
- human responsible for users groups roles policies management and monitoring 
	- enable mfa on all accounts 
	- rotate all your keys often 
	- use iam tools to apply appropriate permissions
	- analyse access patterns and review permissions 


---
# EC2 elastic cloud compute 
- it's an iaas 
- consists of capabilities of:
	- renting virtual machines ec2
	- storing data on virtual drives (EBS)
	- distributing load across machines(ELB)
	- scaling the services using an auto-scaling group(ASG)
## EC2 Sizing and config. 
- OS (Linux or other)
- ram 
- cpu 
- how much storage 
- network card
- Security group. 
- bootstrap script  (ec2 user data script)
	- the above script file runs at start of the instance and does the following 
		- installing updates .installing softwares 
		- downloading common files from the internet. 
		- other such tasks. 
	- EC2 User data script runs with the root user. 

**When we run a ec2 instance from public ip, it will run only on http and not on https. When we stop the instance and start again, public IP will be changed but private IP will remain same.**

T2.micro and amazon linux is a common ec2 instance for free tier. Good for learning. 

## 7 types of ec2 instances 
1. General purpose: good balance betn compute, memory and networking 
2. Compute optimised: good for high processing task like bash processing or media transcoding or ML or scientific modelling. Names start from c like c5a etc 
3. Memory optimised: fast for workload that process large data sets in memory. Eg relational or nosql database, in memory database for business intelligence, app performing real time processing of big unstructured data. Name starts with R or X. Names keep changing, they aren't static. 
4. Accelerated computing
5. Storage optimised : good for storage intensive tasks that require high sequential read and write operations. Eg high frequency online transaction processing (OLTP) or cache for in memory database or data warehouse apps, or distributed file systems. 
6. Instance features 
7. Measuring instance performance 

## naming convention of instances 
M5.2xlarge 
M means instance class 
5 is generation number 
2xlarge is size within instance class 

---
# Security Groups 
- they are fundamental of network security in AWS 
- they control how traffic is allowed into or out of our ec2 instances. 
- security group only contain allow rules. Sg rules can be referenced by IP or by security group. 
- **security group acts as firewall on ec2 instances.**
- sg regulate: 
	- access to ports 
	- authorised ip ranges : ipv4 and ipv6
	- control of inbound network (from other to the instance)
	- control of outbound network (from instance to other)
- one instance can have multiple security groups, and vice versa(one security group can be applied to multiple instances)
- security group are locked down to a region. Meaning of we switch region, we need to create new security group. 
- security group is an entity running around (outside) the ec2. It's not part of ec2, it's a firewall protecting the ec2 form outside. 
- **good practice: maintain a separate security group for SSH access**
- ***if your app is not accessible (timeout), then it's a security group issue. On the contrary if app gives a "connection refused" error then it's an application error or its not launched.***
- by default, all inbound traffic is blocked and all outbound traffic is authorised. 

---
# connecting to instance form cli (either ssh or putty or instance connect)
Ports to know:  (we can define these in security group details)
- 22: ssh - log into a linux instance. 
- 21:ftp - upload files into a file share 
- 22: secure ftp - upload files using ssh 
- 80: http 
- 443: https 
- 3389: remote desktop protocol RDP - log into a windows instance

If ssh has problem then there's othe way to connect to the instance which is called ec2 instance connect. 

For below windows 10, use putty to connect, for Linux, mac and other windows 11 etc, use ssh. For all use EC2 instance connect. 

Ssh allows us to control remote machine using only cli

We provide credentials to ec2 instances only via iam roles... **At all cost avoid giving credentials to the ec2 instance from instance connect cli. Credentials meaning access key id, secret access key etc...**

---
# EC2 Instances Purchasing Options 
## On demand instances 
- short workload, predictable pricing, pay by second 
- linux or windows: billing per second, after first minute
- other os: billing per hour 
- highest cost but no upfront payment 
- no long term commitment 
## Reserved (1 and 3 years)
### Reserved Instances : long work loads 
- upto 72 percent discount compared to on demand 
- can reserve a specific instance attributes (instance type, region, tenancy, os)
- reservation period: 1 year or 3 year. More year = more discount 
- payment options: no upfront, partial upfront, all upfront available 
- recommended for steady state usage applications 
- buy or sell in reserved instance marketplace. 
### Convertible reserved instances: long workloads with flexible instances 
- allows to change ec2 instance type, instance family, os, scope and tenancy. 
- upto 66percent discount 

## Savings Plan (1 and 3 year)
- commitment to an amount of usage, long workload 
- get discount upto 72 percent 
- commit to a certain type of usage (10 dolar an hour for 1 or 3 years)
- usage beyond ec2 savings plan is billed at the on demand price 
- locked to a specific instance family and aws region 
- flexible across: 
	- instance size (m5xlarge or 2x large etc)
	- os 
	- tenancy (host, dedicated, default)
## Spot instances
- short workloads, cheap, can lose instances (less reliable)
- discount upto 90 percent 
- instances that you can kise at any point of time if your max peice is less than current spot price 
- most cost efficient instances in AWS 
- workloads for using soot instances are: 
	- batch jobs 
	- data analysis 
	- image processing 
	- any distributed workload 
	- workloads with a flexible start and end time 
	- any other short burst of workload where a "spot" instance will help. 
- not suitable for critical jobs or databases. 
## dedicated hosts 
- book an entire physical server, control instance placement 
- allows you address compliance requirements and use your existing server bound software licenses (per socket, per core, vm software licenses)
- purchasing option: 
	- on demand: pay per second fjr active dedicated host 
	- reserved:1 or 3 year (no, partial, akl upfront options available)
- this is the most expensive option since complete hardware all to us. 
- useful for software that have complicated licensing model (bring your own license model) or for companies that have strong regulatory or compliance needs. 
## dedicated instances 
- A dedicated instance is your own VM, but it still runs on shared physical hardware, just isolated at the hypervisor level.
- What you control
	- ✅ The entire virtual machine
	- ✅ Guaranteed vCPU and RAM allocation
	- ✅ No other customer shares your VM
- What is still shared
	- ❌ Physical CPU package
	- ❌ Memory channels
	- ❌ Cache hierarchy
	- ❌ PCIe bus
	- ❌ Network interface cards
	- ❌ Storage backplane

## Capacity Reservations 
- reserve capacity in a specific AZ for any duration 
- access to ec2 when u need it. 
- no time commitment (create or cancel any time), no billing discounts. 
- combine with regional reserved instances and savings plans to benefit from billing discount. 
- you're charged at on-demand rate whether you run instances or not. 
- suitable for short term, uninterrupted workloads that needs to be in a specific az. 

---
# shared responsibility model for ec2 
AWS responsibility: 
- infrastructure (global network security) 
- isolation on physical hosts 
- replacing faulty hardware 
- compliance validation 
User responsibility: 
- security groups rules 
- operating system patches and updates 
- software and utilities installed on ec2 instance 
- iam roles assigned to ec2 and iam user access management 
- data security on your instance. 




