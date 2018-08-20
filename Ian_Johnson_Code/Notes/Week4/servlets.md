# Servlets (`javax.servlet`)

Servlets are Java classes which can handle requests and responses (using any
transfer protocol, but we will work with HTTP). They are structured as follows:

```
Servlet (interface)
|-> GenericServlet (A.C.)
   |-> HTTPServlet (A.C.)
      |-> (our custom subclasses)
```
