# Web programming

## Clients and servers

The server is the "back-end"; it can communicate with databases and serve
content over HTTP to the user. A server is just a computer accessible over
Internet or intranet that can receive requests and send responses.

The client is the "front-end", i.e. the user's browser. JavaScript is the
programming language used on the client-side, with HTML and CSS used for
creating and styling web pages. JavaScript can work with your web page using
the DOM (Document Object Model) to create dynamic user experiences.

Here are some client-side tools and terms:

- JSON (JavaScript Object Notation): a plain-text format for data storage and
  transfer.
- AJAX (Asynchronous JavaScript and XML): method to send asynchronous (async)
  requests. We will be using this to send JSON.
- SPA (Single Page Application): a web application that is delivered as a
  single web page. These can be developed using Angular.
- POSTMAN: a "mock front-end" that can be used to send HTTP requests for
  testing and experimentation.
- XML (eXtensible Markup Language): a powerful format for configuration
  files, etc.

## HTML

HyperText Markup Language is the language that describes and defines the
content of a web page and its basic layout.

- HyperText: links that connect web pages to one another, either within a
  single website or between websites.
- Markup language: a system for annotating a document in a way that is
  syntactically distinguishable from the text (e.g. HTML, XML, XHTML).

HTML consists of a series of elements in which you enclose (or wrap)
different parts of the content to make it appear or act a certain way. Tags
begin or end an element in source code, whereas elements are part of the DOM
(Document Object Model), which represents how your page is displayed in the
browser. Here's an example of an element:

```html
<p class="nice">Hello, world!</p>
```

The main parts of an element are the opening tag (which contains
_attributes_, or information about the element), the content and the closing
tag. Some elements do not have content; these elements (such as `<br>`) do
not require a closing tag. HTML (unlike XML) does not require these
content-less elements to have a slash in the opening tag; writing `<br/>` is
not required in HTML as it would be in XML.

An example of a tag with attributes is the standard "responsive" meta tag:

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

## HTML forms

HTML forms allow users to send data to a server. Here are some important tags:

- `<form>`: Defines a form. Acts as a container element that supports
  attributes necessary to configure forms.
  - The `action` attribute defines the location where the form's data should
    be sent when submitted.
  - The `method` attribute defines which HTTP method to use to send the data
    ("GET" or "POST").

## CSS

Cascading Style Sheets is a simple mechanism for adding style (e.g. fonts,
colors, spacing) to web documents.

## JavaScript

JavaScript is a _loosely typed_ language. Type coercion can occur when
performing operations with different types. When using values in an `if`
statement or similar, their _truthiness_ will be evaluated. Most values are
truthy; the only falsy values are:

- `false`
- `0`
- `undefined`
- `null`
- `NaN`
- `''`

## HTTP

HTTP is a stateless, application-layer protocol for communicating between
distributed systems, and is the foundation of the modern web. HTTP assumes
very little about a particular system, and does not keep state between
message exchanges. Communication usually takes place over TCP/IP, but any
reliable transport can be used. The default port for TCP/IP is 80.
Communication between a client and a server occurs via a request/response
pair.

HTTP requests have several methods, some of which can be matched up with CRUD:

- Create: POST
- Read: GET
- Update: PUT
- Delete: DELETE

There are also HEAD, OPTIONS and TRACE, among others.

Key terms:

- Resources: expose easily understood directory structure through URIs (e.g.
  /pokemon/25)
- Representations: transfer JSON or XML to represent data objects and
  attributes
- Messages: use HTTP methods explicitly
- Stateless: interactions store no client context on the server between
  requests

### HTTP verbs

Here are some key terms relating to HTTP methods:

- Safe: a method is safe if it doesn't alter the state of the server (a
  read-only operation).
- Idempotent: a method is idempotent if an identical request can be made once
  or several times in a row with the same effect while leaving the server in
  the same state. All safe methods are also idempotent.
- Cacheable: a cacheable response is an HTTP response that can be cached, or
  stored to be retrieved and used later. Not all HTTP responses can be cached;
  this depends on the HTTP verb used for the request and a few other qualifying
  factors.

Here is a list of the verbs (methods):

- GET: requests a resource
- POST: submits an entity to the specified resource, often causing a change
  in state or side effects on the server
- PUT: updates data
- DELETE: deletes a resource
- HEAD: similar to GET but has no response body (only headers)
- CONNECT: establishes a tunnel to the server identified by the target
  resource
- OPTIONS: describes communication options for the target resource
- TRACE: performs a loop-back test along the path to the target resource
- PATCH: applies partial modifications to a resource

### Status codes

These are used to indicate the result of the HTTP request.

- 1xx: informational
- 2xx: success
- 3xx: redirection
- 4xx: client error
- 5xx: server error
