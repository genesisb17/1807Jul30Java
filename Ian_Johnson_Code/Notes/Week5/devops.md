# Devops

Devops is the process of automating and testing deployment.

## IT Infrastructure

Your infrastructure is everything you need to get up and running with a
production application. In IT, you need hardware, software and a network:

- Hardware
  - Servers
  - Computers
  - Switches, hubs and routers
- Software
  - ERP, CRM, office productivity, etc.
- Network
  - Network enablement
  - Internet connectivity

### Cloud computing

Rather than maintain all that infrastructure ourselves, we can access other
people's infrastructure over the Internet. Using cloud computing, we don't
store anything locally, only an interface to access resources.

#### Infrastructure-as-a-Service (IaaS)

A third-party provider hosts hardware, software, storage and other
infrastructure components. IaaS providers handle system maintenance, backup
and resiliency planning. IaaS provides highly scalable resources that can be
adjusted on-demand.

IaaS customers pay on a per-use basis, typically by hour, week, month or
virtual machine space. This avoids the up-front capital of building in-house.

#### Platform-as-a-Service (PaaS)

With PaaS, a cloud provider delivers hardware and software tools, usually
those needed for application development. The provider hosts the hardware and
software on its own infrastructure. Customers can develop or run a new
application off-site.

PaaS includes hardware, operating systems and middleware (databases, web
servers, etc.).

#### Software-as-a-Service (SaaS)

SaaS is a software distribution model where applications are hosted by a
vendor or service provider and made available to customers over a network,
typically the Internet.

## AWS

AWS is a broad set of computing resources hosted by Amazon:

- EC2 (Elastic Compute Cloud): provides resizeable computing capacity in the
  cloud
- EBS (Elastic Block Store): provides SSD volumes for use with EC2
- Auto-scaling: scales EC2 capacity up or down automatically
- Elastic Load Balancing: distributes incoming traffic across multiple EC2
  instances
- RDS (Relational Database Service): sets up, operates and scales a
  relational database
- S3 (Simple Storage Service): provides object storage repositories up to
  5000+ TB
- Route 53: provides a cloud Domain Name System (DNS) web service
- And many more!

### AWS global infrastructure

AWS cloud infrastructure is built around Regions and Availability Zones
(AZs). A Region is a physical location with multiple AZs. AZs consist of one
or more discrete data centers housed in separate facilities.

### EC2

Elastic Compute Cloud is how you create a virtual machine in the cloud. You
pay only for what you use.

To set up an instance, you need to select an AMI (Amazon Machine Image) to
load up an OS. Then, you attach an EC2 instance to EBS for hard drive space,
and can connect to Linux via SSH or to Windows via RDP.

### EBS

Elastic Block Store provides persistent block-level storage volumes for EC2.
It uses encryption for secure transfer between EC2 and EBS. EBSs are
automatically replicated within their AZs, to protect from component failure
and provide high availability and durability. They also offer consistent and
low-latency performance, striping multiple volumes for higher I/O
performance.

You can back up your data by taking point-in-time snapshots, and scale your
application up and down easily.

### Auto-scaling

Auto-scaling ensures that you have enough EC2 instances to handle application
load. You create collections of EC2 instances, called _auto-scaling groups_.
You can specify scaling policies, and auto-scaling can launch or terminate
instances depending on the demand on your application.
