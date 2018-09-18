# RESTful API know-how

## Motivation
I place my learning process in this document with 2 motives:

1. To have a quick guide whenever I lost the track of knowledge.
2. To share the knowledge with anyone wants to learn RESTful APIs

## 1. Before, some theory

### What is Rest ?

REST is an architecture style for designing networked applications.
It stands for **RE**presentational **S**tate **T**ransfer.
To explain what does this means in english, continue reading.

### What is not REST?
- A language
- A framework
- A brand
- Software that you can download and make it run.
- A standard (W3C hasn't accepted, so it continues as open style)

### REST constraints
As REST creator, Roy Fielding describes in his [doctoral dissertation](http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm), it was conceived as a whole sets of needs, shaped by the constraints of the environment in which this system was going to be implemented.
Such constraints are:

- Client-Server
- Uniform Interface
- Stateless
- Cacheable
- Layered System
- Code on demand (optional)

### Some definitions before

#### State
A state, is that which the server application cares about to fulfill the request.
This is the chunk of information that is sent by the server in every response.

#### Resource
A resource, is the data that defines a model representation. This might be the stored data in the database.

Note, that, a state is an informacion that depends on the request and the client that is asking for; while the resource is information that is constant through all clients (of course until it needs to be updated).

#### Idempotence
In terms of computer science, this term has a different meaning. It describes an operation that will produce the same result whether it is being called one or many times. In other works, making multiple identical requests has the same effect as making a single one. Imagine a client asking a server to update the resource `user`, setting its property `age` to the value of 20. No matter how many times you ask this. You'll have the same effect on the database.

#### Safety
Speaking of RESTful approach, safety means the ability of a method to not change the state of a resource in the server. This means, all methods that are safety doesn't alter the information (database).
Consequently, clients can make safe requests repeatedly without worry of side effects on the server.


### Client-Server
The web operates in this way: where there is a web server delivering content, that is being interpreted by a browser, or a mobile app.
In this case, the server is usually the web application, and the client, is the browser, or mobile app.
In this scenario, the information flow happens in one way: The client does a request to the server, which after processing such request, delivers a response.

### Uniform Interface
This constraint defines that the interface between any server, and all possibilities of clients, should be the same. This decouples the architecture between client and server, giving the ability to both to evolve separately.

### Stateless
Here it comes what REST means.
Representational State Transfer means that each request has to carry with the necessary state to handle the transaction. This releases the server from keeping a state of information between multiple requests.
Are you familiar with the concept of SESSION in web development ?
REST avoids the existence of it. And because of this, the server gets the ability to scale better.

### Cacheable
This constraint says that each response must define implicitly or explicitly, whether it is a cacheable resource, or not.
By telling a client that such content is cacheable, it optimizes the performance of communication, since the client will avoid unnecesary requests for static data.

### Layered System
This says that from the server side, scalability may be improved in such way that the client won't notice whether it is dealing in one server, or an intermedary app. That let the server side infraestructure to escalate through load balancing, shared caches, and security middlewares.

### Code on demand (optional)
This means that the server might also delivers logic to the client, such as javascript content that might be interpreted by the client.
This is optional, and I think is nowadays not used, since the appearance of Single Page Apps.

## 2. REST How-to

### Principles
Know the best RESTful practices from the community.

#### 1. Use meaningful HTTP verbs.
You know them: GET, POST, PUT, DELETE. Such verbs already mean an intention, and the purpose of REST principles is to use this as an advantage to set clarity for t
he API.

#### 2. Sensible resource names.
In the old times of web development, a resource used to accept parameters from long query strings, such as `/api?model=user&id=123`.
By following this principle, the URI (also called resource name) shoud be as well meaninful as the HTTP verb.
So rewriting the previous URI to a meaningful one, would be `/user/123`.

#### 3. XML and JSON
That's up to the necessities of the client.
If you're going to provide a public API, having both is a good idea, since you have a broad scope of clients that can interact with your app.
But we suggest to favor JSON over XML. This is because the simplicity of its nature as a data container. Also, since most of the clients are browsers, JSON is javascript syntax, which makes perfect to be parsed by the client side.
If you're going to render XML, avoid namespaces, and think of XML as a data container, which is the purpose of the API.

#### 4. Create Fine-Grained Resources
Instead of starting with complex services, focus on basic, simple resources, and provide CRUD operations on them. Additionally you will add complex services over that system.

#### 5. Idempotence for PUT and DELETE
This means that by sending a request with the same state (data) to the server, you'll have the same effect on the domain/database.

#### 6. Safety for HEAD, GET, OPTIONS and TRACE
These methods are defined to be safe, this means, to not alter the state in the server.

### HTTP Verbs
Technically, there are 8 HTTP Methods.
The most used in RESTful APIs are only 4 (GET, POST, PUT and DELETE). They cover CRUD operations on a resource.

1. GET
2. POST
3. PUT
4. DELETE
5. OPTIONS
6. HEAD
7. TRANCE
8. CONNECT

#### 1. GET
GET is used to retrieve information from the server, specifically information of a resource.
If the request goes well, it returns a 200 code. Otherwise, it might return an error code, like 404 or 400

Examples:
```
# Gets a list of all users
GET /api/users
# Gets details for user with id = 23
GET /api/users/23
# Gets a list of all orders belonging to user with id = 23
GET /api/users/23/orders
```
#### 2. POST
POST is used for creating a resource. It accepts usually a JSON body in the request. This data is the state for the resource that is going to be created.
If the execution goes well, it returns a status code 201, with a `location` header with the link to the new created resource.
The POST operation is not safe, since it affects th sate of information.
It is also not an idempotent operation, since everytime a resource creation is requested, the `id` attribute will be auto incremented, making the effect of this operation, unique every time.

Examples:
```
# Inserts a user
POST /api/users
# body
{
  name: "User"
}
```

#### 3. PUT
PUT is used for updating a resource. It accepts usually a JSON body which contains the data of the resource that will be updated.
On succesful execution, it returns a status code 200.
PUT is not a safe operation, since it affects the state of the resource in the server information.
However, PUT is encouraged to be an idempotent operation. This is, by knowing the id of the resource that will be updated, and having certain values that will be written, every operation will cause the same effect on the resource status in the server.

Examples:
```
# Updates a user
PUT /api/users/23
# body
{
  name: "User number 23"
}
```

#### 4. DELETE
DELETE operation is used for deleting a resource identified by a URI.
This is not a safe operation, since it affects the state of the resource in the server.
If the operation goes well, it responds with a satus code of 200.
DELETE operation is idempotent. This is, by calling this operation the first time, the resource will be deleted from the server information storage (database), and by calling the next times, the response should be the same: the resource is gone.

Examples:
```
# Deleting a user
DELETE /api/users/delete/23
```

#### Methods Cheatsheet

| HTTP Method | Resource Operation | Example URI | Response code | Location Header | Safe | Idempotent |
| ----------- | ------------------ | ----------- | ------------- | --------------- | ---- | ---------- |
| GET | Fetch | /api/users, /api/users/{id} | 200 | No | Yes | No |
| POST | Create | /api/users | 201 | Yes | No | No |
| PUT | Update | /api/users/{id} | 200 | No | No | Yes |
| DELETE | Delete | /api/users/{id} | 200 | No | No | Yes |

### Response Status Codes
We will cover the most common codes here. If you want to check the full list, you can go to [MDN page](https://developer.mozilla.org/en-US/docs/Web/HTTP/Response_codes).

- 2xx Success
- 3xx Redirect
- 4xx User error
- 5xx Server error

#### 2xx Success codes
- 200 OK (default code)
- 201 Created (Response for POST requests)
- 202 Accepted (Response for DELETE requests)

#### 4xxx Error codes
- 400 Bad request (generic)
- 401 Unauthorized
- 404 Not found (Bad URL, resource not found)
- 405 Method not allowed (wrong HTTP method)
- 409 Conflict

### Resource Naming Conventions

TODO >> Fill Content here.

## 3. Examples

When you have your api in the same domain that your web app
```
// prefix of /api to encapsulate API into one set of controller/routes
GET /api/users
GET /api/users/{id}

//another controllers in the webapp, traditional HTML response
GET /users
GET /users/{id}
```

When you have a specific domain for API, but different versions ov if
```
// API v1
GET /v1/users
GET /v1/users/{id}

// API v2.3
GET /v2.3/users
GET /v2.3/users/{id}
```

One domain, simple URI
```
GET /users
GET /users/{id}
```

Nested resources
```
//users is the main resource
GET /users
GET /users/{id}

//contracts is a sub resource of users
GET /users/{id}/contracts
GET /users/{id}/contracts/{contract_id}
```

Valid Methods for URIs
```
GET /users
GET /users/{id}
POST /users
PUT /users/{id}
DELETE /users/{id}
```

Invalid Methods for URIs
```
// you cannot create by specifying a specific resource
POST /users/{id}

// You cannot update state for a URI that doesn't represent a specific resource
PUT /users

// You cannot delete a resource if you no provide its specific URI
DELETE /users
```

## References
* [Begineers guide to creating a REST API](http://www.andrewhavens.com/posts/20/beginners-guide-to-creating-a-rest-api/)
* [RESTful best practices](https://github.com/tfredrich/RestApiTutorial.com/raw/master/media/RESTful%20Best%20Practices-v1_2.pdf)
* [Best practices for designing a pragmatical RESTful API](http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api)