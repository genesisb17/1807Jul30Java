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
