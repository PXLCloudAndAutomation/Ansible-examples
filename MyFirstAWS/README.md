# My first AWS steps with Ansible
Playbook to create an initial test VPC and deploy a basic AMI using Ansible

# Installation
Pre-suppositions: You have an Amazon Web Services account with a valid payment method configured, and you have your AWS Access Key and AWS Secret Key from your account. Additionally, you have `boto` and Ansible installed on your workstation (install `boto` with `pip install boto`).


Make sure to have your AWS credentials in your env:

1. Set your AWS Access Key: `export AWS_ACCESS_KEY_ID=[access key here]`
2. Set your AWS Secret Key: `export AWS_SECRET_ACCESS_KEY=[secret key here]`

# Configuration

You should edit the variables.yml file in order to set the variables that don't usually change in order to simplify playbook file

_**For vpc deployment:**_

* **aws_region:** the region you want to deploy the instance in, default set to "eu-central-1" (Frankfurt)
* **vpc_name:** the name of the vpc you want to create, default set to "demo_vpc"
* **vpc_cidr_block:** The ip range you want tou use in the VPC you are creating, default set to "10.10.0.0/16"
* **my_ip_range:** the ip range you want to use in the cidr block , default set to "0.0.0.0/0"
* **public_subnet_1_cidr:** the part of the cidr you want to set public in the vpc you are creating, default set to "10.10.10.0/24"

 * **

_**For EC2 deployment:**_
 * **ec2_region:** the region you want to deploy the instance in, default set to "eu-central-1" (Frankfurt)
 * **ec2_instance_type:** the instance type to deploy, default set to "t2.micro"
 * **ec2_image:** the base image to deploy from, default set to "ami-0bdf93799014acdc4" (Ubuntu 18.04 LTS)
 * **ec2_keypair:** the SSH keypair to add to the default system account, default set to "deploykey". Make sure this keypair is available in AWS!
 * **ec2_volume_size:** the default volume size, default set to 30 gb
 * **ec2_count:** the amount of instances you want to deploy, default set to 1
 * **ec2_security_group_id:** the security group ID, this value needs to be added manually **after** running the vpc playbook.
 * **ec2_subnet_id:** the subnet ID, this value needs to be added manually **after** running the vpc playbook.
 * **ec2_tag_Type:** the tag type, default set to "t2.micro"
 * **ec2_tag_Role:** the the role displayed in the tag, default set to "demo_machines"

# Execution

* Provision the VPC in aws we want to work in
```
    ansible-playbook vpc_prov_playbook.yml
```
* Provision an ec2 instance and spins it up
```
    ansible-playbook ec2_prov_playbook.yml
```
* Terminates the ec2 instance we just created
```
ansible-playbook ec2_ter_playbook.yml
```
