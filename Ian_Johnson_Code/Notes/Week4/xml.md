# XML (eXtensible Markup Language)

XML is not a programming language; rather, it is used to store and send data
in a language-agnostic fashion.

XML must be well-formed, or follow basic rules:

- Begin with DTD (doctype declaration).
- Start and end with a unique root element.
- All child elements must be closed before parent elements are closed.
- Elements are case-sensitive.

An XML document is _valid_ if it follows certain predefined rules (specified
in a DTD or XSD [XML Schema Definition]); for example, in a POM, there should
not be an `<html>` element.
