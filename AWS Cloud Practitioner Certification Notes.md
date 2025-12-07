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

