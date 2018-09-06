# Hibernate

Hibernate is a Java ORM (Object-Relational Mapping) tool. It allows us to map
Java classes to tables in our database. It abstracts away the JDBC API, and
it implements the Java Persistence API (JPA), which is a set of prescribed
standards for any persistence framework to follow (JPA is actually framed
around Hibernate, which came earlier).

It moves away from SQL to HQL (Hibernate Query Language). HQL is
dialect-agnostic.

## Important interfaces

- `Session`: your connection to the DB. Not to be confused with
  `HttpSession`! It exposes methods used to communicate with the DB: `save()`,
  `get()`, `merge()`, `update()`, `delete()`, `beginTransaction()`, etc.
- `SessionFactory`: used to create session objects (only need one of these).
- `Configuration`: used to create session factory for a DB, specify location
  of configuration file (`hibernate.cfg.xml`). This is actually a class, not
  an interface.
- `Transaction`: used for managing ACID-compliant transactions.
- `Query`: used to carry out complex queries with HQL.
- `Criteria`: used to create complex queries programmatically. Uses builders
  rather than HQL.

## Object state

There are three states that a Java object can have regarding its relationship
with the DB.

- Transient: not yet associated with a row; object just instantiated with the
  `new` keyword. It has no persisted representation or identifier value.
- Persistent: the object has an ID and has persisted representation in the
  DB. It may have been saved or loaded. Hibernate detects any changes made to
  the object in this state and will synchronize the representation at the end
  of the unit of work (this is known as _transactional write-behind_).
- Detached: object has been persisted, but the session is closed. The object
  still has an ID and valid DB representation, but changes made to a detached
  object will not be reflected in the DB until it is reattached to a session
  (and therefore brought back into the persistent state).

It is very important to understand the methods that bring objects between
states and their nuances.

### Automatic dirty checking

When the session is closed, Hibernate checks for changes in any persistent
objects and puts objects into the detached state.

## Caching

_Caching_ is a mechanism to enhance the performance of a system. It is a
buffer memory that lies between the application and the data. Cache memory
stores recently-used data items in order to reduce the number of DB hits as
much as possible. Hibernate has two levels.

### Level 1 (L1) cache

This is the default (no config needed). It is session scoped and can contain
data. If you're doing a lot in one session, you should periodically clear
cache to avoid memory issues: `evict()` removes one object, while `clear()`
removes all objects. `contains()` checks if an object is present in the
cache.

### Level 2 (L2) cache

This level requires configuration from a third-party library (i.e. EHCache).
It is `SessionFactory`-scoped, and can operate according to two strategies:

- Read-only: not expecting objects to change; no overhead to check for
  updates.
- Read-write: good for persistent objects that will be updated by your
  Hibernate app.

## Inheritance strategies

- Table-per-hierarchy: one table for all objects related through a common
  ancestor class.
- Table-per-subclass: one table for each subclass; superclass has its own
  table and contains columns for each of the superclass properties.
- Table-per-concrete-class: one table for each concrete subclass; subclass
  tables have a column for each property, even inherited ones.

## Similar method pairs

### Save vs persist

#### Save

#### Persist

### Merge vs update

#### Merge

- Behavior defined by JPA specification.
- When called on a transient entity, copies values to a new entity.
- When called on a detached entity, copies values to the existing entity.
- Does not change the state of the entity you pass to it.

#### Update

- Original Hibernate method.
- When called on a transient entity, throws an exception.
- When called on a detached entity, "reattaches" it to make it persistent again.

### Get vs load

#### Get

- Returns `null` if the requested entity does not exist.
- Accesses the database immediately (eager).

#### Load

- Throws an exception if the requested entity does not exist.
- Returns a proxy object by default (lazy).
