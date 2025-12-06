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