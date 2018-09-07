# Spring full Module application 

This markdown file will describe the project entitled spring-mvc-orm as it will include MVC to make a RESTful API, ORM to persist data, AOP for logging and related aspects, CORS management, and JSR-303 for bean validation. 

## Steps to create a similar application:
* Create Maven WAR project
* Add dependencies to POM
* Create Deployment Descriptor(web.xml)
	* Configure DispatcherServlet, ServletConfig and ServletContext params, and ContextLoaderListener
* Create Spring Bean Configuration File(beans.xml) in WEB-INF folder
	* Add namespaces for context, beans, aop, tx, mvc
	* Configure annotations
	* Configure Contextual Sessions
* Create and annotate model beans
* Create repository layer with CRUD functionality
	* DAO per model bean
	* inject SessionFactory bean with @Autowired annotations
* Add Service layer
	* inject repository into service
* Add Controllers annotated with @RestController
* Create AOP package for aspects


## Notes
### [JSR-303](https://beanvalidation.org/1.0/spec/)
JSR 303 (Bean Validation) is the specification of the Java API for JavaBean validation in Java EE and Java SE. Simply put it provides an easy way of ensuring that the properties of your JavaBean(s) have the right values in them. 

JSR 303 (Bean Validation) is the specification of the Java API for JavaBean validation in Java EE and Java SE. Simply put it provides an easy way of ensuring that the properties of your JavaBean(s) have the right values in them. 

The following are *some* common annotations available in JSR 303. There is also the ability to create your own custom validator. 
* @Pattern - Checks if the annotated string matches the regular expression given. We used it to ensure that the last name and first name properties have valid string values
* @Past - The annotated element must be a date in the past.
* @Min - The annotated element must be a number whose value must be greater or equal to the specified minimum
* @Max - The annotated element must be a number whose value must be lower or equal to the specified maximum
* @NotBlank - Checks that the annotated string is not null and the trimmed length is greater than 0. This annotation is not in JSR 303
* @Email - Checks whether the specified string is a valid email address. This annotation is also not in JSR 303
### AOP

### ORM

### MVC 