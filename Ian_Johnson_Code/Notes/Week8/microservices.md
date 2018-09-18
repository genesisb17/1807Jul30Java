# Microservices

A service-oriented architecture (SOA) consists of loosely coupled, reusable,
cohesive, interdependent components ("black boxes"). The client connects to
an ecosystem of these smaller services. Microservices are the natural
evolution of SOA. For example, in SOA, you might have one service that takes
care of several different operations, but in microservices, one service
should handle _one_ function. Thus, microservices are more finely grained
than traditional services, making them more reusable as a consequence.

It is much easier to manage very large projects if they are broken up into
small pieces like microservices, where a single small team can handle the
development of one microservices. Microservices should be as independent as
possible, to improve maintainability, addressing just one piece of business
functionality.

Netflix is one of the leaders in microservices today. Just loading the
Netflix homepage can contact between 1000 and 4000 microservices! This
includes things like loading movie/TV show titles, descriptions,
recommendations, viewing history, authentication/authorization, etc.; each of
these would be a separate microservice.

Since microservices are independent, they can be independently scaled; for
example, Netflix might allocate many more resources to its playback service
than the description service. Microservices can also be _replicated_, so that
we can employ load balancing to scale them.

Typically, each microservice that needs to store persistent data will have
its own database; this is the database-per-service design pattern. It is
possible to use one database for several services, but this has several
significant drawbacks.

Zuul and Eureka are open-source products from Netflix that provide an API
gateway and service discovery, respectively.

## Zuul: API gateway

All the microservices in an application are accessed through a single
service, the _gateway service_. The gateway routes the requests to the
correct microservice, reducing the burden of complexity on the client. In
short, Zuul handles _routing_ on the back-end (sort of like a front
controller).

## Inter-service communication

Inter-service communication can be achieved in two ways:

1. REST: this is challenging because HTTP can be unreliable. HTTP does not
   provide any checking to ensure that all packets have been transmitted
   correctly. This is why some companies still use SOAP, because of its support
   for _reliable messaging_.
2. Message queues: for example, JMS (Java Messaging Service), Kafka, Active
   MQ, Rabbit MQ, Amazon SNS/SQS. Message queues can either be
   _point-to-point_, where one service sends a message directly to another,
   or _publish/subscribe_, which implements the _publisher/subscriber_ design
   pattern. In this latter pattern, a service sends a message (containing a
   _payload_ and a _topic_, in Kafka terms) to a queue. The topic might be
   something like `customer.new`, to indicate what the message is for.
   Multiple services may subscribe to a topic to receive the corresponding
   messages. This makes the services even more loosely coupled, since the
   publisher doesn't need to know about every subscriber.

Microservice databases follow _eventual consistency_; the current state of
all microservice databases may not be consistent until certain events are
handled. Message queues write their messages to disk, so that when a
microservice goes down, it can retrieve the message when it comes back up.
The message queue will continually try to contact subscribers if messages are
not confirmed to be received.

## Eureka: service discovery

Service URLs and ports may change over time, for example if a service goes
down and needs to be restarted elsewhere. To solve the problem of allowing
services to find each other, we use a service discovery tool such as
_Eureka_. Microservices register themselves with Eureka so that other
microservices can find them.

## Using microservices with Spring

For our gateway service, we just need to include a Spring web Zuul dependency
in our POM and then annotate our main class with `@EnableZuulProxy`. Then, we
configure the routes in our `application.properties` or `appliction.yml`.

For our discovery service, we use the `@EnableEurekaServer` annotation on our
main class and then configure our port in `application.yml` (preferably
8761). We also need to use the `@EnableDiscoveryClient` annotation on all our
other services (including the gateway service) to register the service with
Eureka.

In any of our controller classes, we can autowire a `EurekaClient`, allowing
us to use methods like
`eurekaClient.getApplication("maps-service").getInstances().get(0).getHostName()`
or `.getPort()` to get information about our services. But this isn't
scalable, because we might have replicated services! So instead, we use the
`@EnableFeignClients` annotation on our main class to use a `FeignClient` to
contact the other microservices. Then, we simply make an interface with the
`@FeignClient` annotation with the REST methods we want to be able to use.
This is called a "declarative REST client", and should be preferred to the
manual way of using a `EurekaClient`.

## Centralized configuration (Spring Cloud Config)

We can centralize/externalize our `application.yml` config files in the cloud
to make them more maintainable.
