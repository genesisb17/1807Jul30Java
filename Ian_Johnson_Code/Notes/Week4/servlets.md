# Servlets (`javax.servlet`)

Servlets are Java classes which can handle requests and responses (using any
transfer protocol, but we will work with HTTP). They are structured as follows:

```
Servlet (interface)
|-> GenericServlet (A.C.)
    |-> HttpServlet (A.C.)
        |-> (our custom subclasses)
```

The important "lifecycle" methods of a Servlet are `init`, `service` and
`destroy`. We must override the `service` method to specify how to respond to
request, but this is done for us by `HttpServlet`. Instead, using
`HttpServlet`, we override `doGet`, `doPost`, `doPut`, etc.
