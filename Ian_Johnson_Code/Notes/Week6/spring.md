# Spring

Spring is an IoC (Inversion of Control) framework. IoC means that the
developer is giving control of implementation details to the framework; one
type (or "flavor") of IoC is dependency injection. In IoC, a bean is provided
its dependencies by a framework, as opposed to being explicitly instantiated
by the developer.

A _dependency_ is some object that your bean needs to use. Using dependency
injection, where the framework provides the object to your bean, is
convenient since it decouples task execution from implementation and
increases modularity.

Spring supports setter injection (which injects dependencies using setters)
and constructor injection (which does the same using a constructor). A third
type of dependency injection is interface injection, but Spring does not
support this.

## Spring basics

Spring is a Java framework based on D.I. (dependency injection). It creates
and stores objects in the _Spring container_ and injects them into registered
objects (_Spring beans_). The Spring container can be configured via
annotations, XML or a mix of both.

An XML file, typically named `beans.xml`, is the config source for the
`ApplicationContext`. The `ApplicationContext` is a new and improved
`BeanFactory` (what Spring used to use, and the base class for
`ApplicationContext`; `ApplicationContext` is better for i18n
(internationalization)). `ApplicationContext` also uses eager instantiation
for beans, as opposed to `BeanFactory`'s lazy instantiation.

The `ApplicationContext` represents the IoC container. It lazily instantiates
beans, uses the factory design pattern and removes the need for the
programmatic singleton pattern and decouples dependency config from program
logic.

Sidenote: MVC stands for "model, view, controller", and is a design pattern
for applications. The model is the structure of the data, the view is what
the user sees and the controller is what renders the views.

Spring contains several modules to provide additional functionality to your
program, such as Spring ORM (which abstracts over Hibernate), Spring MVC and
Spring AOP.

These modules can be further combined into _Spring projects_, such as Spring
Boot and Spring Data.

## Bean wiring

Bean wiring is another term for dependency injection in Spring.

Using manual (or explicit) bean wiring means that you need to specify any
dependencies explicitly (e.g. in `beans.xml` or somewhere else). Autowiring
(a type of bean wiring) can be achieved by using the `@Autowired` annotation
or the `autowire` property in the `bean` tag in XML.

There are several values you can use for the `autowire` property:

- `byName`: looks at the property name and attempts to match it to the name
  of a bean
- `byType`: looks at the type of the property and attempts to match it to a
  bean with the same type

The `@Autowired` annotation's default behavior is to search by type, but it
will fall back to name-based search if there is not a unique bean with the
desired type. If there is more than one bean with the same type, and the name
of the property does not match the name of one of the beans, you can use the
`@Qualifier("name of bean")` annotation on the property to disambiguate.

## Spring stereotype annotations

- `@Component`: registers any class as a bean
- `@Service`: for business logic layer; does _not_ indicate a web service.
- `@Repository`: for DAO layer

To enable using these annotations in a package, put this in your Spring
config file (e.g. `beans.xml`):

```xml
<context:annotation-config />
<context:component-scan base-package="<your-package-name>" />
```

## Bean lifecycle

1. Instantiate the bean.
2. Populate properties.
3. If the bean implements `BeanNameAware`, call the `setBeanName` method.
4. For `BeanFactoryAware` beans, call `setBeanFactory`.
5. For `BeanPostProcessors` beans, call `postProcessBeforeInitialization`.
6. For `InitializingBean` beans, call `afterPropertiesSet`.

TODO: fill in the rest.

## Spring ORM

Spring ORM is Spring's module used to integrate data-access code with D.I. It
does not speack with the DB itself; rather, it abstracts a JPA framework such
as Hibernate.

### Configuring Hibernate and Spring: _contextual sessions_

A contextual session is a session with the DB that exists within the
ApplicationContext. It is the process of wiring together a DataSource, a
SessionFactory and a TransactionManager. Once that's done, we can inject our
SessionFactory into each of our repositories (DAOs).

## Spring MVC

MVC stands for "Model-View-Controller":

- Model: encapsulated application data (e.g. POJOs)
- View: rendered content for client view (e.g. HTML, JSP, even JSON)
- Controller: processes user requests (abstraction of servlets)

Spring MVC is a web module following the MVC design pattern. It's centered
around Spring's `DispatcherServlet` (servlet front controller). Spring MVC
allows our apps to process requests.

### Typical request flow

1. HTTP request hits server. All requests are directed to the
   `DispatcherServlet` (D.S.).
2. D.S. consults `HandlerMapping` to assess which controller is appropriate
   for this request.
3. Request reaches controller (`@Controller`/`@RestController`) and is
   processed based on HTTP verbs and URL pattern.
4. Controller returns view name and (potentially) some model data.
5. D.S. consults its view resolver, which finds a view by the name returned
   by the controller.
6. View uses model data to render resource.
7. Resource is returned to user.

### `@Controller` vs `@RestController`

A standard `@Controller` can be used to return any sort of data (HTML, a
rendered JSP, JSON, etc.), while `@RestController` assumes that you are
creating a RESTful API. As a consequence, your controller methods in a
`@RestController` can return objects, which Spring will serialize to JSON to
be sent as the response body. The `@RestController` therefore completely
bypasses the `ViewResolver`.

## Input validation with JSR303
